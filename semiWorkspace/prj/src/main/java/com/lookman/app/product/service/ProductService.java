package com.lookman.app.product.service;

import java.sql.Connection;
import java.util.List;

import com.lookman.app.product.dao.ProductDao;
import com.lookman.app.product.vo.ProductVo;
import static com.lookman.app.db.JDBCTemplate.*;

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

}
