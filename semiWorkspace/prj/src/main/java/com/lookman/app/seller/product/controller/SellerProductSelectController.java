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
import com.lookman.app.product.vo.ProductVo;
import com.lookman.app.seller.product.vo.SellerProductSearchVo;
import com.lookman.app.seller.service.SellerService;
import com.lookman.app.seller.vo.SellerVo;

@WebServlet("/seller/home/product/list/select")
public class SellerProductSelectController extends HttpServlet{
	private SellerService ss;
	public SellerProductSelectController() {
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
			
			String search=req.getParameter("s-len");
			String searchText=req.getParameter("searchListText");
			if (searchText == null || searchText.isEmpty()) {
			    searchText = "all";
			}
			String categoryNo=req.getParameter("s-cate");
			String sizeNo=req.getParameter("s-size");
			String colorNo=req.getParameter("s-color");
			
			SellerProductSearchVo spsVo=new SellerProductSearchVo();
			spsVo.setSearch(search);
			spsVo.setSearchText(searchText);
			spsVo.setCategoryNo(categoryNo);
			spsVo.setSizeNo(sizeNo);
			spsVo.setColorNo(colorNo);
			
			System.out.println(spsVo);
			List<ProductVo> pVoList=ss.getProductSearchList(spsVo,loginSellerVo);
			List<CategoryVo> cVoList=ss.getCategoryList();
			List<ProductSizeVo> psVoList=ss.getSizeList();
			List<ProductColorVo> pcVoList=ss.getColorList();
			req.setAttribute("pVoList", pVoList);
			req.setAttribute("cVoList",cVoList );
			req.setAttribute("psVoList",psVoList );
			req.setAttribute("pcVoList",pcVoList );
			
			
			req.getRequestDispatcher("/WEB-INF/views/seller/product/select.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", "[ERROR-S0002]판매자 상품검색 중 에러 발생...");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
		
	}
}
