package com.lookman.app.member.dao;

import static com.lookman.app.db.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lookman.app.member.vo.AddressVo;
import com.lookman.app.member.vo.MemberVo;

public class MemberDao {

	public int join(Connection conn, MemberVo mvo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO MEMBER (MEMBER_NO, ID, PWD, NAME, PHONE_NO) VALUES( SEQ_MEMBER.NEXTVAL , ? , ? , ? , ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		pstmt.setString(1, mvo.getId());
		pstmt.setString(2, mvo.getPwd());
		pstmt.setString(3, mvo.getName());
		pstmt.setString(4, mvo.getPhoneNo());

		int result = pstmt.executeUpdate();
		System.out.println("memberDao result: " + result);

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

	public int insertAddress(Connection conn, AddressVo avo) throws SQLException {
		String sql = "INSERT INTO ADDRESS(ADDRESS_NO, MEMBER_NO, POSTCODE, ADDRESS, DETAILED_ADDRESS, EXTRA_ADDRESS) VALUES (SEQ_ADDRESS.NEXTVAL, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, avo.getMemberNo());
		pstmt.setString(2, avo.getPostcode());
		pstmt.setString(3, avo.getAddress());
		pstmt.setString(4, avo.getDetailedAddress());
		pstmt.setString(5, avo.getExtraAddress());

		int result = pstmt.executeUpdate();

		close(pstmt);

		return result;
	}

	public String getMemberNo(Connection conn, MemberVo mvo) throws SQLException {
		String sql = "SELECT MEMBER_NO FROM MEMBER WHERE ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, mvo.getId());
		
		ResultSet rs = pstmt.executeQuery();
		
		String memberNo = "";
		
		if (rs.next()) {
			memberNo = rs.getString("MEMBER_NO");
			System.out.println("memberNo in getMemberNo: " + memberNo);
		}
		
		return memberNo;
	}

}
