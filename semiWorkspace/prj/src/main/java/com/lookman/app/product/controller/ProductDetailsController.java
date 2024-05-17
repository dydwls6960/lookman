package com.lookman.app.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookman.app.product.service.ProductService;
import com.lookman.app.product.vo.ProductVo;

@WebServlet("/products/*")
public class ProductDetailsController extends HttpServlet {
	private ProductService ps;

	public void ProductDetailsController() {
		this.ps = new ProductService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// data

			String pathInfo = req.getPathInfo();
			if (pathInfo == null || pathInfo.equals("/")) {
				resp.sendRedirect("/app/products");
				return;
			}

			String productNo = pathInfo.substring(1);
//			
//			ProductVo pvo = ps.selectProductByNo(productNo);
//			req.setAttribute("pvo", pvo);
			req.getRequestDispatcher("/WEB-INF/views/product/details.jsp").forward(req, resp);

		} catch (Exception e) {
			// TODO: handle exception
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
