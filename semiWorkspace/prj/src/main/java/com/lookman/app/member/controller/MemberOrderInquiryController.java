package com.lookman.app.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookman.app.inquiry.dto.OrderMemberInquiryDto;
import com.lookman.app.member.service.MemberService;
import com.lookman.app.member.vo.MemberVo;

@WebServlet("/member/order-inquiry")
public class MemberOrderInquiryController extends HttpServlet {

	private final MemberService ms;

	public MemberOrderInquiryController() {
		this.ms = new MemberService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberVo loginMemberVo = (MemberVo) req.getSession().getAttribute("loginMemberVo");
			if (loginMemberVo == null) {
				resp.sendRedirect("/app/member/login");
				return;
			}
			List<OrderMemberInquiryDto> oidtoList = ms.selectOrderInquiriesByMemberNo(loginMemberVo);
			System.out.println("dtoList: " + oidtoList);
			req.setAttribute("oidtoList", oidtoList);
			req.getRequestDispatcher("/WEB-INF/views/member/order-inquiry.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
