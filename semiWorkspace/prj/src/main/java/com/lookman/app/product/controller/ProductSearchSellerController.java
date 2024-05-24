package com.lookman.app.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookman.app.product.dto.ProductByDto;
import com.lookman.app.product.service.ProductService;

@WebServlet("/search-by-store")
public class ProductSearchSellerController extends HttpServlet {
	private final ProductService ps;

	public ProductSearchSellerController() {
		this.ps = new ProductService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String sellerNo = req.getParameter("sellerNo");
			List<ProductByDto> dtoList = ps.selectProductBySellerNo(sellerNo);
			req.setAttribute("dtoList", dtoList);
			req.getRequestDispatcher("/WEB-INF/views/product/product-by-seller.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
