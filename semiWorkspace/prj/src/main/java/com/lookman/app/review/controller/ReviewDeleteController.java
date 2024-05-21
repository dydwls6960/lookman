package com.lookman.app.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookman.app.review.service.ReviewService;
import com.lookman.app.review.vo.ReviewVo;

@WebServlet("/member/review/delete")
public class ReviewDeleteController extends HttpServlet {
	private final ReviewService rs;

	public ReviewDeleteController() {
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
			String memberNo = req.getParameter("memberNo");
			String reviewNo = req.getParameter("reviewNo");
			ReviewVo rvo = new ReviewVo();
			rvo.setMemberNo(memberNo);
			rvo.setReviewNo(reviewNo);

			int result = rs.deleteReview(rvo);

			if (result == 1) {
				resp.sendRedirect("/app/member/review");
				return;
			} else {
				throw new Exception("리뷰 삭제 실패");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}

}
