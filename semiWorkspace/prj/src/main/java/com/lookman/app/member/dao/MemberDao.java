package com.lookman.app.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lookman.app.member.vo.MemberVo;
import static com.lookman.app.db.JDBCTemplate.*;

public class MemberDao {

	public int join(Connection conn, MemberVo mvo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO MEMBER (MEMBER_NO, ID, PWD, NAME, PHONE_NO) VALUES( SEQ_MEMBER.NEXTVAL , ? , ? , ? , ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, mvo.getId());
		pstmt.setString(2, mvo.getPwd());
		pstmt.setString(3, mvo.getName());
		pstmt.setString(4, mvo.getPhoneNo());

		int result = pstmt.executeUpdate();

		close(pstmt);

		return result;
	}

	public int checkIdDup(Connection conn, String id) throws SQLException {
		String sql = "SELECT COUNT(*) FROM MEMBER WHERE ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();

		int cnt = 1;
		if (rs.next()) {
			cnt = rs.getInt(1);
		}

		close(rs);
		close(pstmt);

		return cnt;
	}

}
