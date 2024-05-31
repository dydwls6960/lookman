package com.lookman.app.order.inquiry.service;

import com.lookman.app.order.inquiry.dao.OrderInquiryDao;
import com.lookman.app.order.inquiry.vo.OrderInquiryVo;
import static com.lookman.app.db.SQLSessionTemplate.*;

import org.apache.ibatis.session.SqlSession;

public class OrderInquiryService {

	private final OrderInquiryDao dao;

	public OrderInquiryService() {
		this.dao = new OrderInquiryDao();
	}

	public int insertOrderInquiry(OrderInquiryVo oivo) throws Exception {
		SqlSession ss = getSqlSession();

		int result = dao.insertOrderInquiry(ss, oivo);

		if (result == 1) {
			ss.commit();
		} else {
			ss.rollback();
		}
		ss.close();

		return result;
	}

}
