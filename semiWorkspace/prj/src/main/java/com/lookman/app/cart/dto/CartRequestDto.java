package com.lookman.app.cart.dto;

import java.util.List;

import com.lookman.app.cart.vo.CartItemVo;

public class CartRequestDto {
	private List<CartItemVo> items;

	public CartRequestDto() {
	}

	public CartRequestDto(List<CartItemVo> items) {
		this.items = items;
	}

	public List<CartItemVo> getItems() {
		return items;
	}

	public void setItems(List<CartItemVo> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "CartRequestDto [items=" + items + "]";
	}

}
