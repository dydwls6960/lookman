package com.lookman.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookman.app.member.service.MemberService;
import com.lookman.app.member.vo.AddressVo;
import com.lookman.app.member.vo.MemberVo;

@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet {

	private MemberService ms;

	public MemberJoinController() {
		this.ms = new MemberService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MemberVo loginMemberVo = (MemberVo) req.getSession().getAttribute("loginMemberVo");

		if (loginMemberVo != null) {
			resp.sendRedirect("/app/home");
		} else {
			req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			// memberVo
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			String pwd2 = req.getParameter("pwd2");
			String name = req.getParameter("name");
			String phone = req.getParameter("phone");

			MemberVo mvo = new MemberVo();
			mvo.setId(id);
			mvo.setPwd(pwd);
			mvo.setPwd2(pwd2);
			mvo.setName(name);
			mvo.setPhoneNo(phone);

			// addressVo
			String postcode = req.getParameter("postcode");
			String address = req.getParameter("address");
			String address2 = req.getParameter("address2");
			String extraAddress = req.getParameter("extraAddress");

			AddressVo avo = new AddressVo();
			avo.setPostcode(postcode);
			avo.setAddress(address);
			avo.setDetailedAddress(address2);
			avo.setExtraAddress(extraAddress);

			HttpSession session = req.getSession();
			// result
			int result = ms.join(mvo, avo);
			if (result != 1) {
				session.setAttribute("alertMsg", "회원가입 실패..");
				resp.sendRedirect("/app/member/join");
			}

			session.setAttribute("alertMsg", "회원가입 성공!");
			resp.sendRedirect("/app/member/login");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			String errMsg = e.getMessage();
			System.out.println(e.getMessage());
			req.setAttribute("errMsg", errMsg);
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}

	}
}
