package com.lookman.app.image.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lookman.app.db.JDBCTemplate;
import com.lookman.app.image.vo.ImageVo;
import static com.lookman.app.db.JDBCTemplate.*;

public class ImageDao {

	public List<ImageVo> getProductImagesByNo(Connection conn, String productNo) throws Exception {
		String sql = "SELECT IMG_NO, PRODUCT_NO, FILENAME, THUMBNAIL_YN, DELETED_YN, CREATED_DATE FROM PRODUCT_IMG WHERE PRODUCT_NO = ? AND DELETED_YN = 'N' ORDER BY THUMBNAIL_YN DESC, IMG_NO ASC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, productNo);
		ResultSet rs = pstmt.executeQuery();

		List<ImageVo> images = new ArrayList<ImageVo>();
		while (rs.next()) {
			String imgNo = rs.getString("IMG_NO");
			String prodNo = rs.getString("PRODUCT_NO");
			String filename = rs.getString("FILENAME");
			String thumbnailYn = rs.getString("THUMBNAIL_YN");
			String deletedYn = rs.getString("DELETED_YN");
			String createdDate = rs.getString("CREATED_DATE");
			ImageVo vo = new ImageVo();

			vo.setImgNo(imgNo);
			vo.setProductNo(prodNo);
			vo.setFilename(filename);
			vo.setThumbnailYn(thumbnailYn);
			vo.setDeletedYn(deletedYn);
			vo.setCreatedDate(createdDate);
			images.add(vo);
		}

		close(rs);
		close(pstmt);

		return images;
	}

}
