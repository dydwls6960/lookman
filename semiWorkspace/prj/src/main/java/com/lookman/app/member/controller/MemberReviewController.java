package com.lookman.app.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookman.app.member.service.MemberService;
import com.lookman.app.member.vo.MemberVo;
import com.lookman.app.review.dto.ReviewDto;

@WebServlet("/member/review")
public class MemberReviewController extends HttpServlet {
	private final MemberService ms;

	public MemberReviewController() {
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

			List<ReviewDto> reviews = ms.selectReviewsByMemberNo(loginMemberVo);
			req.setAttribute("reviews", reviews);
			req.setAttribute("pageTitle", "내 리뷰 관리");
			req.getRequestDispatcher("/WEB-INF/views/member/review.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
