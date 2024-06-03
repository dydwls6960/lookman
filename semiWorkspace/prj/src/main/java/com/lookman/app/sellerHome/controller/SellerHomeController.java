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
import com.lookman.app.seller.order.vo.SellerOrderListVo;
import com.lookman.app.seller.product.vo.SellerProductInquiryVo;
import com.lookman.app.seller.product.vo.SellerProductListVo;
import com.lookman.app.seller.service.SellerService;
import com.lookman.app.seller.vo.SellerInquiryVo;
import com.lookman.app.seller.vo.SellerStateVo;
import com.lookman.app.seller.vo.SellerSimpleOrderListVo;
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
			if(loginSellerVo!=null) {
				String sellerNo=loginSellerVo.getSellerNo();
				SellerStateVo spsVo= ss.getSellerStatus(sellerNo); 										//수정완료
				SellerInquiryVo siVo=ss.getSellerInquiryVo(sellerNo);									//수정완료
				List<SellerProductListVo> splVoList=ss.getProductListRowNum3(loginSellerVo);			//수정완료
				List<SellerProductInquiryVo> spiVoList=ss.getProductInquiryListRowNum3(loginSellerVo);	//수정완료
				List<SellerOrderListVo> solVoList=ss.getSimplerOrderListRowNum3(loginSellerVo);			//수정완료
				
				req.setAttribute("spsVo", spsVo);
				req.setAttribute("siVo", siVo);
				req.setAttribute("splVoList", splVoList);
				req.setAttribute("spiVoList", spiVoList);
				req.setAttribute("solVoList", solVoList);
				req.getRequestDispatcher("/WEB-INF/views/seller/home.jsp").forward(req, resp);
				
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
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
