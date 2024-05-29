package com.lookman.app.member.dao;

import static com.lookman.app.db.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.ibatis.session.SqlSession;

import com.lookman.app.address.vo.AddressVo;
import com.lookman.app.member.vo.MemberVo;

public class MemberDao {

	public int join(Connection conn, MemberVo mvo) throws Exception {
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
		String sql = "INSERT INTO ADDRESS(ADDRESS_NO, MEMBER_NO, POSTCODE, ADDRESS, DETAILED_ADDRESS, EXTRA_ADDRESS, DEFAULT_YN) VALUES (SEQ_ADDRESS.NEXTVAL, SEQ_MEMBER.CURRVAL, ?, ?, ?, ?, 'Y')";
		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, avo.getMemberNo());
		pstmt.setString(1, avo.getPostcode());
		pstmt.setString(2, avo.getAddress());
		pstmt.setString(3, avo.getDetailedAddress());
		pstmt.setString(4, avo.getExtraAddress());

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

	public MemberVo login(Connection conn, MemberVo mvo) throws SQLException {
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ? AND DELETED_YN = 'N' AND BAN_DATE IS NULL";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, mvo.getId());
		pstmt.setString(2, mvo.getPwd());

		ResultSet rs = pstmt.executeQuery();

		MemberVo loginMemberVo = null;
		if (rs.next()) {
			String memberNo = rs.getString("MEMBER_NO");
			String id = rs.getString("ID");
			String name = rs.getString("NAME");
			String phoneNo = rs.getString("PHONE_NO");
			String premiumYn = rs.getString("PREMIUM_YN");
			String deletedYn = rs.getString("DELETED_YN");
			String createdDate = rs.getString("CREATED_DATE");
			String banDate = rs.getString("BAN_DATE");

			loginMemberVo = new MemberVo();
			loginMemberVo.setMemberNo(memberNo);
			loginMemberVo.setId(id);
			loginMemberVo.setName(name);
			loginMemberVo.setPhoneNo(phoneNo);
			loginMemberVo.setPremiumYn(premiumYn);
			loginMemberVo.setDeletedYn(deletedYn);
			loginMemberVo.setCreatedDate(createdDate);
			loginMemberVo.setBanDate(banDate);
		}

		close(rs);
		close(pstmt);

		return loginMemberVo;
	}

	public boolean validateCurrentPwd(Connection conn, MemberVo mvo) throws Exception {
		String sql = "SELECT COUNT(*) FROM MEMBER WHERE MEMBER_NO = ? AND PWD = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mvo.getMemberNo());
		pstmt.setString(2, mvo.getPwd());
		ResultSet rs = pstmt.executeQuery();
		rs.next();

		int result = rs.getInt(1);

		close(rs);
		close(pstmt);

		return result == 1;
	}

	public int updatePassword(Connection conn, MemberVo mvo) throws Exception {
		String sql = "UPDATE MEMBER SET PWD = ? WHERE MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mvo.getNewPwd());
		pstmt.setString(2, mvo.getMemberNo());

		int result = pstmt.executeUpdate();

		close(pstmt);

		return result;
	}

	public int updateMemberInfo(Connection conn, MemberVo mvo) throws Exception {
		String sql = "UPDATE MEMBER SET NAME = ?, PHONE_NO = ? WHERE MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mvo.getName());
		pstmt.setString(2, mvo.getPhoneNo());
		pstmt.setString(3, mvo.getMemberNo());

		int result = pstmt.executeUpdate();

		close(pstmt);

		return result;
	}

	public int checkIdDup(SqlSession ss, String id) {
		
		return ss.selectOne("MemberMapper.checkIdDup", id);
	}

}
