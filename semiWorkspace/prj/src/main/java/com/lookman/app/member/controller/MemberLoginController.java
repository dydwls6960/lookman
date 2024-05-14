package com.lookman.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookman.app.member.service.MemberService;
import com.lookman.app.member.vo.MemberVo;

@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet {

	private MemberService ms;

	public MemberLoginController() {
		this.ms = new MemberService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// session
			HttpSession session = req.getSession();

			// data
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");

			MemberVo mvo = new MemberVo();
			mvo.setId(id);
			mvo.setPwd(pwd);

			// result
			MemberVo loginMemberVo = ms.login(mvo);

			if (loginMemberVo != null) {
				session.setAttribute("alertMsg", "로그인 성공!");
				session.setAttribute("loginMemberVo", loginMemberVo);
			} else {
				session.setAttribute("alertMsg", "로그인 실패...");
			}

			resp.sendRedirect("/app/home");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
			String errMsg = e.getMessage();
			req.setAttribute("errMsg", errMsg);
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}

	}

}
