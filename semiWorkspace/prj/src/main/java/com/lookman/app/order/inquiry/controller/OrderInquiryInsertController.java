package com.lookman.app.order.inquiry.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookman.app.order.inquiry.service.OrderInquiryService;
import com.lookman.app.order.inquiry.vo.OrderInquiryVo;

@WebServlet("/orders/inquiry/insert")
public class OrderInquiryInsertController extends HttpServlet {

	private final OrderInquiryService ois;

	public OrderInquiryInsertController() {
		this.ois = new OrderInquiryService();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String memberNo = req.getParameter("memberNo");
			String orderDetailNo = req.getParameter("orderDetailNo");
			String sellerNo = req.getParameter("sellerNo");
			String title = req.getParameter("title");
			String questionContent = req.getParameter("questionContent");

			OrderInquiryVo oivo = new OrderInquiryVo();
			oivo.setMemberNo(memberNo);
			oivo.setOrderDetailNo(orderDetailNo);
			oivo.setSellerNo(sellerNo);
			oivo.setTitle(title);
			oivo.setQuestionContent(questionContent);

			int result = ois.insertOrderInquiry(oivo);

			if (result == 1) {
				//
			} else {
				//
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
