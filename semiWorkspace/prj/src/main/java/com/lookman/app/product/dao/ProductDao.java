package com.lookman.app.product.dao;

import static com.lookman.app.db.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lookman.app.product.dto.ProductByDto;
import com.lookman.app.product.dto.ProductDetailsDto;
import com.lookman.app.product.dto.ProductHomeDto;
import com.lookman.app.product.dto.ProductInventoryDto;
import com.lookman.app.product.vo.ProductVo;

public class ProductDao {

	public List<ProductHomeDto> selectProducts(Connection conn) throws Exception {
		String sql = "SELECT P.PRODUCT_NO, TO_CHAR(P.PRICE, '999,999,999') PRICE, S.NAME SELLER_NAME, P.NAME PRODUCT_NAME, PI.FILENAME, NVL(ROUND(AVG(R.RATING), 1), 0) AVG_RATING, COUNT(R.RATING) REVIEW_CNT FROM PRODUCT P LEFT JOIN REVIEW R ON P.PRODUCT_NO = R.PRODUCT_NO JOIN PRODUCT_IMG PI ON P.PRODUCT_NO = PI.PRODUCT_NO JOIN SELLER S ON P.SELLER_NO = S.SELLER_NO WHERE PI.THUMBNAIL_YN = 'Y' AND P.DELETED_YN = 'N' AND PI.DELETED_YN = 'N' GROUP BY P.PRODUCT_NO, P.PRICE, S.NAME, P.NAME, PI.FILENAME ORDER BY P.PRODUCT_NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<ProductHomeDto> dtoList = new ArrayList<ProductHomeDto>();

		while (rs.next()) {
			String productNo = rs.getString("PRODUCT_NO");
			String price = rs.getString("PRICE");
			String sellerName = rs.getString("SELLER_NAME");
			String productName = rs.getString("PRODUCT_NAME");
			String filename = rs.getString("FILENAME");
			String avgRating = rs.getString("AVG_RATING");
			String reviewCnt = rs.getString("REVIEW_CNT");

			ProductHomeDto dto = new ProductHomeDto();
			dto.setProductNo(productNo);
			dto.setPrice(price);
			dto.setSellerName(sellerName);
			dto.setProductName(productName);
			dto.setThumbnailFilename(filename);
			dto.setAvgRating(avgRating);
			dto.setReviewCnt(reviewCnt);

			dtoList.add(dto);
		}

		close(pstmt);
		close(rs);

		return dtoList;
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

		String sql = "SELECT S.SELLER_NO SELLER_NO , S.NAME SELLER_NAME , P.PRODUCT_NO PRODUCT_NO , P.NAME PRODUCT_NAME , TO_CHAR(P.PRICE, '999,999,999') PRICE , P.DETAILS DETAILS , P.HIT HIT , NVL(S.SHIPPING_INFO, '기본 배송') SHIPPING_DETAILS , NVL(ROUND(AVG(R.RATING), 1), 0) AVG_RATING , COUNT(R.REVIEW_NO) REVIEW_CNT FROM PRODUCT P JOIN SELLER S ON P.SELLER_NO = S.SELLER_NO LEFT JOIN REVIEW R ON R.PRODUCT_NO = P.PRODUCT_NO WHERE P.PRODUCT_NO = ? GROUP BY S.SELLER_NO, S.NAME, P.PRODUCT_NO, P.NAME, P.PRICE, P.DETAILS, P.HIT, NVL(S.SHIPPING_INFO, '기본 배송')";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, productNo);

		ResultSet rs = pstmt.executeQuery();

		ProductDetailsDto dto = null;

