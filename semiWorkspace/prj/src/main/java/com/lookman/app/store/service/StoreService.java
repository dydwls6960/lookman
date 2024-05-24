package com.lookman.app.store.service;

import static com.lookman.app.db.SQLSessionTemplate.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lookman.app.seller.vo.SellerVo;
import com.lookman.app.store.dao.StoreDao;

public class StoreService {

	private final StoreDao dao;

	public StoreService() {
		this.dao = new StoreDao();
	}

	public List<SellerVo> selectStore() throws Exception {
		SqlSession ss = getSqlSession();
		List<SellerVo> svoList = dao.selectStore(ss);
		ss.close();
		return svoList;
	}

}
