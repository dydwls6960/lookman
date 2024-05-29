package com.lookman.app.payment.service;

import com.lookman.app.payment.dao.PaymentDao;
import com.lookman.app.payment.dto.PaymentResponseDto;

import static com.lookman.app.db.SQLSessionTemplate.*;

import org.apache.ibatis.session.SqlSession;

public class PaymentService {

	private final PaymentDao pdao;
	
	public PaymentService() {
		this.pdao = new PaymentDao();
	}

	public int savePaymentInfo(PaymentResponseDto payResDto) throws Exception {
		SqlSession ss = getSqlSession();
		
		// insert into orders table

		// insert into payment table
		
		// remove cart items for the paid products
		
		
		// 
	}

}
