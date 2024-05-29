package com.lookman.app.order.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lookman.app.address.vo.AddressVo;
import com.lookman.app.member.vo.MemberVo;
import com.lookman.app.order.dto.OrderFormDetailsDto;
import com.lookman.app.order.dto.OrderFormDto;
import com.lookman.app.payment.dto.PaymentResponseDto;

public class OrderDao {

	public List<OrderFormDetailsDto> getOrderFormDetails(SqlSession ss, String[] cartNoList) {
		return ss.selectList("OrderMapper.getOrderFormDetails", cartNoList);
	}

	public List<AddressVo> getMemberAddress(SqlSession ss, MemberVo loginMemberVo) {
		return ss.selectList("OrderMapper.getMemberAddress", loginMemberVo);
	}

	public int insertIntoOrders(SqlSession ss, PaymentResponseDto payResDto) {
		return ss.insert("OrderMapper.insertIntoOrders", payResDto);
	}

	public String getGeneratedOrdersNo(SqlSession ss) {
		return ss.selectOne("OrderMapper.getGeneratedOrdersNo");
	}

}
