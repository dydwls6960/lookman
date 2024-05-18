package com.lookman.app.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookman.app.product.service.ProductService;
import com.lookman.app.product.vo.ProductVo;

@WebServlet(value ={"/products", "/home"})
public class ProductHomeController extends HttpServlet {
	private ProductService ps;

	public ProductHomeController() {
		this.ps = new ProductService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			System.out.println("hello world");
			List<ProductVo> pvoList = ps.selectProducts();
			
			req.setAttribute("pvoList", pvoList);
			req.getRequestDispatcher("/WEB-INF/views/product/home.jsp").forward(req, resp);
			
		} catch (Exception e) {
			req.setAttribute("errMsg", e.getMessage());
			e.printStackTrace();
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
