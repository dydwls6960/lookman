package com.lookman.app.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookman.app.review.service.ReviewService;
import com.lookman.app.review.vo.ReviewVo;

@WebServlet("/member/review/insert")
public class ReviewInsertController extends HttpServlet {

	private final ReviewService rs;

	public ReviewInsertController() {
		this.rs = new ReviewService();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String memberNo = req.getParameter("memberNo");
			String ordersNo = req.getParameter("ordersNo");
			String productNo = req.getParameter("productNo");
			String rating = req.getParameter("rating");
			String content = req.getParameter("content");
			ReviewVo rvo = new ReviewVo();
			rvo.setMemberNo(memberNo);
			rvo.setOrdersNo(ordersNo);
			rvo.setProductNo(productNo);
			rvo.setRating(rating);
			rvo.setContent(content);
			System.out.println(rvo);
			
			int result = rs.insertReview(rvo);
			
			if (result == 1) {
				req.getSession().setAttribute("alertMsg", "문의 작성 성공!");
				resp.sendRedirect("/app/member/review");
				return;
			} else {
				throw new Exception("리뷰 작성 중 에러 발생..");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
