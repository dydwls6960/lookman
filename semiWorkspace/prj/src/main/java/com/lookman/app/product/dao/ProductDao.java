package com.lookman.app.product.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lookman.app.image.vo.ImageVo;
import com.lookman.app.product.dto.ProductDetailsDto;
import com.lookman.app.product.vo.ProductVo;
import static com.lookman.app.db.JDBCTemplate.*;

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
			pvoList.add(pvo);

		}

		return pvoList;
	}

	public ProductVo selectProductByNo(Connection conn, String productNo) throws Exception {
		String sql = "SELECT P.PRODUCT_NO, S.NAME SELLER_NAME, P.NAME NAME, P.DETAILS, P.PRICE, P.HIT FROM PRODUCT P JOIN SELLER S ON P.SELLER_NO = S.SELLER_NO WHERE P.PRODUCT_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, productNo);

		ResultSet rs = pstmt.executeQuery();
		ProductVo pvo = null;
		if (rs.next()) {
			String prodNo = rs.getString("PRODUCT_NO");
			String sellerNo = rs.getString("SELLER_NAME");
			String name = rs.getString("NAME");
			String details = rs.getString("DETAILS");
			String price = rs.getString("PRICE");
			String hit = rs.getString("HIT");

			pvo = new ProductVo();
			pvo.setProductNo(prodNo);
			pvo.setSellerNo(sellerNo);
			pvo.setName(name);
			pvo.setDetails(details);
			pvo.setPrice(price);
			pvo.setHit(hit);
		}

		return pvo;
	}

	public ProductDetailsDto selectProductDetails(Connection conn, String productNo) throws Exception {

		String sql = "SELECT S.NAME SELLER_NAME , P.NAME PRODUCT_NAME , P.PRICE PRICE , P.DETAILS DETAILS , P.HIT HIT , NVL(S.SHIPPING_INFO, '기본 배송') SHIPPING_DETAILS , NVL(ROUND(AVG(R.RATING), 1), 0) AVG_RATING , COUNT(R.REVIEW_NO) REVIEW_CNT FROM PRODUCT P JOIN SELLER S ON P.SELLER_NO = S.SELLER_NO LEFT JOIN REVIEW R ON R.PRODUCT_NO = P.PRODUCT_NO WHERE P.PRODUCT_NO = ? GROUP BY S.NAME, P.NAME, P.PRICE, P.DETAILS, P.HIT, NVL(S.SHIPPING_INFO, '기본 배송')";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, productNo);

		ResultSet rs = pstmt.executeQuery();

		ProductDetailsDto dto = null;

		if (rs.next()) {
			String sellerName = rs.getString("SELLER_NAME");
			String productName = rs.getString("PRODUCT_NAME");
			String price = rs.getString("PRICE");
			String details = rs.getString("DETAILS");
			String hit = rs.getString("HIT");
			String shippingDetails = rs.getString("SHIPPING_DETAILS");
			String avgRating = rs.getString("AVG_RATING");
			String reviewCnt = rs.getString("REVIEW_CNT");

			dto = new ProductDetailsDto();
			dto.setSellerName(sellerName);
			dto.setProductName(productName);
			dto.setPrice(price);
			dto.setDetails(details);
			dto.setHit(hit);
			if (avgRating.equals("0")) {
				dto.setAvgRating("0.0");
			} else {				
				dto.setAvgRating(avgRating);
			}
			dto.setShippingDetails(shippingDetails);
			dto.setReviewCnt(reviewCnt);
		}

		close(rs);
		close(pstmt);

		return dto;
	}

}
