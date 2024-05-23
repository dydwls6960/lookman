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
public class CategoryHomeController extends HttpServlet {
	private final CategoryService cs;

	public CategoryHomeController() {
		this.cs = new CategoryService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			List<CategoryVo> cvoList = cs.selectCategory();
			req.setAttribute("cvoList", cvoList);
			req.getRequestDispatcher("/WEB-INF/views/category/category.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
