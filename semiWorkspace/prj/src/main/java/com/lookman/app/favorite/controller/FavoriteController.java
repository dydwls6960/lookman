package com.lookman.app.favorite.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookman.app.member.vo.MemberVo;

@WebServlet("/member/favorite")
public class FavoriteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo loginMemberVo = (MemberVo) req.getSession().getAttribute("loginMemberVo");

		if (loginMemberVo != null) {
			// get ArrayList of favItems

			// set req.setAttribute("favoriteVoList", favoriteVoList);

			req.getRequestDispatcher("/WEB-INF/views/favorite/favorite.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("/app/member/login");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);

	}
}
