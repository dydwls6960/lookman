package com.lookman.app.address.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookman.app.address.service.AddressService;
import com.lookman.app.address.vo.AddressVo;
import com.lookman.app.member.vo.MemberVo;

@WebServlet("/member/address/delete")
public class AddressDeleteController extends HttpServlet {
	private AddressService as;

	public AddressDeleteController() {
		this.as = new AddressService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로그인 필요
		MemberVo loginMemberVo = (MemberVo) req.getSession().getAttribute("loginMemberVo");

		if (loginMemberVo == null) {
			resp.sendRedirect("/app/member/login");
		} else {
			resp.sendRedirect("/app/member/address");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberVo loginMemberVo = (MemberVo) req.getSession().getAttribute("loginMemberVo");

			if (loginMemberVo == null) {
				throw new Exception("로그인 되어있지 않습니다");
			}

			String memberNo = req.getParameter("memberNo");
			String addressNo = req.getParameter("addressNo");

			if (!loginMemberVo.getMemberNo().equals(memberNo)) {
				throw new Exception("업데이트 변경 권한이 없습니다.");
			}

			AddressVo avo = new AddressVo();
			avo.setMemberNo(memberNo);
			avo.setAddressNo(addressNo);

			int result = as.deleteAddress(avo);
			
			if (result == 1) {
				resp.sendRedirect("/app/member/address");
			} else {
				throw new Exception("삭제 실패했습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
