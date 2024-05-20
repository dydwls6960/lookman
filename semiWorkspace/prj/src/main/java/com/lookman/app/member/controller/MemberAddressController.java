package com.lookman.app.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookman.app.address.dto.AddressDto;
import com.lookman.app.member.service.MemberService;
import com.lookman.app.member.vo.MemberVo;

@WebServlet("/member/address")
public class MemberAddressController extends HttpServlet {
	private MemberService ms;

	public MemberAddressController() {
		this.ms = new MemberService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			MemberVo loginMemberVo = (MemberVo) req.getSession().getAttribute("loginMemberVo");

			if (loginMemberVo != null) {

				List<AddressDto> addresses = ms.selectAddressesByMemberNo(loginMemberVo);

				req.setAttribute("pageTitle", "내 주소 관리");
				req.setAttribute("loginMemberVo", loginMemberVo);
				req.setAttribute("addresses", addresses);
				req.getRequestDispatcher("/WEB-INF/views/member/address.jsp").forward(req, resp);
			} else {
				resp.sendRedirect("/app/member/login");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
