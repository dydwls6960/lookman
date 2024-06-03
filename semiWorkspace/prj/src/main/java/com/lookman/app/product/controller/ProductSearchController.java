package com.lookman.app.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookman.app.product.dto.ProductHomeDto;
import com.lookman.app.product.service.ProductService;

@WebServlet("/search")
public class ProductSearchController extends HttpServlet {

	private final ProductService ps;

	public ProductSearchController() {
		this.ps = new ProductService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String name = req.getParameter("name");
			if (name == null || name.length() == 0) {
				resp.sendRedirect("/app/home");
				return;
			}

			List<ProductHomeDto> dtoList = ps.searchProducts(name);
			req.setAttribute("dtoList", dtoList);
			req.getRequestDispatcher("/WEB-INF/views/product/product-by-category.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
