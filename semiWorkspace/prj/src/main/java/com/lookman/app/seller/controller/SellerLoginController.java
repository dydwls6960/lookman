package com.lookman.app.seller.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/seller/login")
public class SellerLoginController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/seller/login.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//세션
			HttpSession session = req.getSession();
			
			//데이터 꺼내기
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			
			//데이터 뭉치기
			SellerVo vo=new SellerVo();
			vo.setId(id);
			vo.setPwd(pwd);
			
			//복작한 작업
			SellerService ms=new SellerService();
			SellerVo loginSellerVo = ms.login(vo);
			
			
			if(loginSellerVo != null) {
				session.setAttribute("alertMsg", "로그인 성공 !!!");
				session.setAttribute("loginSellerVo", loginSellerVo);
			}else {

				session.setAttribute("alertMsg", "로그인 실패...");
			}
			resp.sendRedirect("/app/seller/home");
		}catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", "[ERROR-M0002]로그인 중 에러 발생...");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}

	}
}
