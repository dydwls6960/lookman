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

@WebServlet("/ranking")
public class ProductRankingController extends HttpServlet {
	private ProductService ps;

	public ProductRankingController() {
		this.ps = new ProductService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			List<ProductHomeDto> dtoList = ps.selectProductsRanking();

			req.setAttribute("dtoList", dtoList);
			req.getRequestDispatcher("/WEB-INF/views/product/ranking.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
