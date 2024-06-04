package com.lookman.app.admin.statistics.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookman.app.admin.service.AdminService;
import com.lookman.app.admin.vo.AdminVo;
import com.lookman.app.admin.vo.UserVo;
import com.lookman.app.seller.order.vo.SellerOrderListVo;
import com.lookman.app.seller.service.SellerService;
import com.lookman.app.seller.vo.SellerStateVo;
import com.lookman.app.seller.vo.SellerStatisticsVo;
import com.lookman.app.seller.vo.SellerVo;

@WebServlet("/admin/statistics")
public class AdminStatisticsController extends HttpServlet {
	private AdminService as;
	private SellerService ss;
	public AdminStatisticsController() {
		this.as=new AdminService();
		this.ss=new SellerService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			
			AdminVo loginAdminVo=(AdminVo)req.getSession().getAttribute("loginAdminVo");
			if(loginAdminVo!=null) {
				UserVo uVo=as.getUserCnt(loginAdminVo);
				SellerStateVo spsVo= ss.getSellerStatus(); 										//수정완료
				SellerStatisticsVo sssVo=ss.getSellerStatistics();
				List<SellerOrderListVo> solVoList=ss.getSimplerOrderListPrice();			//수정완료
				
				
				req.setAttribute("uVo", uVo);
				req.setAttribute("spsVo", spsVo);
				req.setAttribute("sssVo", sssVo);
				req.setAttribute("solVoList", solVoList);
				req.getRequestDispatcher("/WEB-INF/views/admin/statistics/statistics.jsp").forward(req, resp);
				
			}else {
				session.setAttribute("alertMsg", "로그인 하고 와주세요");
				req.getRequestDispatcher("/WEB-INF/views/admin/login.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", "[ERROR-S0001]관리자 홈조회 중 에러 발생...");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
}
