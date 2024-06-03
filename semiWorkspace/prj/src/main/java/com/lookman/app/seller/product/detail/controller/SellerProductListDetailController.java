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
import com.lookman.app.seller.service.SellerService;
import com.lookman.app.seller.vo.SellerVo;

@WebServlet("/seller/home/product/list/detail")
public class SellerProductListDetailController extends HttpServlet{
	private SellerService ss;
	public SellerProductListDetailController() {
		this.ss=new SellerService();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			
			SellerVo loginSellerVo=(SellerVo)req.getSession().getAttribute("loginSellerVo");
			String sellerNo=loginSellerVo.getSellerNo();
			String productNo = req.getParameter("productNo");
			List<SellerProductListVo> splVoList=ss.getProductListDetail(loginSellerVo,productNo);			//수정완료
			List<CategoryVo> cVoList=ss.getCategoryList();
			List<ProductColorVo> pcVoList=ss.getColorList();
			List<ProductSizeVo> psVoList=ss.getSizeList();
			
			
			if(loginSellerVo != null) {
				req.setAttribute("splVoList", splVoList);
				req.setAttribute("cVoList",cVoList );
				req.setAttribute("pcVoList",pcVoList );
				req.setAttribute("psVoList",psVoList );
				session.setAttribute("selectProductNo", productNo);
				req.getRequestDispatcher("/WEB-INF/views/seller/product/detail/list.jsp").forward(req, resp);			
			}else {
				resp.sendRedirect("/app/seller/login");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", "[ERROR-S0002]판매자 리스트 중 에러 발생...");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
