package com.lookman.app.favorite.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookman.app.favorite.service.FavoriteService;
import com.lookman.app.favorite.vo.FavoriteVo;
import com.lookman.app.member.vo.MemberVo;

@WebServlet("/member/favorite")
public class FavoriteController extends HttpServlet {

	private final FavoriteService fs;

	public FavoriteController() {
		this.fs = new FavoriteService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo loginMemberVo = (MemberVo) req.getSession().getAttribute("loginMemberVo");

		if (loginMemberVo != null) {
			req.setAttribute("pageTitle", "찜한 상품"); // nav-with-header.jsp 에서 사용
			req.getRequestDispatcher("/WEB-INF/views/favorite/favorite.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("/app/member/login");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String memberNo = req.getParameter("memberNo");
			String productNo = req.getParameter("productNo");

			FavoriteVo fvo = new FavoriteVo();
			fvo.setMemberNo(memberNo);
			fvo.setProductNo(productNo);
			
			int result = fs.toggleFavorite(fvo);
			
			PrintWriter out = resp.getWriter();
			if (result > 0) {
				out.write("ok");
			} else {
				out.write("bad");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
}
