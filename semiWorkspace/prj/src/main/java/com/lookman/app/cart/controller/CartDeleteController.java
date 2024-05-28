package com.lookman.app.cart.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookman.app.cart.service.CartService;
import com.lookman.app.cart.vo.CartItemVo;
import com.lookman.app.member.vo.MemberVo;

@WebServlet("/cart/delete")
public class CartDeleteController extends HttpServlet {
	private final CartService cs;

	public CartDeleteController() {
		this.cs = new CartService();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberVo loginMemberVo = (MemberVo) req.getSession().getAttribute("loginMemberVo");

			if (loginMemberVo == null) {
				throw new Exception("로그인 필요합니다.");
			}
			String memberNo = req.getParameter("memberNo");
			String cartNo = req.getParameter("cartNo");
			
			if (!loginMemberVo.getMemberNo().equals(memberNo)) {
				throw new Exception("권한이 없습니다.");
			}

			CartItemVo cvo = new CartItemVo();
			cvo.setMemberNo(memberNo);
			cvo.setCartNo(cartNo);

			int result = cs.deleteCartItem(cvo);

			if (result == 1) {
				req.getSession().setAttribute("alertMsg", "삭제 성공!");
				resp.sendRedirect("/app/member/cart");
			} else {
				req.getSession().setAttribute("alertMsg", "삭제 실패..");
				resp.sendRedirect("/app/member/cart");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
