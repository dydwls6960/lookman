package com.lookman.app.seller.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookman.app.seller.product.vo.SellerProductInquiryVo;
import com.lookman.app.seller.product.vo.SellerProductSearchVo;
import com.lookman.app.seller.service.SellerService;
import com.lookman.app.seller.vo.SellerVo;

@WebServlet("/seller/home/product/inquiry/select")
public class SellerProductSelectInquiryController extends HttpServlet {
	private SellerService ss;
	public SellerProductSelectInquiryController() {
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
			String statusNo=req.getParameter("s-status");
			
			SellerProductSearchVo spsVo=new SellerProductSearchVo();
			spsVo.setSearch(search);
			spsVo.setSearchText(searchText);
			spsVo.setStatusNo(statusNo);
			
			if(loginSellerVo!=null) {
				List<SellerProductInquiryVo> spiVoList=ss.getProductInquirySelectList(spsVo,loginSellerVo);	//수정완료
				req.setAttribute("spiVoList", spiVoList);
			}
			req.getRequestDispatcher("/WEB-INF/views/seller/product/selectInquiry.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", "[ERROR-S0003]상담 리스트 중 에러 발생...");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
