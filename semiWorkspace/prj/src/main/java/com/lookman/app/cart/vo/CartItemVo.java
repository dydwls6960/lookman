package com.lookman.app.cart.vo;

public class CartItemVo {
	private String cartNo;
	private String memberNo;
	private String inventoryNo;
	private String quantity;
	private String createdDate;

	public CartItemVo() {
	}

	public CartItemVo(String cartNo, String memberNo, String inventoryNo, String quantity, String createdDate) {
		this.cartNo = cartNo;
		this.memberNo = memberNo;
		this.inventoryNo = inventoryNo;
		this.quantity = quantity;
		this.createdDate = createdDate;
	}

	public String getCartNo() {
		return cartNo;
	}

	public void setCartNo(String cartNo) {
		this.cartNo = cartNo;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getInventoryNo() {
		return inventoryNo;
	}

	public void setInventoryNo(String inventoryNo) {
		this.inventoryNo = inventoryNo;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "CartItemVo [cartNo=" + cartNo + ", memberNo=" + memberNo + ", inventoryNo=" + inventoryNo
				+ ", quantity=" + quantity + ", createdDate=" + createdDate + "]";
	}

}
