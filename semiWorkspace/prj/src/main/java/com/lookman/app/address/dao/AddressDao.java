package com.lookman.app.address.dao;

import static com.lookman.app.db.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lookman.app.address.dto.AddressDto;
import com.lookman.app.address.vo.AddressVo;
import com.lookman.app.member.vo.MemberVo;

public class AddressDao {

	public List<AddressDto> selectAddressesByMemberNo(Connection conn, MemberVo loginMemberVo) throws Exception {
		String sql = "SELECT A.ADDRESS_NO , M.NAME MEMBER_NAME , A.MEMBER_NO MEMBER_NO , M.PHONE_NO PHONE_NO , A.POSTCODE POSTCODE , A.ADDRESS ADDRESS , A.DETAILED_ADDRESS DETAILED_ADDRESS , NVL(A.EXTRA_ADDRESS, '') EXTRA_ADDRESS , A.DEFAULT_YN DEFAULT_YN , A.DELETED_YN DELETED_YN FROM ADDRESS A JOIN MEMBER M ON A.MEMBER_NO = M.MEMBER_NO WHERE A.MEMBER_NO = ? AND A.DELETED_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMemberVo.getMemberNo());

		ResultSet rs = pstmt.executeQuery();
		List<AddressDto> addresses = new ArrayList<AddressDto>();
		while (rs.next()) {
			String addressNo = rs.getString("ADDRESS_NO");
			String memberName = rs.getString("MEMBER_NAME");
			String memberNo = rs.getString("MEMBER_NO");
			String phoneNo = rs.getString("PHONE_NO");
			String postCode = rs.getString("POSTCODE");
			String address = rs.getString("ADDRESS");
			String detailedAddress = rs.getString("DETAILED_ADDRESS");
			String extraAddress = rs.getString("EXTRA_ADDRESS");
			String defaultYn = rs.getString("DEFAULT_YN");
			String deletedYn = rs.getString("DELETED_YN");

			AddressDto dto = new AddressDto();
			dto.setAddressNo(addressNo);
			dto.setMemberName(memberName);
			dto.setMemberNo(memberNo);
			dto.setPhoneNo(phoneNo);
			dto.setPostcode(postCode);
			dto.setAddress(address);
			dto.setDetailedAddress(detailedAddress);
			dto.setExtraAddress(extraAddress);
			dto.setDefaultYn(defaultYn);
			dto.setDeletedYn(deletedYn);

			addresses.add(dto);
		}

		close(rs);
		close(pstmt);

		return addresses;
	}

	public int updateAddress(Connection conn, AddressVo avo) throws Exception {
		String sql = "UPDATE ADDRESS SET POSTCODE = ?, ADDRESS = ?, DETAILED_ADDRESS = ?, EXTRA_ADDRESS = ? WHERE ADDRESS_NO = ? AND DELETED_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, avo.getPostcode());
		pstmt.setString(2, avo.getAddress());
		pstmt.setString(3, avo.getDetailedAddress());
		pstmt.setString(4, avo.getExtraAddress());
		pstmt.setString(5, avo.getAddressNo());
		int result = pstmt.executeUpdate();

		close(pstmt);

		return result;
	}

	public int updateDefaultAddress(Connection conn, AddressVo avo) throws Exception {
		
		String sql = "UPDATE ADDRESS SET DEFAULT_YN = 'Y' WHERE ADDRESS_NO = ? AND DELETED_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, avo.getAddressNo());
		int result = pstmt.executeUpdate();
		
		
		close(pstmt);

		return result;
	}

}
