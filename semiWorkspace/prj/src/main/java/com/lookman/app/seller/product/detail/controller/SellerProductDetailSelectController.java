package com.lookman.app.seller.product.detail.controller;

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
import com.lookman.app.seller.product.vo.SellerProductListVo;
import com.lookman.app.seller.product.vo.SellerProductSearchVo;
import com.lookman.app.seller.service.SellerService;
import com.lookman.app.seller.vo.SellerVo;

@WebServlet("/seller/home/product/list/detail/select")
public class SellerProductDetailSelectController extends HttpServlet{
	private SellerService ss;
	public SellerProductDetailSelectController() {
		this.ss=new SellerService();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			
			SellerVo loginSellerVo=(SellerVo)req.getSession().getAttribute("loginSellerVo");
			String productNo = (String) session.getAttribute("selectProductNo");
			
			String categoryNo=req.getParameter("s-cate");
			String sizeNo=req.getParameter("s-size");
			String colorNo=req.getParameter("s-color");
			
			SellerProductSearchVo spsVo=new SellerProductSearchVo();
			spsVo.setCategoryNo(categoryNo);
			spsVo.setSizeNo(sizeNo);
			spsVo.setColorNo(colorNo);
			
			System.out.println(spsVo);
			List<SellerProductListVo> splVoList=ss.getProductDetailSearchList(spsVo,loginSellerVo,productNo);
			List<CategoryVo> cVoList=ss.getCategoryList();
			List<ProductColorVo> pcVoList=ss.getColorList();
			List<ProductSizeVo> psVoList=ss.getSizeList();
			
			req.setAttribute("splVoList", splVoList);
			req.setAttribute("cVoList",cVoList );
			req.setAttribute("pcVoList",pcVoList );
			req.setAttribute("psVoList",psVoList );
			
			
			req.getRequestDispatcher("/WEB-INF/views/seller/product/detail/select.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", "[ERROR-S0002]판매자 상품상세검색 중 에러 발생...");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