		if (rs.next()) {
			String sellerNo = rs.getString("SELLER_NO");
			String sellerName = rs.getString("SELLER_NAME");
			String prodNo = rs.getString("PRODUCT_NO");
			String productName = rs.getString("PRODUCT_NAME");
			String price = rs.getString("PRICE");
			String details = rs.getString("DETAILS");
			String hit = rs.getString("HIT");
			String shippingDetails = rs.getString("SHIPPING_DETAILS");
			String avgRating = rs.getString("AVG_RATING");
			String reviewCnt = rs.getString("REVIEW_CNT");

			dto = new ProductDetailsDto();
			dto.setSellerNo(sellerNo);
			dto.setSellerName(sellerName);
			dto.setProductNo(prodNo);
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

	public List<ProductHomeDto> selectProductsRanking(Connection conn) throws Exception {
		String sql = "SELECT P.PRODUCT_NO, TO_CHAR(P.PRICE, '999,999,999') PRICE, S.NAME SELLER_NAME, P.NAME PRODUCT_NAME, PI.FILENAME, NVL(ROUND(AVG(R.RATING), 1), 0) AVG_RATING, COUNT(R.RATING) REVIEW_CNT FROM PRODUCT P LEFT JOIN REVIEW R ON P.PRODUCT_NO = R.PRODUCT_NO JOIN PRODUCT_IMG PI ON P.PRODUCT_NO = PI.PRODUCT_NO JOIN SELLER S ON P.SELLER_NO = S.SELLER_NO WHERE PI.THUMBNAIL_YN = 'Y' AND P.DELETED_YN = 'N' AND PI.DELETED_YN = 'N' GROUP BY P.PRODUCT_NO, P.PRICE, S.NAME, P.NAME, PI.FILENAME ORDER BY NVL(ROUND(AVG(R.RATING), 1), 0) DESC, COUNT(R.RATING) DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<ProductHomeDto> dtoList = new ArrayList<ProductHomeDto>();

		while (rs.next()) {
			String productNo = rs.getString("PRODUCT_NO");
			String price = rs.getString("PRICE");
			String sellerName = rs.getString("SELLER_NAME");
			String productName = rs.getString("PRODUCT_NAME");
			String filename = rs.getString("FILENAME");
			String avgRating = rs.getString("AVG_RATING");
			String reviewCnt = rs.getString("REVIEW_CNT");

			ProductHomeDto dto = new ProductHomeDto();
			dto.setProductNo(productNo);
			dto.setPrice(price);
			dto.setSellerName(sellerName);
			dto.setProductName(productName);
			dto.setThumbnailFilename(filename);
			dto.setAvgRating(avgRating);
			dto.setReviewCnt(reviewCnt);

			dtoList.add(dto);
		}

		close(pstmt);
		close(rs);

		return dtoList;

	}

	public int incrementHit(Connection conn, String productNo) throws Exception {
		String sql = "UPDATE PRODUCT SET HIT = HIT + 1 WHERE PRODUCT_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, productNo);

		int result = pstmt.executeUpdate();

		close(pstmt);

		return result;
	}

	public List<ProductByDto> selectProductByCategoryNo(SqlSession ss, String categoryNo) {
		return ss.selectList("ProductMapper.selectProductByCategoryNo", categoryNo);
	}

	public List<ProductByDto> selectProductBySellerNo(SqlSession ss, String sellerNo) {
		return ss.selectList("ProductMapper.selectProductBySellerNo", sellerNo);
	}

	public List<ProductInventoryDto> getProductInventoryDetails(Connection conn, String productNo) throws SQLException {
		String sql = "SELECT I.INVENTORY_NO, I.PRODUCT_NO, I.COLOR_NO, C.NAME COLOR_NAME, I.SIZE_NO, PS.NAME SIZE_NAME, I.QUANTITY INVENTORY_QUANTITY, TO_CHAR(P.PRICE, '999,999,999') PRODUCT_PRICE FROM INVENTORY I JOIN COLOR C ON I.COLOR_NO = C.COLOR_NO JOIN PRODUCT_SIZE PS ON I.SIZE_NO = PS.SIZE_NO JOIN PRODUCT P ON I.PRODUCT_NO = P.PRODUCT_NO WHERE I.PRODUCT_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, productNo);
		ResultSet rs = pstmt.executeQuery();

		List<ProductInventoryDto> inventoryDetails = new ArrayList<ProductInventoryDto>();
		while (rs.next()) {
			String inventoryNo = rs.getString("INVENTORY_NO");
			String prodNo = rs.getString("PRODUCT_NO");
			String colorNo = rs.getString("COLOR_NO");
			String colorName = rs.getString("COLOR_NAME");
			String sizeNo = rs.getString("SIZE_NO");
			String sizeName = rs.getString("SIZE_NAME");
			String inventoryQuantity = rs.getString("INVENTORY_QUANTITY");
			String productPrice = rs.getString("PRODUCT_PRICE");
			ProductInventoryDto dto = new ProductInventoryDto();
			dto.setInventoryNo(inventoryNo);
			dto.setProductNo(prodNo);
			dto.setColorNo(colorNo);
			dto.setColorName(colorName);
			dto.setSizeNo(sizeNo);
			dto.setSizeName(sizeName);
			dto.setInventoryQuantity(inventoryQuantity);
			dto.setProductPrice(productPrice);
			inventoryDetails.add(dto);
		}

		close(rs);
		close(pstmt);

		return inventoryDetails;
	}

	public List<ProductHomeDto> searchProducts(SqlSession ss, String name) {
		return ss.selectList("ProductMapper.searchProducts", name);
	}

}
