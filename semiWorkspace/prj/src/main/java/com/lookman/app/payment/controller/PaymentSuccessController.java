package com.lookman.app.payment.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.lookman.app.member.vo.MemberVo;
import com.lookman.app.payment.dto.PaymentResponseDto;
import com.lookman.app.payment.service.PaymentService;

@WebServlet("/payment/success")
public class PaymentSuccessController extends HttpServlet {

	private final PaymentService ps;

	public PaymentSuccessController() {
		this.ps = new PaymentService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String success = req.getParameter("success");
			if (success == null || success.equals("") || !success.equals("true")) {
				resp.sendRedirect("/app/home");
				return;
			}
			
			MemberVo loginMemberVo = (MemberVo) req.getSession().getAttribute("loginMemberVo");
			
			if (loginMemberVo == null) {
				resp.sendRedirect("/app/member/login");
				return;
			}
			
			req.getRequestDispatcher("/WEB-INF/views/payment/success.jsp").forward(req, resp);
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

			StringBuilder jsonBuffer = new StringBuilder();
			try (BufferedReader reader = req.getReader()) {
				String line;
				while ((line = reader.readLine()) != null) {
					jsonBuffer.append(line);
				}
			}

			// json to PayResDto
			String json = jsonBuffer.toString();
			Gson gson = new Gson();
			PaymentResponseDto payResDto = gson.fromJson(json, PaymentResponseDto.class);

			// set needed data to dto

			System.out.println(payResDto);

			// process payment (service)
			int result = ps.savePaymentInfo(payResDto);
			System.out.println(result);
			if (result == 0) {
				throw new Exception("결제 과정 진행 중 에러.");
			}

			// response
			resp.setContentType("application/json");
			PrintWriter out = resp.getWriter();
			out.write("{\"message\": \"success\"}");
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
			resp.setContentType("application/json");
			PrintWriter out = resp.getWriter();
			out.write("{\"message\": \"failure\"}");
			out.flush();
		}

	}
}
