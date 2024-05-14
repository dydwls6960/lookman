package com.lookman.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookman.app.member.vo.MemberVo;

@WebServlet("/member/profile")
public class MemberProfileController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo loginMemberVo = (MemberVo) req.getSession().getAttribute("loginMemberVo");

		if (loginMemberVo != null) {
			// do something if req profile.jsp needs

			req.getRequestDispatcher("/WEB-INF/views/member/profile.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("/app/member/login");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
