package com.lookman.app.order.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookman.app.member.vo.MemberVo;
import com.lookman.app.order.dto.OrderDto;
import com.lookman.app.order.service.OrderService;

@WebServlet("/orders/order-form")
public class OrderController extends HttpServlet {

	private final OrderService os;

	public OrderController() {
		this.os = new OrderService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo loginMemberVo = (MemberVo) req.getSession().getAttribute("loginMemberVo");

		if (loginMemberVo == null) {
			resp.sendRedirect("/app/member/login");
			return;
		}

		Map<String, String[]> parameterMap = req.getParameterMap();
		Map<Integer, Integer> orderItems = new HashMap<>();

		parameterMap.forEach((key, values) -> {
			if (key.startsWith("items[")) {
				int inventoryNo = Integer.parseInt(key.substring(6, key.length() - 1));
				int quantity = Integer.parseInt(values[0]);
				orderItems.put(inventoryNo, quantity);
			}
		});

		System.out.println(orderItems);

		List<OrderDto> odtoList = os.getOrderList(orderItems);

		// dispatch jsp
//		req.setAttribute("orderItems", orderItems)
		req.getRequestDispatcher("/WEB-INF/views/order/order.jsp").forward(req, resp);

	}

}
