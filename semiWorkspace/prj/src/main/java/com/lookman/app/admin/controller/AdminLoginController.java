package com.lookman.app.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookman.app.admin.service.AdminService;
import com.lookman.app.admin.vo.AdminVo;
import com.lookman.app.seller.service.SellerService;
import com.lookman.app.seller.vo.SellerVo;

@WebServlet("/admin/login")
public class AdminLoginController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/admin/login.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			
			String adminId = req.getParameter("adminId");
			String adminPwd = req.getParameter("adminPwd");
			
			AdminVo vo=new AdminVo();
			vo.setAdminId(adminId);
			vo.setAdminPwd(adminPwd);
			
			
			
			AdminService as=new AdminService();
			AdminVo loginAdminVo = as.login(vo);
			
			
			if(loginAdminVo != null) {
				session.setAttribute("alertMsg", "로그인 성공 !!!");
				session.setAttribute("loginAdminVo", loginAdminVo);
				resp.sendRedirect("/app/admin/home");
			}else {
				session.setAttribute("alertMsg", "로그인 실패...");
				resp.sendRedirect("/app/admin/login");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", "[ERROR-M0002]로그인 중 에러 발생...");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
