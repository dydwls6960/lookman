package com.lookman.app.seller.service;

import java.sql.Connection;

import com.lookman.app.db.JDBCTemplate;
import com.lookman.app.seller.dao.SellerDao;
import com.lookman.app.seller.vo.SellerVo;

public class SellerService {
	private final SellerDao dao;
	
	public SellerService() {
		this.dao=new SellerDao();
	}
	
	public SellerVo login(SellerVo vo) throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		SellerVo loginSellerVo=dao.getSellerVo(conn,vo);
		
		JDBCTemplate.close(conn);
		
		return loginSellerVo;
	}

}
