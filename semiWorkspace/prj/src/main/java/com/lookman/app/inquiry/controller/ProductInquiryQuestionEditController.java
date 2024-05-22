package com.lookman.app.inquiry.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookman.app.inquiry.service.ProductInquiryService;
import com.lookman.app.inquiry.vo.ProductInquiryVo;

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
			System.out.println("helooheloohelooheloohelooheloohelooheloohelooheloohelooheloohelooheloo");
			System.out.println("helooheloohelooheloohelooheloohelooheloohelooheloohelooheloohelooheloo");
			System.out.println("helooheloohelooheloohelooheloohelooheloohelooheloohelooheloohelooheloo");
			System.out.println("helooheloohelooheloohelooheloohelooheloohelooheloohelooheloohelooheloo");
			System.out.println("helooheloohelooheloohelooheloohelooheloohelooheloohelooheloohelooheloo");
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
			System.out.println(pivo);

			int result = pis.editInquiryQuestion(pivo);

			if (result == 1) {
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
