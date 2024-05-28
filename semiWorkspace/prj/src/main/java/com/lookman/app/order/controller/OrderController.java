package com.lookman.app.order.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookman.app.member.vo.MemberVo;
import com.lookman.app.order.dto.OrderDto;
import com.lookman.app.order.dto.OrderFormDto;
import com.lookman.app.order.service.OrderService;

@WebServlet("/orders/order-form")
@MultipartConfig
public class OrderController extends HttpServlet {

	private final OrderService os;

	public OrderController() {
		this.os = new OrderService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberVo loginMemberVo = (MemberVo) req.getSession().getAttribute("loginMemberVo");

			if (loginMemberVo == null) {
				resp.sendRedirect("/app/member/login");
				return;
			}
			String memberNo = req.getParameter("memberNo");
			String[] cartNoList = req.getParameterValues("cartNo");

			if (!loginMemberVo.getMemberNo().equals(memberNo)) {
				throw new Exception("권한이 없습니다.");
			}

			// dto
			OrderFormDto dto = os.getOrderFormDetails(cartNoList, loginMemberVo);

			if (dto == null) {
				resp.sendRedirect("/app/member/cart");
				return;
			}

			req.setAttribute("pageTitle", "주문서 작성");
			req.setAttribute("dto", dto);
			req.getRequestDispatcher("/WEB-INF/views/order/order.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
