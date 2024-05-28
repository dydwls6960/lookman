package com.lookman.app.cart.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookman.app.cart.service.CartService;
import com.lookman.app.member.vo.MemberVo;

@WebServlet("/cart/delete/items")
public class CartDeleteItemsController extends HttpServlet {
	private final CartService cs;

	public CartDeleteItemsController() {
		this.cs = new CartService();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberVo loginMemberVo = (MemberVo) req.getSession().getAttribute("loginMemberVo");

			if (loginMemberVo == null) {
				throw new Exception("로그인 필요합니다.");
			}

			String[] cartNoList = req.getParameterValues("cartNo");
			String memberNo = req.getParameter("memberNo");

			if (!loginMemberVo.getMemberNo().equals(memberNo)) {
				throw new Exception("권한이 없습니다.");
			}

			int result = cs.deleteCartItems(cartNoList);

			if (result > 0) {
				req.getSession().setAttribute("alertMsg", "삭제 성공!");
				resp.sendRedirect("/app/member/cart");
			} else {
				req.getSession().setAttribute("alertMsg", "삭제 실패..");
				resp.sendRedirect("/app/member/cart");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}

	}
}
