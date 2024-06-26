package com.lookman.app.order.dto;

public class OrderFormDetailsDto {
	private String thumbnailFilename;
	private String sellerName;
	private String productNo;
	private String productName;
	private String sizeName;
	private String colorName;
	private String orderQuantity;
	private String inventoryQuantity;
	private String productPrice;
	private String orderPrice;
	private String inventoryNo;

	public OrderFormDetailsDto() {
	}

	public OrderFormDetailsDto(String thumbnailFilename, String sellerName, String productNo, String productName,
			String sizeName, String colorName, String orderQuantity, String inventoryQuantity, String productPrice,
			String orderPrice, String inventoryNo) {
		this.thumbnailFilename = thumbnailFilename;
		this.sellerName = sellerName;
		this.productNo = productNo;
		this.productName = productName;
		this.sizeName = sizeName;
		this.colorName = colorName;
		this.orderQuantity = orderQuantity;
		this.inventoryQuantity = inventoryQuantity;
		this.productPrice = productPrice;
		this.orderPrice = orderPrice;
		this.inventoryNo = inventoryNo;
	}

	public String getThumbnailFilename() {
		return thumbnailFilename;
	}

	public void setThumbnailFilename(String thumbnailFilename) {
		this.thumbnailFilename = thumbnailFilename;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSizeName() {
		return sizeName;
	}

	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public String getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(String orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public String getInventoryQuantity() {
		return inventoryQuantity;
	}

	public void setInventoryQuantity(String inventoryQuantity) {
		this.inventoryQuantity = inventoryQuantity;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getInventoryNo() {
		return inventoryNo;
	}

	public void setInventoryNo(String inventoryNo) {
		this.inventoryNo = inventoryNo;
	}

	@Override
	public String toString() {
		return "OrderFormDetailsDto [thumbnailFilename=" + thumbnailFilename + ", sellerName=" + sellerName
				+ ", productNo=" + productNo + ", productName=" + productName + ", sizeName=" + sizeName
				+ ", colorName=" + colorName + ", orderQuantity=" + orderQuantity + ", inventoryQuantity="
				+ inventoryQuantity + ", productPrice=" + productPrice + ", orderPrice=" + orderPrice + ", inventoryNo="
				+ inventoryNo + "]";
	}

}
