package com.lookman.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookman.app.member.service.MemberService;

@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/user/join.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			// userinfo
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			String pwd2 = req.getParameter("pwd2");
			String name = req.getParameter("name");
			String phone = req.getParameter("phone");

			// address
			String postcode = req.getParameter("postcode");
			String address = req.getParameter("address");
			String address2 = req.getParameter("address2");
			String extraAddress = req.getParameter("extraAddress");

			MemberService ms = new MemberService();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
