package com.lookman.app.address.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.lookman.app.address.service.AddressService;
import com.lookman.app.address.vo.AddressVo;

@WebServlet("/address/rest")
public class AddressRestController extends HttpServlet {
	private final AddressService as;

	public AddressRestController() {
		this.as = new AddressService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String addressNo = req.getParameter("addressNo");
			AddressVo avo = as.getAddressByNo(addressNo);
			Gson gson = new Gson();
			String jsonStr = gson.toJson(avo);
			System.out.println(jsonStr);
			resp.setContentType("application/json;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(jsonStr);
			out.flush();
			
		} catch (Exception e) {
			PrintWriter out = resp.getWriter();
			out.write("bad");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
