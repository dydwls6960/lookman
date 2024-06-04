package com.lookman.app.seller.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookman.app.category.vo.CategoryVo;
import com.lookman.app.product.vo.ProductColorVo;
import com.lookman.app.product.vo.ProductSizeVo;
import com.lookman.app.seller.product.vo.SellerProductInquiryVo;
import com.lookman.app.seller.product.vo.SellerProductListVo;
import com.lookman.app.seller.product.vo.SellerProductSearchVo;
import com.lookman.app.seller.service.SellerService;
import com.lookman.app.seller.vo.SellerVo;

@WebServlet("/seller/home/product/inquiry/update")
public class SellerProductInquiryUpdateController extends HttpServlet{
	private SellerService ss;
	public SellerProductInquiryUpdateController() {
		this.ss=new SellerService();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			
			SellerVo loginSellerVo=(SellerVo)req.getSession().getAttribute("loginSellerVo");
			String productInquiryNo = req.getParameter("productInquiryNo");
			System.out.println(productInquiryNo);
			SellerProductInquiryVo spiVo=ss.getProductInquirySelect(loginSellerVo,productInquiryNo);	//수정완료
			
			
			
			session.setAttribute("spiVo", spiVo);
			session.setAttribute("pNo", productInquiryNo);
			req.getRequestDispatcher("/WEB-INF/views/seller/product/inquiry/update.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", "[ERROR-S0002]판매자 상품상세검색 중 에러 발생...");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			
			SellerVo loginSellerVo=(SellerVo)req.getSession().getAttribute("loginSellerVo");
			String productInquiryNo = (String)req.getSession().getAttribute("pNo");
			String askText=req.getParameter("askText");
			System.out.println(askText);
			System.out.println(productInquiryNo);
			int result=ss.updateInquiry(loginSellerVo,productInquiryNo,askText);
			SellerProductInquiryVo spiVo=ss.getProductInquirySelect(loginSellerVo,productInquiryNo);	//수정완료
			
			session.setAttribute("spiVo", spiVo);
			req.getRequestDispatcher("/WEB-INF/views/seller/product/inquiry/update.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", "[ERROR-S0002]판매자 상품상세검색 중 에러 발생...");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
