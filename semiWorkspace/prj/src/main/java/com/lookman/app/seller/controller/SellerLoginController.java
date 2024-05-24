package com.lookman.app.seller.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookman.app.seller.service.SellerService;
import com.lookman.app.seller.vo.SellerVo;

@WebServlet("/seller/login")
public class SellerLoginController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/seller/login.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			
			String accName = req.getParameter("sellerId");
			String pwd = req.getParameter("sellerPwd");
			
			SellerVo vo=new SellerVo();
			vo.setAccName(accName);
			vo.setPwd(pwd);
			
			SellerService ss=new SellerService();
			SellerVo loginSellerVo = ss.login(vo);
			
			
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
