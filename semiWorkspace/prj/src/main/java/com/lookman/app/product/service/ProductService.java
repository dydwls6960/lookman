package com.lookman.app.product.service;

import static com.lookman.app.db.JDBCTemplate.close;
import static com.lookman.app.db.JDBCTemplate.commit;
import static com.lookman.app.db.JDBCTemplate.getConnection;
import static com.lookman.app.db.JDBCTemplate.rollback;
import static com.lookman.app.db.SQLSessionTemplate.getSqlSession;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lookman.app.image.dao.ImageDao;
import com.lookman.app.image.vo.ImageVo;
import com.lookman.app.inquiry.dao.ProductInquiryDao;
import com.lookman.app.inquiry.dto.ProductInquiryDto;
import com.lookman.app.product.dao.ProductDao;
import com.lookman.app.product.dto.ProductByDto;
import com.lookman.app.product.dto.ProductDetailsDto;
import com.lookman.app.product.dto.ProductHomeDto;
import com.lookman.app.product.vo.ProductVo;
import com.lookman.app.review.dao.ReviewDao;
import com.lookman.app.review.dto.ReviewDto;

public class ProductService {
	private ProductDao dao;
	private ImageDao imgDao;
	private ReviewDao revDao;
	private ProductInquiryDao inqDao;

	public ProductService() {
		this.dao = new ProductDao();
		this.imgDao = new ImageDao();
		this.revDao = new ReviewDao();
		this.inqDao = new ProductInquiryDao();
	}

	public List<ProductHomeDto> selectProducts() throws Exception {

		Connection conn = getConnection();

		List<ProductHomeDto> dtoList = dao.selectProducts(conn);

		close(conn);

		return dtoList;
	}

	public List<ProductHomeDto> selectProductsRanking() throws Exception {

		Connection conn = getConnection();

		List<ProductHomeDto> dtoList = dao.selectProductsRanking(conn);

		close(conn);

		return dtoList;
	}

	public ProductVo selectProductByNo(String productNo) throws Exception {
		// logic

		// dao
		Connection conn = getConnection();
		ProductVo pvo = dao.selectProductByNo(conn, productNo);

		close(conn);

		return pvo;
	}

	public ProductDetailsDto selectProductDetails(String productNo) throws Exception {
		Connection conn = null;
		ProductDetailsDto dto = null;
		List<ImageVo> images = null;
		List<ReviewDto> reviews = null;
		List<ProductInquiryDto> inquiries = null;

		try {
			// dao
			conn = getConnection();

			// 상품상세
			dto = dao.selectProductDetails(conn, productNo);

			// 이미지들
			images = imgDao.getProductImagesByNo(conn, productNo);
			for (ImageVo imageVo : images) {
				if (imageVo.getThumbnailYn().equals("Y")) {
					// 썸네일 사진 구분
					dto.setThumbnailFilename(imageVo.getFilename());
					break;
				}
			}
			dto.setImages(images);

			// 리뷰들
			reviews = revDao.getReviewsByProductNo(conn, productNo);
			dto.setReviews(reviews);

			// 문의사항
			inquiries = inqDao.getInquiriesByProductNo(conn, productNo);
			dto.setInquiries(inquiries);

			// 조회수 증가
			int result = dao.incrementHit(conn, productNo);

			if (result == 1) {
				commit(conn);
			} else {
				rollback(conn);
			}

		} finally {
			close(conn);
		}

		return dto;
	}

	public List<ProductByDto> selectProductByCategoryNo(String categoryNo) throws Exception {
		SqlSession ss = getSqlSession();
		List<ProductByDto> dtoList = dao.selectProductByCategoryNo(ss, categoryNo);
		ss.close();
		return dtoList;
	}

	public List<ProductByDto> selectProductBySellerNo(String sellerNo) throws Exception {
		SqlSession ss = getSqlSession();
		List<ProductByDto> dtoList = dao.selectProductBySellerNo(ss, sellerNo);
		ss.close();
		return dtoList;
	}

}
