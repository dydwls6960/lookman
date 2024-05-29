package com.lookman.app.order.detail.dao;

import org.apache.ibatis.session.SqlSession;

import com.lookman.app.payment.dto.PaymentResponseDto;

public class OrderDetailDao {

	public int insertIntoOrderDetail(SqlSession ss, PaymentResponseDto payResDto) {
		return ss.insert("OrderDetailMapper.insertIntoOrderDetail", payResDto);
	}

}
