package com.lookman.app.category.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookman.app.category.service.CategoryService;
import com.lookman.app.category.vo.CategoryVo;

@WebServlet("/category")
public class ProductCategoryController extends HttpServlet {
	private final CategoryService cs;

	public ProductCategoryController() {
		this.cs = new CategoryService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			List<CategoryVo> cvoList = cs.selectCategory();
			System.out.println(cvoList);
			req.setAttribute("cvoList", cvoList);
			req.getRequestDispatcher("/WEB-INF/views/category/category.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
