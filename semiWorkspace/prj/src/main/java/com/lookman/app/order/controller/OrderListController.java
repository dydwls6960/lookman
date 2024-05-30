package com.lookman.app.order.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookman.app.member.vo.MemberVo;
import com.lookman.app.order.detail.dto.OrderDetailsDto;
import com.lookman.app.order.dto.OrderStatusCountDto;
import com.lookman.app.order.service.OrderService;
import com.lookman.app.order.vo.OrderVo;

@WebServlet("/orders/list")
public class OrderListController extends HttpServlet {

	private final OrderService os;

	public OrderListController() {
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
			String statusNo = req.getParameter("statusNo");
			OrderVo ovo = new OrderVo();
			ovo.setStatusNo(statusNo);
			ovo.setMemberNo(loginMemberVo.getMemberNo());

			List<OrderDetailsDto> dtoList = os.getOrderDetailListByStatus(ovo);
			List<OrderStatusCountDto> statusDtoList = os.getStatusCount(ovo);
			System.out.println(dtoList);
			System.out.println(statusDtoList);
			req.setAttribute("statusDtoList", statusDtoList);
			req.setAttribute("dtoList", dtoList);
			req.setAttribute("pageTitle", "마이프로필");
			req.getRequestDispatcher("/WEB-INF/views/order/list.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
