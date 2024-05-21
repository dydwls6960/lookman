package com.lookman.app.review.dao;

import static com.lookman.app.db.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lookman.app.member.vo.MemberVo;
import com.lookman.app.review.dto.ReviewDto;
import com.lookman.app.review.vo.ReviewVo;

public class ReviewDao {
	public List<ReviewDto> getReviewsByProductNo(Connection conn, String productNo) throws Exception {
		String sql = "SELECT R.REVIEW_NO, R.MEMBER_NO, M.NAME MEMBER_NAME, R.PRODUCT_NO, R.RATING, R.CONTENT, R.CREATED_DATE, R.DELETED_YN, PS.NAME PRODUCT_SIZE, C.NAME PRODUCT_COLOR, C.HEXCODE COLOR_HEX, OD.QUANTITY PRODUCT_QUANTITY FROM REVIEW R JOIN MEMBER M ON R.MEMBER_NO = M.MEMBER_NO JOIN ORDERS O ON R.ORDERS_NO = O.ORDERS_NO JOIN ORDER_DETAIL OD ON O.ORDERS_NO = OD.ORDERS_NO AND R.PRODUCT_NO = OD.PRODUCT_NO JOIN INVENTORY I ON OD.INVENTORY_NO = I.INVENTORY_NO JOIN PRODUCT_SIZE PS ON I.SIZE_NO = PS.SIZE_NO JOIN COLOR C ON I.COLOR_NO = C.COLOR_NO WHERE R.PRODUCT_NO = ? AND R.DELETED_YN = 'N' ORDER BY R.REVIEW_NO DESC, R.CREATED_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, productNo);
		ResultSet rs = pstmt.executeQuery();

		List<ReviewDto> reviews = new ArrayList<ReviewDto>();
		while (rs.next()) {
			String reviewNo = rs.getString("REVIEW_NO");
			String memberNo = rs.getString("MEMBER_NO");
			String memberName = rs.getString("MEMBER_NAME");
			String prodNo = rs.getString("PRODUCT_NO");
			String rating = rs.getString("RATING");
			String content = rs.getString("CONTENT");
			String createdDate = rs.getString("CREATED_DATE");
			String deletedYn = rs.getString("DELETED_YN");
			String productSize = rs.getString("PRODUCT_SIZE");
			String productColor = rs.getString("PRODUCT_COLOR");
			String colorHex = rs.getString("COLOR_HEX");
			String orderQuantity = rs.getString("PRODUCT_QUANTITY");

			ReviewDto dto = new ReviewDto();
			dto.setReviewNo(reviewNo);
			dto.setMemberNo(memberNo);
			dto.setMemberName(memberName);
			dto.setProductNo(prodNo);
			dto.setRating(rating);
			dto.setContent(content);
			dto.setCreatedDate(createdDate);
			dto.setDeletedYn(deletedYn);
			dto.setProductSize(productSize);
			dto.setProductColor(productColor);
			dto.setColorHex(colorHex);
			dto.setOrderQuantity(orderQuantity);

			reviews.add(dto);
		}

		close(rs);
		close(pstmt);

		return reviews;
	}

	public List<ReviewDto> selectReviewsByMemberNo(Connection conn, MemberVo loginMemberVo) throws Exception {

		String sql = "SELECT R.REVIEW_NO, R.MEMBER_NO, M.NAME MEMBER_NAME, R.PRODUCT_NO, P.NAME PRODUCT_NAME, R.RATING, R.CONTENT, R.CREATED_DATE, NVL(R.EDITED_DATE, '') EDITED_DATE, R.DELETED_YN, PS.NAME PRODUCT_SIZE, C.NAME PRODUCT_COLOR, C.HEXCODE COLOR_HEX, OD.QUANTITY PRODUCT_QUANTITY, PI.FILENAME THUMBNAIL_FILENAME FROM REVIEW R JOIN PRODUCT P ON R.PRODUCT_NO = P.PRODUCT_NO JOIN MEMBER M ON R.MEMBER_NO = M.MEMBER_NO JOIN ORDERS O ON R.ORDERS_NO = O.ORDERS_NO JOIN ORDER_DETAIL OD ON O.ORDERS_NO = OD.ORDERS_NO AND R.PRODUCT_NO = OD.PRODUCT_NO JOIN INVENTORY I ON OD.INVENTORY_NO = I.INVENTORY_NO JOIN PRODUCT_SIZE PS ON I.SIZE_NO = PS.SIZE_NO JOIN COLOR C ON I.COLOR_NO = C.COLOR_NO LEFT JOIN PRODUCT_IMG PI ON R.PRODUCT_NO = PI.PRODUCT_NO AND PI.THUMBNAIL_YN = 'Y' WHERE R.MEMBER_NO = ? AND R.DELETED_YN = 'N' ORDER BY R.REVIEW_NO DESC, R.CREATED_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMemberVo.getMemberNo());

		ResultSet rs = pstmt.executeQuery();

		List<ReviewDto> reviews = new ArrayList<ReviewDto>();

		while (rs.next()) {
			String reviewNo = rs.getString("REVIEW_NO");
			String memberNo = rs.getString("MEMBER_NO");
			String memberName = rs.getString("MEMBER_NAME");
			String productNo = rs.getString("PRODUCT_NO");
			String productName = rs.getString("PRODUCT_NAME");
			String rating = rs.getString("RATING");
			String content = rs.getString("CONTENT");
			String createdDate = rs.getString("CREATED_DATE");
			String editedDate = rs.getString("EDITED_DATE");
			String deletedYn = rs.getString("DELETED_YN");
			String productSize = rs.getString("PRODUCT_SIZE");
			String productColor = rs.getString("PRODUCT_COLOR");
			String colorHex = rs.getString("COLOR_HEX");
			String orderQuantity = rs.getString("PRODUCT_QUANTITY");
			String thumbnailFilename = rs.getString("THUMBNAIL_FILENAME");
			ReviewDto dto = new ReviewDto();
			dto.setReviewNo(reviewNo);
			dto.setMemberNo(memberNo);
			dto.setMemberName(memberName);
			dto.setProductNo(productNo);
			dto.setProductName(productName);
			dto.setRating(rating);
			dto.setContent(content);
			dto.setCreatedDate(createdDate);
			dto.setEditedDate(editedDate);
			dto.setDeletedYn(deletedYn);
			dto.setProductSize(productSize);
			dto.setProductColor(productColor);
			dto.setColorHex(colorHex);
			dto.setOrderQuantity(orderQuantity);
			dto.setThumbnailFilename(thumbnailFilename);
			reviews.add(dto);
		}

		close(rs);
		close(pstmt);

		return reviews;
	}

	public int editReview(SqlSession ss, ReviewVo rvo) {
		int result = ss.update("ReviewMapper.editReview", rvo);
		return result;
	}

	public int deleteReview(SqlSession ss, ReviewVo rvo) {
		int result = ss.update("ReviewMapper.deleteReview", rvo);
		return result;
	}
}
