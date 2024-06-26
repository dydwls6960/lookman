package com.lookman.app.inquiry.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookman.app.inquiry.service.ProductInquiryService;
import com.lookman.app.inquiry.vo.ProductInquiryVo;
import com.lookman.app.member.vo.MemberVo;

@WebServlet("/inquiry/edit-question")
public class ProductInquiryQuestionEditController extends HttpServlet {

	private final ProductInquiryService pis;

	public ProductInquiryQuestionEditController() {
		this.pis = new ProductInquiryService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "GET method is not supported");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberVo loginMemberVo = (MemberVo) req.getSession().getAttribute("loginMemberVo");

			if (loginMemberVo == null) {
				throw new Exception("로그인 되어있지 않습니다");
			}
			String source = req.getParameter("source");
			System.out.println(source);
			String productInquiryNo = req.getParameter("productInquiryNo");
			String productNo = req.getParameter("productNo");
			String memberNo = req.getParameter("memberNo");
			String title = req.getParameter("title");
			String questionContent = req.getParameter("questionContent");
			String privateYn = req.getParameter("privateYn");
			ProductInquiryVo pivo = new ProductInquiryVo();
			pivo.setProductInquiryNo(productInquiryNo);
			pivo.setProductNo(productNo);
			pivo.setMemberNo(memberNo);
			pivo.setTitle(title);
			pivo.setQuestionContent(questionContent);
			pivo.setPrivateYn(privateYn);

			if (!loginMemberVo.getMemberNo().equals(memberNo)) {
				throw new Exception("수정 권한이 없습니다.");
			}

			int result = pis.editInquiryQuestion(pivo);
			System.out.println(result);
			if (result == 1) {

				if (source != null && source.equals("member")) {
					req.getSession().setAttribute("alertMsg", "수정 완료!");
					resp.sendRedirect("/app/member/product-inquiry");
					return;
				}
				req.getSession().setAttribute("alertMsg", "수정 완료!");
				resp.sendRedirect("/app/products/" + productNo);
			} else {
				throw new Exception("상품문의 수정 실패.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			req.setAttribute(getServletName(), e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}

	}
}
