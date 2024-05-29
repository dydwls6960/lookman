package com.lookman.app.inventory.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lookman.app.payment.dto.PaymentResponseDto;
import com.lookman.app.product.dto.ProductInventoryDto;

public class InventoryDao {

	public List<ProductInventoryDto> getSizeOptions(SqlSession ss, ProductInventoryDto idto) {
		return ss.selectList("InventoryMapper.getSizeOptions", idto);
	}

	public int decrementInventories(SqlSession ss, PaymentResponseDto payResDto) {
		return ss.update("InventoryMapper.decrementInventories", payResDto);
	}

}
