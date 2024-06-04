package com.lookman.app.admin.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookman.app.admin.member.vo.AdminOrderListVo;
import com.lookman.app.admin.service.AdminService;
import com.lookman.app.admin.vo.AdminVo;
import com.lookman.app.admin.vo.CouponListVo;
import com.lookman.app.admin.vo.ReportListVo;
import com.lookman.app.admin.vo.UserVo;
import com.lookman.app.seller.vo.SellerStateVo;

@WebServlet("/admin/order")
public class AdminOrderController extends HttpServlet {
	private AdminService as;
	public AdminOrderController() {
		this.as=new AdminService();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			AdminVo loginAdminVo=(AdminVo)req.getSession().getAttribute("loginAdminVo");
			if(loginAdminVo!=null) {			
				List<AdminOrderListVo> aolVoList=as.getOrserList();
				
				req.setAttribute("aolVoList", aolVoList);
				req.getRequestDispatcher("/WEB-INF/views/admin/member/order.jsp").forward(req, resp);
			}else {
				session.setAttribute("alertMsg", "로그인 하고 와주세요");
				req.getRequestDispatcher("/WEB-INF/views/admin/login.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", "[ERROR-M0002]로그인 중 에러 발생...");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
}
