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

@WebServlet("/member/address/edit")
public class AddressEditController extends HttpServlet {

	private AddressService as;

	public AddressEditController() {
		this.as = new AddressService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberVo loginMemberVo = (MemberVo) req.getSession().getAttribute("loginMemberVo");

			if (loginMemberVo == null) {
				throw new Exception("로그인 되어있지 않습니다");
			}

			String addressNo = req.getParameter("addressNo");
			String memberNo = req.getParameter("memberNo");
			String postcode = req.getParameter("postcode");
			String address = req.getParameter("address");
			String detailedAddress = req.getParameter("address2");
			String extraAddress = req.getParameter("extraAddress");

			if (!loginMemberVo.getMemberNo().equals(memberNo)) {
				throw new Exception("업데이트 변경 권한이 없습니다.");
			}

			AddressVo avo = new AddressVo();
			avo.setAddressNo(addressNo);
			avo.setMemberNo(memberNo);
			avo.setPostcode(postcode);
			avo.setAddress(address);
			avo.setDetailedAddress(detailedAddress);
			avo.setExtraAddress(extraAddress);

			int result = as.updateAddress(avo);

			if (result == 1) {
				resp.sendRedirect("/app/member/address");
			} else {
				req.setAttribute("errMsg", "주소 업데이트 중 실패..");
				req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}

	}
}
