package com.lookman.app.inquiry.service;

import org.apache.ibatis.session.SqlSession;

import com.lookman.app.db.SQLSessionTemplate;
import com.lookman.app.inquiry.dao.ProductInquiryDao;
import com.lookman.app.inquiry.vo.ProductInquiryVo;
import static com.lookman.app.db.SQLSessionTemplate.*;

public class ProductInquiryService {

	private final ProductInquiryDao dao;

	public ProductInquiryService() {
		this.dao = new ProductInquiryDao();
	}

	public int editInquiryQuestion(ProductInquiryVo pivo) throws Exception {
		SqlSession ss = getSqlSession();

		int result = dao.editInquiryQuestion(ss, pivo);

		if (result == 1) {
			ss.commit();
		} else {
			ss.rollback();
		}

		ss.close();

		return result;
	}

	public int deleteInquiry(ProductInquiryVo pivo) throws Exception {
		SqlSession ss = getSqlSession();

		int result = dao.deleteInquiry(ss, pivo);

		if (result == 1) {
			ss.commit();
		} else {
			ss.rollback();
		}

		ss.close();

		return result;
	}

}
