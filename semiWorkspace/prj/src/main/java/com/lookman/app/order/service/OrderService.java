package com.lookman.app.order.service;

import static com.lookman.app.db.SQLSessionTemplate.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lookman.app.address.vo.AddressVo;
import com.lookman.app.member.vo.MemberVo;
import com.lookman.app.order.dao.OrderDao;
import com.lookman.app.order.dto.OrderFormDetailsDto;
import com.lookman.app.order.dto.OrderFormDto;

public class OrderService {

	private final OrderDao odao;

	public OrderService() {
		this.odao = new OrderDao();
	}

	public OrderFormDto getOrderFormDetails(String[] cartNoList, MemberVo loginMemberVo) throws Exception {
		SqlSession ss = getSqlSession();

		OrderFormDto dto = new OrderFormDto();

		// set details
		List<OrderFormDetailsDto> details = odao.getOrderFormDetails(ss, cartNoList);
		dto.setDetails(details);

		// set totalPrice
		int totalPrice = 0;
		for (OrderFormDetailsDto detail : details) {
			totalPrice += Integer.parseInt(detail.getOrderPrice());
		}
		dto.setTotalPrice(totalPrice + "");

		// set addresses
		List<AddressVo> addresses = odao.getMemberAddress(ss, loginMemberVo);
		dto.setAddresses(addresses);

		// set memberInfo
		dto.setMemberName(loginMemberVo.getName());
		dto.setPhoneNumber(loginMemberVo.getPhoneNo());

		ss.close();

		return dto;
	}

}
