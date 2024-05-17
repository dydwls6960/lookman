package com.lookman.app.product.service;

import static com.lookman.app.db.JDBCTemplate.close;
import static com.lookman.app.db.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.lookman.app.product.dao.ProductDao;
import com.lookman.app.product.vo.ProductVo;

public class ProductService {
	private ProductDao dao;

	public ProductService() {
		this.dao = new ProductDao();
	}

	public List<ProductVo> selectProducts() throws Exception {

		Connection conn = getConnection();

		List<ProductVo> pvoList = dao.selectProducts(conn);

		close(conn);

		return pvoList;
	}

	public ProductVo selectProductByNo(String productNo) throws Exception {
		// logic

		// dao
		Connection conn = getConnection();
		ProductVo pvo = dao.selectProductByNo(conn, productNo);

		close(conn);

		return pvo;
	}

}
