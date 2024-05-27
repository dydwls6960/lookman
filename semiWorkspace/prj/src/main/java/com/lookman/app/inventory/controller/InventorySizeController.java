package com.lookman.app.inventory.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.lookman.app.inventory.service.InventoryService;
import com.lookman.app.product.dto.ProductInventoryDto;

@WebServlet("/get-size")
public class InventorySizeController extends HttpServlet {
	private final InventoryService is;

	public InventorySizeController() {
		this.is = new InventoryService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String colorNo = req.getParameter("colorNo");
			String productNo = req.getParameter("productNo");
			ProductInventoryDto idto = new ProductInventoryDto();
			idto.setProductNo(productNo);
			idto.setColorNo(colorNo);
			
			List<ProductInventoryDto> idtoList = is.getSizeOptions(idto);
			resp.setContentType("application/json");
			PrintWriter out= resp.getWriter();
			out.print(new Gson().toJson(idtoList));
			out.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}

}
