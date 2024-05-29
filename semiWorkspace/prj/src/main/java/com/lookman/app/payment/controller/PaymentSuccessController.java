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

			// response
			resp.setContentType("application/json");
			PrintWriter out = resp.getWriter();
			out.write("{\"message\": \"success\"}");
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
