package com.lookman.app.order.inquiry.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookman.app.member.vo.MemberVo;
import com.lookman.app.order.inquiry.service.OrderInquiryService;
import com.lookman.app.order.inquiry.vo.OrderInquiryVo;

@WebServlet("/orders/inquiry/edit")
public class OrderInquiryEditController extends HttpServlet {

	private final OrderInquiryService ois;

	public OrderInquiryEditController() {
		this.ois = new OrderInquiryService();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberVo loginMemberVo = (MemberVo) req.getSession().getAttribute("loginMemberVo");

			if (loginMemberVo == null) {
				throw new Exception("로그인 되어있지 않습니다");
			}
			
			String memberNo = req.getParameter("memberNo");
			String orderInquiryNo = req.getParameter("orderInquiryNo");
			String sellerNo = req.getParameter("sellerNo");
			String title = req.getParameter("title");
			String questionContent = req.getParameter("questionContent");
			
			if (!loginMemberVo.getMemberNo().equals(memberNo)) {
				throw new Exception("수정 권한이 없습니다.");
			}
			
			OrderInquiryVo oivo = new OrderInquiryVo();
			oivo.setMemberNo(memberNo);
			oivo.setOrderInquiryNo(orderInquiryNo);
			oivo.setSellerNo(sellerNo);
			oivo.setTitle(title);
			oivo.setQuestionContent(questionContent);

			int result = ois.editInquiry(oivo);
			System.out.println(result);
			if (result == 1) {
				req.getSession().setAttribute("alertMsg", "수정 성공!");
				resp.sendRedirect("/app/member/order-inquiry");
				return;
			} else {
				throw new Exception("주문문의 삭제 중 에러 났습니다.");
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
