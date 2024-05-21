package com.lookman.app.review.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookman.app.member.vo.MemberVo;
import com.lookman.app.review.service.ReviewService;
import com.lookman.app.review.vo.ReviewVo;

@WebServlet("/member/review/edit")
public class ReviewEditController extends HttpServlet {
	private final ReviewService rs;

	public ReviewEditController() {
		this.rs = new ReviewService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberVo loginMemberVo = (MemberVo) req.getSession().getAttribute("loginMemberVo");

			if (loginMemberVo == null) {
				throw new Exception("로그인 되어있지 않습니다");
			}

			String memberNo = req.getParameter("memberNo");
			String reviewNo = req.getParameter("reviewNo");
			String rating = req.getParameter("rating");
			String content = req.getParameter("content");
			ReviewVo rvo = new ReviewVo();
			rvo.setMemberNo(memberNo);
			rvo.setReviewNo(reviewNo);
			rvo.setRating(rating);
			rvo.setContent(content);

			if (!loginMemberVo.getMemberNo().equals(memberNo)) {
				throw new Exception("업데이트 변경 권한이 없습니다.");
			}

			int result = rs.editReview(rvo);
			if (result == 1) {
				resp.sendRedirect("/app/member/review");
				return;
			} else {
				throw new Exception("리뷰 수정 실패");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}

	}
}
