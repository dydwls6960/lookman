package com.lookman.app.product.service;

import static com.lookman.app.db.JDBCTemplate.close;
import static com.lookman.app.db.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.lookman.app.image.dao.ImageDao;
import com.lookman.app.image.vo.ImageVo;
import com.lookman.app.product.dao.ProductDao;
import com.lookman.app.product.dto.ProductDetailsDto;
import com.lookman.app.product.dto.ProductHomeDto;
import com.lookman.app.product.vo.ProductVo;
import com.lookman.app.review.dao.ReviewDao;
import com.lookman.app.review.dto.ReviewDto;

public class ProductService {
	private ProductDao dao;
	private ImageDao imgDao;
	private ReviewDao revDao;

	public ProductService() {
		this.dao = new ProductDao();
		this.imgDao = new ImageDao();
		this.revDao = new ReviewDao();
	}

	public List<ProductHomeDto> selectProducts() throws Exception {

		Connection conn = getConnection();

		List<ProductHomeDto> dtoList = dao.selectProducts(conn);

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

		try {
			// dao
			conn = getConnection();

			// 상품상세
			dto = dao.selectProductDetails(conn, productNo);

			// 이미지들
			List<ImageVo> images = imgDao.getProductImagesByNo(conn, productNo);
			for (ImageVo imageVo : images) {
				if (imageVo.getThumbnailYn().equals("Y")) {
					// 썸네일 사진 구분
					dto.setThumbnailFilename(imageVo.getFilename());
					break;
				}
			}
			dto.setImages(images);

			// 리뷰들
			List<ReviewDto> reviews = revDao.getReviewsByProductNo(conn, productNo);
			dto.setReviews(reviews);

		} finally {
			close(conn);
		}

		return dto;
	}

}
