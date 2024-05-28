package com.lookman.app.sellerHome.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookman.app.product.vo.ProductVo;
import com.lookman.app.seller.service.SellerService;
import com.lookman.app.seller.vo.SellerProductInquiryVo;
import com.lookman.app.seller.vo.SellerSimpleOrderListVo;
import com.lookman.app.seller.vo.SellerStatusVo;
import com.lookman.app.seller.vo.SellerVo;

@WebServlet("/seller/home")
public class SellerHomeController extends HttpServlet{
	
	private SellerService ss;
	public SellerHomeController() {
		this.ss=new SellerService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			
			SellerVo loginSellerVo=(SellerVo)req.getSession().getAttribute("loginSellerVo");
			String sellerNo=loginSellerVo.getSellerNo();
			SellerStatusVo ssVo= ss.getSellerStatus(sellerNo);
			List<ProductVo> pVoList=ss.getProductListRowNum3(loginSellerVo);
			List<SellerProductInquiryVo> spiVoList=ss.getProductInquiryListRowNum3(loginSellerVo);
			List<SellerSimpleOrderListVo> ssoVoList=ss.getSimplerOrderListRowNum3(loginSellerVo);
			
//			&& ssVo != null && pVoList !=null && spiVoList != null && ssoVoList != null
			
			if(loginSellerVo != null ) {
				req.setAttribute("ssVo", ssVo);
				req.setAttribute("pVoList", pVoList);
				req.setAttribute("spiVoList", spiVoList);
				req.setAttribute("ssoVoList", ssoVoList);
				req.getRequestDispatcher("/WEB-INF/views/seller/home.jsp").forward(req, resp);
			}else {
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
