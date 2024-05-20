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

@WebServlet("/member/edit")
public class MemberEditController extends HttpServlet {
	private MemberService ms;

	public MemberEditController() {
		this.ms = new MemberService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo loginMemberVo = (MemberVo) req.getSession().getAttribute("loginMemberVo");

		if (loginMemberVo != null) {
			req.setAttribute("pageTitle", "내 정보 수정");
			req.setAttribute("loginMemberVo", loginMemberVo);

			req.getRequestDispatcher("/WEB-INF/views/member/edit.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("/app/member/login");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String memberNo = req.getParameter("memberNo");
			String id = req.getParameter("id");
			String currentPwd = req.getParameter("currentPwd");
			String newPwd = req.getParameter("newPwd");
			String confirmNewPwd = req.getParameter("confirmNewPwd");
			String name = req.getParameter("name");
			String phone = req.getParameter("phone");

			MemberVo mvo = new MemberVo();
			mvo.setMemberNo(memberNo);
			mvo.setId(id);
			mvo.setPwd(currentPwd);
			mvo.setNewPwd(newPwd);
			mvo.setNewPwd2(confirmNewPwd);
			mvo.setName(name);
			mvo.setPhoneNo(phone);

			int result = ms.edit(mvo);

			if (result != 1) {
				throw new Exception("회원정보 수정 중 예외 발생");
			}

			HttpSession session = req.getSession();
			session.setAttribute("alertMsg", "회원정보 수정 완료");
			session.removeAttribute("loginMemberVo");
			resp.sendRedirect("/app/member/login");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("alertMsg", e.getMessage());
			doGet(req, resp);
		}

	}
}
