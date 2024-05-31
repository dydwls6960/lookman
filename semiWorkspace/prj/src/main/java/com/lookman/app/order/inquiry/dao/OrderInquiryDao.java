package com.lookman.app.order.inquiry.dao;

import org.apache.ibatis.session.SqlSession;

import com.lookman.app.order.inquiry.vo.OrderInquiryVo;

public class OrderInquiryDao {

	public int insertOrderInquiry(SqlSession ss, OrderInquiryVo oivo) {
		System.out.println(oivo);
		return ss.insert("OrderInquiryMapper.insertOrderInquiry", oivo);
	}

}
