package com.lookman.app.cart.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lookman.app.cart.dto.CartHomeDto;
import com.lookman.app.cart.dto.CartRequestDto;
import com.lookman.app.cart.service.CartService;
import com.lookman.app.cart.vo.CartItemVo;
import com.lookman.app.member.vo.MemberVo;

@WebServlet("/member/cart")
public class CartController extends HttpServlet {
	private final CartService cs;

	public CartController() {
		this.cs = new CartService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberVo loginMemberVo = (MemberVo) req.getSession().getAttribute("loginMemberVo");
			
			if (loginMemberVo == null) {
				resp.sendRedirect("/app/member/login");
				return;
			}
			
			List<CartHomeDto> dtoList = cs.getCartItems(loginMemberVo);
			req.setAttribute("dtoList", dtoList);
			req.setAttribute("pageTitle", "장바구니"); // nav-with-header.jsp 에서 사용
			req.getRequestDispatcher("/WEB-INF/views/cart/cart.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// json
			Gson gson = new GsonBuilder().create();
			BufferedReader reader = req.getReader();
			CartRequestDto cartReqDto = gson.fromJson(reader, CartRequestDto.class);
			List<CartItemVo> items = cartReqDto.getItems();

			// result
			int result = cs.addToCart(items);
			PrintWriter out = resp.getWriter();
			if (result > 0) {
				out.write("ok");
				out.flush();
			} else {
				out.write("bad");
				out.flush();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
}
