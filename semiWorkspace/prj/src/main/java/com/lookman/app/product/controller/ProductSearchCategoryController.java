package com.lookman.app.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookman.app.product.dto.ProductByCategoryDto;
import com.lookman.app.product.service.ProductService;

@WebServlet("/search-by-category")
public class ProductSearchCategoryController extends HttpServlet {
	private final ProductService ps;

	public ProductSearchCategoryController() {
		this.ps = new ProductService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String categoryNo = req.getParameter("categoryNo");
			List<ProductByCategoryDto> dtoList = ps.selectProductByCategoryNo(categoryNo);
			req.setAttribute("dtoList", dtoList);
			req.getRequestDispatcher("/WEB-INF/views/product/product-by-category.jsp").forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}

	}
}
