package com.lookman.app.seller.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookman.app.seller.product.vo.SellerProductReviewListVo;
import com.lookman.app.seller.product.vo.SellerProductSearchVo;
import com.lookman.app.seller.service.SellerService;
import com.lookman.app.seller.vo.SellerVo;

@WebServlet("/seller/home/product/review/select")
public class SellerProductSelectReviewController extends HttpServlet{
	private SellerService ss;
	public SellerProductSelectReviewController() {
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
			String sellerNo=loginSellerVo.getSellerNo();
			String search=req.getParameter("s-len");
			String searchText=req.getParameter("searchListText");
			if (searchText == null || searchText.isEmpty()) {
			    searchText = "all";
			}
			SellerProductSearchVo spsVo=new SellerProductSearchVo();
			spsVo.setSearch(search);
			spsVo.setSearchText(searchText);
			
			List<SellerProductReviewListVo> sprVoList=ss.getReviewList(loginSellerVo,spsVo);
			if(loginSellerVo != null) {
				req.setAttribute("sprVoList", sprVoList);
				req.getRequestDispatcher("/WEB-INF/views/seller/product/selectReview.jsp").forward(req, resp);			
			}else {
				session.setAttribute("alertMsg", "로그인 하고 와주세요");
				resp.sendRedirect("/app/seller/login");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", "[ERROR-S0001]판매자 홈조회 중 에러 발생...");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
