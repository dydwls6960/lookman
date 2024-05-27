package com.lookman.app.inventory.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lookman.app.inventory.dao.InventoryDao;
import com.lookman.app.product.dto.ProductInventoryDto;
import static com.lookman.app.db.SQLSessionTemplate.*;

public class InventoryService {
	private final InventoryDao dao;
	
	public InventoryService() {
		this.dao = new InventoryDao();
	}
	
	public List<ProductInventoryDto> getSizeOptions(ProductInventoryDto idto) throws Exception {
		SqlSession ss = getSqlSession();
		
		List<ProductInventoryDto> idtoList = dao.getSizeOptions(ss, idto);
		
		ss.close();
		return idtoList;
	}

}
