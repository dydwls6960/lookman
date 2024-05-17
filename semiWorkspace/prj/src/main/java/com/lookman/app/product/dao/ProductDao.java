package com.lookman.app.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lookman.app.product.vo.ProductVo;

public class ProductDao {

	public List<ProductVo> selectProducts(Connection conn) throws Exception {

		String sql = "SELECT P.PRODUCT_NO, TO_CHAR(P.PRICE, '999,999,999.00') PRICE, S.NAME SELLER_NAME, P.NAME PRODUCT_NAME, PI.FILENAME, NVL(ROUND(AVG(R.RATING), 1), 0) AVG_RATING, COUNT(R.RATING) REVIEW_CNT FROM PRODUCT P LEFT JOIN REVIEW R ON P.PRODUCT_NO = R.PRODUCT_NO JOIN PRODUCT_IMG PI ON P.PRODUCT_NO = PI.PRODUCT_NO JOIN SELLER S ON P.SELLER_NO = S.SELLER_NO WHERE PI.THUMBNAIL_YN = 'Y' AND P.DELETED_YN = 'N' AND PI.DELETED_YN = 'N' GROUP BY P.PRODUCT_NO, P.PRICE, S.NAME, P.NAME, PI.FILENAME ORDER BY AVG_RATING DESC, PRICE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<ProductVo> pvoList = new ArrayList<ProductVo>();

		while (rs.next()) {
			String productNo = rs.getString("PRODUCT_NO");
			String price = rs.getString("PRICE");
			String sellerName = rs.getString("SELLER_NAME");
			String productName = rs.getString("PRODUCT_NAME");
			String filename = rs.getString("FILENAME");
			String avgRating = rs.getString("AVG_RATING");
			String reviewCnt = rs.getString("REVIEW_CNT");

			ProductVo pvo = new ProductVo();
			pvo.setProductNo(productNo);
			pvo.setPrice(price);
			pvo.setSellerNo(sellerName);
			pvo.setName(productName);
			pvo.setFilename(filename);
			pvo.setRating(avgRating);
			pvo.setReviewCnt(reviewCnt);

			pvoList.add(pvo);

		}

		return pvoList;
	}

	public ProductVo selectProductByNo(Connection conn, String productNo) throws Exception {
		String sql = "";
		conn.prepareStatement(sql);
		ProductVo pvo = null;

		return pvo;
	}

}
