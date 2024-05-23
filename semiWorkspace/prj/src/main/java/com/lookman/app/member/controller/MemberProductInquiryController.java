package com.lookman.app.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookman.app.inquiry.dto.ProductMemberInquiryDto;
import com.lookman.app.member.service.MemberService;
import com.lookman.app.member.vo.MemberVo;

@WebServlet("/member/product-inquiry")
public class MemberProductInquiryController extends HttpServlet {
	private final MemberService ms;

	public MemberProductInquiryController() {
		this.ms = new MemberService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberVo loginMemberVo = (MemberVo) req.getSession().getAttribute("loginMemberVo");
			
			List<ProductMemberInquiryDto> pidtoList = ms.selectProductInquiriesByMemberNo(loginMemberVo);
			req.setAttribute("pageTitle", "상품문의");
			req.setAttribute("pivoList", pidtoList);
			req.getRequestDispatcher("/WEB-INF/views/member/product-inquiry.jsp").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
