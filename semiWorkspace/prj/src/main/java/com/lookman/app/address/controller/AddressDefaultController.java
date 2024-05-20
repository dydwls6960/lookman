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

@WebServlet("/member/address/default")
public class AddressDefaultController extends HttpServlet {

	private AddressService as;

	public AddressDefaultController() {
		this.as = new AddressService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberVo loginMemberVo = (MemberVo) req.getSession().getAttribute("loginMemberVo");

			if (loginMemberVo == null) {
				throw new Exception("로그인 되어있지 않습니다");
			}

			String memberNo = req.getParameter("memberNo");
			String addressNo = req.getParameter("addressNo");

			AddressVo avo = new AddressVo();
			avo.setMemberNo(memberNo);
			avo.setAddressNo(addressNo);

			if (!loginMemberVo.getMemberNo().equals(avo.getMemberNo())) {
				throw new Exception("업데이트 변경 권한이 없습니다.");
			}

			int result = as.updateDefaultAddress(avo);

			if (result > 0) {
				resp.getWriter().write("ok");
			} else {
				throw new Exception("bad");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			resp.getWriter().write("bad");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);

	}
}
