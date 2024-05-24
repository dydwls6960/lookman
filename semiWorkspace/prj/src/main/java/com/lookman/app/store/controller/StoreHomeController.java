package com.lookman.app.store.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookman.app.seller.vo.SellerVo;
import com.lookman.app.store.service.StoreService;

@WebServlet("/store")
public class StoreHomeController extends HttpServlet {
	private final StoreService sts;

	public StoreHomeController() {
		this.sts = new StoreService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			List<SellerVo> svoList = sts.selectStore();
			req.setAttribute("svoList", svoList);
			req.getRequestDispatcher("/WEB-INF/views/store/store.jsp").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
