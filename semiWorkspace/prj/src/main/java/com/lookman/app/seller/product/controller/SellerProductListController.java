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
import com.lookman.app.seller.service.SellerService;
import com.lookman.app.seller.vo.SellerVo;

@WebServlet("/seller/home/product/list")
public class SellerProductListController extends HttpServlet{
	private SellerService ss;
	public SellerProductListController() {
		this.ss=new SellerService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			
			SellerVo loginSellerVo=(SellerVo)req.getSession().getAttribute("loginSellerVo");
			String sellerNo=loginSellerVo.getSellerNo();
			List<ProductVo> pVoList=ss.getProductList(loginSellerVo);
			List<CategoryVo> cVoList=ss.getCategoryList();
			List<ProductSizeVo> psVoList=ss.getSizeList();
			List<ProductColorVo> pcVoList=ss.getColorList();
			
			if(loginSellerVo != null) {
				req.setAttribute("pVoList", pVoList);
				req.setAttribute("cVoList",cVoList );
				req.setAttribute("psVoList",psVoList );
				req.setAttribute("pcVoList",pcVoList );
				req.getRequestDispatcher("/WEB-INF/views/seller/product/list.jsp").forward(req, resp);			
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
