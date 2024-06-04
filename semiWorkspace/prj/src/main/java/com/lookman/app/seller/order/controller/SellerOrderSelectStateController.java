package com.lookman.app.seller.order.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookman.app.seller.order.vo.SellerOrderListVo;
import com.lookman.app.seller.product.vo.SellerProductSearchVo;
import com.lookman.app.seller.service.SellerService;
import com.lookman.app.seller.vo.SellerVo;

@WebServlet("/seller/home/order/state/select")
public class SellerOrderSelectStateController extends HttpServlet{
	private SellerService ss;
	public SellerOrderSelectStateController() {
		this.ss=new SellerService();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			
			SellerVo loginSellerVo=(SellerVo)req.getSession().getAttribute("loginSellerVo");
			if(loginSellerVo!=null) {
				String sellerNo=loginSellerVo.getSellerNo();
				String search=req.getParameter("s-len");
				String searchText=req.getParameter("searchListText");
				if (searchText == null || searchText.isEmpty()) {
				    searchText = "all";
				}
				String statusNo=req.getParameter("s-status");
				
				SellerProductSearchVo spsVo=new SellerProductSearchVo();
				spsVo.setSearch(search);
				spsVo.setSearchText(searchText);
				spsVo.setStatusNo(statusNo);
				
				List<SellerOrderListVo> solVoList=ss.getSimplerOrderSearchList(loginSellerVo,spsVo);	
				req.setAttribute("solVoList", solVoList);
				req.getRequestDispatcher("/WEB-INF/views/seller/order/selectState.jsp").forward(req, resp);
			}else {
				session.setAttribute("alertMsg", "로그인 하고 와주세요");
				req.getRequestDispatcher("/WEB-INF/views/seller/login.jsp").forward(req, resp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", "[ERROR-S0001]판매자 홈조회 중 에러 발생...");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}
}
