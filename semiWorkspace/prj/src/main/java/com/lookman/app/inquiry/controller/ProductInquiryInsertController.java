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

@WebServlet("/inquiry/insert")
public class ProductInquiryInsertController extends HttpServlet {

	private ProductInquiryService pis;

	public ProductInquiryInsertController() {
		this.pis = new ProductInquiryService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberVo loginMemberVo = (MemberVo) req.getSession().getAttribute("loginMemberVo");

			if (loginMemberVo == null) {
				throw new Exception("로그인 되어있지 않습니다");
			}
			
			String memberNo = req.getParameter("memberNo");
			String productNo = req.getParameter("productNo");
			String sellerNo = req.getParameter("sellerNo");
			String title = req.getParameter("title");
			String questionContent = req.getParameter("questionContent");
			String privateYn = req.getParameter("privateYn");

			if (!loginMemberVo.getMemberNo().equals(memberNo)) {
				throw new Exception("권한이 없습니다.");
			}

			ProductInquiryVo pivo = new ProductInquiryVo();
			pivo.setMemberNo(memberNo);
			pivo.setProductNo(productNo);
			pivo.setSellerNo(sellerNo);
			pivo.setTitle(title);
			pivo.setQuestionContent(questionContent);
			pivo.setPrivateYn(privateYn);

			int result = pis.insertInquiry(pivo);

			if (result == 1) {
				resp.sendRedirect("/app/products/" + productNo);
			} else {
				throw new Exception("질문 삽입 중 에러 발생했습니다.");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}

	}
}
