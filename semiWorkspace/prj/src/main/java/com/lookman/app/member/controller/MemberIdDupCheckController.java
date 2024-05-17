package com.lookman.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookman.app.member.service.MemberService;

@WebServlet("/member/id-dup")
public class MemberIdDupCheckController extends HttpServlet {
	private MemberService ms;

	public MemberIdDupCheckController() {
		this.ms = new MemberService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			String id = req.getParameter("id");
			System.out.println(id);
			boolean isAvailable = ms.checkIdDup(id);

			if (!isAvailable) {
				throw new Exception("중복검사 실패..");
			}

			resp.getWriter().write("ok");
			
		} catch (Exception e) {
			System.out.println("중복된 아이디입니다.");
			resp.getWriter().write("bad");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
