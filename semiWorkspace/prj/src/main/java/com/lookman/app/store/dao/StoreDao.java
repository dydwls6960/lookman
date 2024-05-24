package com.lookman.app.store.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lookman.app.seller.vo.SellerVo;

public class StoreDao {

	public List<SellerVo> selectStore(SqlSession ss) {
		return ss.selectList("StoreMapper.selectStore");
	}

}
