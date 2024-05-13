package com.lookman.app.member.service;

import com.lookman.app.member.dao.MemberDao;
import com.lookman.app.member.vo.MemberVo;
import static com.lookman.app.db.JDBCTemplate.*;

import java.sql.Connection;

public class MemberService {

	private MemberDao dao;

	public MemberService() {
		this.dao = new MemberDao();
	}

	public int join(MemberVo mvo) throws Exception {

		// logic
		// 비밀번호 일치여부
		if (!mvo.getPwd().equals(mvo.getPwd2())) {
			throw new Exception("비밀번호가 일치하지 않습니다.");
		}

		// 전화번호
//		if (!(mvo.getPhoneNo().length() > 8 && mvo.getPhoneNo().length() <= 11)) {
//			throw new Exception("전화번호를 다시 입력해주세요.");
//		}

		// dao
		Connection conn = getConnection();
		int result = dao.join(conn, mvo);

		// add address

		if (result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	public boolean checkIdDup(String id) throws Exception {
		Connection conn = getConnection();
		int result = dao.checkIdDup(conn, id);

		close(conn);

		return result == 0;
	}

}
