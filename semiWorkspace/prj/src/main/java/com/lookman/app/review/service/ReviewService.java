package com.lookman.app.review.service;

import static com.lookman.app.db.SQLSessionTemplate.getSqlSession;

import org.apache.ibatis.session.SqlSession;

import com.lookman.app.review.dao.ReviewDao;
import com.lookman.app.review.vo.ReviewVo;

public class ReviewService {
	private final ReviewDao dao;

	public ReviewService() {
		this.dao = new ReviewDao();
	}

	public int editReview(ReviewVo rvo) throws Exception {
		// get ss
		SqlSession ss = getSqlSession();

		int result = dao.editReview(ss, rvo);

		if (result == 1) {
			ss.commit();
		} else {
			ss.rollback();
		}

		ss.close();

		return result;
	}

}
