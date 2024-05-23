package com.lookman.app.inquiry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lookman.app.inquiry.dto.ProductInquiryDto;
import com.lookman.app.inquiry.dto.ProductMemberInquiryDto;
import com.lookman.app.inquiry.vo.ProductInquiryVo;
import com.lookman.app.member.vo.MemberVo;

public class ProductInquiryDao {

	public List<ProductInquiryDto> getInquiriesByProductNo(Connection conn, String productNo) throws Exception {
		String sql = "SELECT PI.PRODUCT_INQUIRY_NO PRODUCT_INQUIRY_NO , PI.PRODUCT_NO PRODUCT_NO , M.MEMBER_NO MEMBER_NO , M.NAME MEMBER_NAME , S.SELLER_NO SELLER_NO , S.NAME SELLER_NAME , ST.NAME STATUS , PI.TITLE TITLE , PI.QUESTION_CONTENT QUESTION_CONTENT , PI.RESPONSE_CONTENT RESPONSE_CONTENT , TO_CHAR(PI.ASK_DATE, 'YYYY-MM-DD') QUESTION_DATE , TO_CHAR(PI.RESPONSE_DATE, 'YYYY-MM-DD') RESPONSE_DATE , PI.PRIVATE_YN PRIVATE_YN , PI.DELETED_YN DELETED_YN FROM PRODUCT_INQUIRY PI JOIN SELLER S ON PI.SELLER_NO = S.SELLER_NO JOIN STATUS ST ON PI.STATUS_NO = ST.STATUS_NO JOIN MEMBER M ON PI.MEMBER_NO = M.MEMBER_NO WHERE PI.PRODUCT_NO = ? AND PI.DELETED_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, productNo);
		ResultSet rs = pstmt.executeQuery();

		List<ProductInquiryDto> inquiries = new ArrayList<ProductInquiryDto>();

		while (rs.next()) {
			String productInquiryNo = rs.getString("PRODUCT_INQUIRY_NO");
			String prodNo = rs.getString("PRODUCT_NO");
			String memberNo = rs.getString("MEMBER_NO");
			String memberName = rs.getString("MEMBER_NAME");
			String sellerNo = rs.getString("SELLER_NO");
			String sellerName = rs.getString("SELLER_NAME");
			String status = rs.getString("STATUS");
			String title = rs.getString("TITLE");
			String questionContent = rs.getString("QUESTION_CONTENT");
			String responseContent = rs.getString("RESPONSE_CONTENT");
			String questionDate = rs.getString("QUESTION_DATE");
			String responseDate = rs.getString("RESPONSE_DATE");
			String privateYn = rs.getString("PRIVATE_YN");
			String deletedYn = rs.getString("DELETED_YN");

			ProductInquiryDto dto = new ProductInquiryDto();
			dto.setProductInquiryNo(productInquiryNo);
			dto.setProductNo(prodNo);
			dto.setMemberNo(memberNo);
			dto.setMemberName(memberName);
			dto.setSellerNo(sellerNo);
			dto.setSellerName(sellerName);
			dto.setStatus(status);
			dto.setTitle(title);
			dto.setQuestionContent(questionContent);
			dto.setResponseContent(responseContent);
			dto.setQuestionDate(questionDate);
			dto.setResponseDate(responseDate);
			dto.setPrivateYn(privateYn);
			dto.setDeletedYn(deletedYn);

			inquiries.add(dto);
		}

		return inquiries;
	}

	public int editInquiryQuestion(SqlSession ss, ProductInquiryVo pivo) {
		return ss.update("ProductInquiryMapper.editProductInquiryQuestion", pivo);
	}

	public int deleteInquiry(SqlSession ss, ProductInquiryVo pivo) {
		return ss.update("ProductInquiryMapper.deleteProductInquiry", pivo);
	}

	public int insertInquiry(SqlSession ss, ProductInquiryVo pivo) {
		return ss.update("ProductInquiryMapper.insertProductInquiry", pivo);
	}

	public List<ProductMemberInquiryDto> selectProductInquiriesByMemberNo(SqlSession ss, MemberVo loginMemberVo) {

		return ss.selectList("ProductInquiryMapper.selectProductInquiriesByMemberNo", loginMemberVo);
	}

}
