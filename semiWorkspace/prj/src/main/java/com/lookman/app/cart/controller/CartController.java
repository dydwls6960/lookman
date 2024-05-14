package com.lookman.app.cart.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookman.app.member.vo.MemberVo;

@WebServlet("/member/cart")
public class CartController extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	MemberVo loginMemberVo = (MemberVo) req.getSession().getAttribute("loginMemberVo");

	if (loginMemberVo != null) {
		req.setAttribute("pageTitle", "장바구니"); // nav-with-header.jsp 에서 사용
		req.getRequestDispatcher("/WEB-INF/views/cart/cart.jsp").forward(req, resp);
	} else {
		resp.sendRedirect("/app/member/login");
	}
}

@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
