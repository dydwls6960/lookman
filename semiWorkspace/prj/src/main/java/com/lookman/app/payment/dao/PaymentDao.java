package com.lookman.app.payment.dao;

import org.apache.ibatis.session.SqlSession;

import com.lookman.app.payment.dto.PaymentResponseDto;

public class PaymentDao {

	public int insertIntoPayment(SqlSession ss, PaymentResponseDto payResDto) {
		return ss.insert("PaymentMapper.insertIntoPayment", payResDto);
	}

}
