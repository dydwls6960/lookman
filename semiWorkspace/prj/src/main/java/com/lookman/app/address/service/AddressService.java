package com.lookman.app.address.service;

import static com.lookman.app.db.JDBCTemplate.close;
import static com.lookman.app.db.SQLSessionTemplate.*;
import static com.lookman.app.db.JDBCTemplate.commit;
import static com.lookman.app.db.JDBCTemplate.getConnection;
import static com.lookman.app.db.JDBCTemplate.rollback;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;

import com.lookman.app.address.dao.AddressDao;
import com.lookman.app.address.vo.AddressVo;

public class AddressService {
	private AddressDao dao;

	public AddressService() {
		this.dao = new AddressDao();
	}

	public int updateAddress(AddressVo avo) throws Exception {
		// 주소 비어있는지 체크
		if (avo.getAddress() == null || avo.getAddress().isEmpty()) {
			throw new Exception("주소가 비어있습니다.");
		}

		// dao
		Connection conn = getConnection();
		int result = dao.updateAddress(conn, avo);

		if (result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	public int updateDefaultAddress(AddressVo avo) throws Exception {
		Connection conn = getConnection();

		int resetResult = dao.resetDefaultAddress(conn, avo);
		int result = dao.updateDefaultAddress(conn, avo);

		if (result * resetResult > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	public int insertAddress(AddressVo avo) throws Exception {
		// 주소 비어있는지 체크
		if (avo.getAddress() == null || avo.getAddress().isEmpty()) {
			throw new Exception("주소가 비어있습니다.");
		}

		// dao
		Connection conn = getConnection();
		int result = dao.insertAddress(conn, avo);

		if (result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	public int deleteAddress(AddressVo avo) throws Exception {
		Connection conn = getConnection();
		int result = dao.deleteAddress(conn, avo);

		if (result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	public AddressVo getAddressByNo(String addressNo) throws Exception {
		SqlSession ss = getSqlSession();

		AddressVo avo = dao.getAddressByNo(ss, addressNo);

		ss.close();

		return avo;

	}
}
