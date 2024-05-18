package com.lookman.app.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookman.app.image.dao.ImageDao;
import com.lookman.app.image.vo.ImageVo;
import com.lookman.app.product.dto.ProductDetailsDto;
import com.lookman.app.product.service.ProductService;

@WebServlet("/products/*")
public class ProductDetailsController extends HttpServlet {
	private ProductService ps;

	public ProductDetailsController() {
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
			
			ProductDetailsDto dto = ps.selectProductDetails(productNo);
			
			
			req.getRequestDispatcher("/WEB-INF/views/product/details.jsp").forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
