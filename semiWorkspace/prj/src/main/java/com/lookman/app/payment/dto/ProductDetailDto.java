package com.lookman.app.payment.dto;

public class ProductDetailDto {
	private String productNo;
	private String inventoryNo;
	private String quantity;

	public ProductDetailDto() {
	}

	public ProductDetailDto(String productNo, String inventoryNo, String quantity) {
		this.productNo = productNo;
		this.inventoryNo = inventoryNo;
		this.quantity = quantity;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
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

	@Override
	public String toString() {
		return "ProductDetailDto [productNo=" + productNo + ", inventoryNo=" + inventoryNo + ", quantity=" + quantity
				+ "]";
	}

}
