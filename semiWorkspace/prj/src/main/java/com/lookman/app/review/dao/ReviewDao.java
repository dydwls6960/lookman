package com.lookman.app.review.dao;

import static com.lookman.app.db.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lookman.app.review.vo.ReviewVo;

public class ReviewDao {
	public List<ReviewVo> getReviewsByProductNo(Connection conn, String productNo) throws Exception {
		String sql = "SELECT * FROM REVIEW WHERE PRODUCT_NO = ? AND DELETED_YN = 'N' ORDER BY REVIEW_NO DESC, CREATED_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, productNo);
		ResultSet rs = pstmt.executeQuery();

		List<ReviewVo> reviews = new ArrayList<ReviewVo>();
		while (rs.next()) {
			String reviewNo = rs.getString("REVIEW_NO");
			String memberNo = rs.getString("MEMBER_NO");
			String prodNo = rs.getString("PRODUCT_NO");
			String rating = rs.getString("RATING");
			String content = rs.getString("CONTENT");
			String createdDate = rs.getString("CREATED_DATE");
			String deletedYn = rs.getString("DELETED_YN");

			ReviewVo vo = new ReviewVo();
			vo.setReviewNo(reviewNo);
			vo.setMemberNo(memberNo);
			vo.setProductNo(prodNo);
			vo.setRating(rating);
			vo.setContent(content);
			vo.setCreatedDate(createdDate);
			vo.setDeletedYn(deletedYn);
			reviews.add(vo);
		}

		close(rs);
		close(pstmt);

		return reviews;
	}
}
