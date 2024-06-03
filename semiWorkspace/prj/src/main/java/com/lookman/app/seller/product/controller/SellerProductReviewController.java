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
import com.lookman.app.seller.service.SellerService;
import com.lookman.app.seller.vo.SellerVo;

@WebServlet("/seller/home/product/review")
public class SellerProductReviewController extends HttpServlet{
	private SellerService ss;
	public SellerProductReviewController() {
		this.ss=new SellerService();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			
			SellerVo loginSellerVo=(SellerVo)req.getSession().getAttribute("loginSellerVo");
			String sellerNo=loginSellerVo.getSellerNo();
			
			List<SellerProductReviewListVo> sprVoList=ss.getReviewListRownum3(loginSellerVo);
			if(loginSellerVo != null) {
				req.setAttribute("sprVoList", sprVoList);
				req.getRequestDispatcher("/WEB-INF/views/seller/product/review.jsp").forward(req, resp);
				
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
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
}
