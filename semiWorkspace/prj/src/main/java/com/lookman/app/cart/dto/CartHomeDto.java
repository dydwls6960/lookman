package com.lookman.app.cart.dto;

public class CartHomeDto {
	private String rownum;
	private String memberNo;
	private String cartNo;
	private String productNo;
	private String productName;
	private String inventoryNo;
	private String colorNo;
	private String colorName;
	private String sizeNo;
	private String sizeName;
	private String price;
	private String orderPrice;
	private String thumbnailFilename;
	private String orderQuantity;
	private String inventoryQuantity;
	private String createdDate;
	private String sellerName;

	public CartHomeDto() {
	}

	public CartHomeDto(String rownum, String memberNo, String cartNo, String productNo, String productName,
			String inventoryNo, String colorNo, String colorName, String sizeNo, String sizeName, String price,
			String orderPrice, String thumbnailFilename, String orderQuantity, String inventoryQuantity,
			String createdDate, String sellerName) {
		this.rownum = rownum;
		this.memberNo = memberNo;
		this.cartNo = cartNo;
		this.productNo = productNo;
		this.productName = productName;
		this.inventoryNo = inventoryNo;
		this.colorNo = colorNo;
		this.colorName = colorName;
		this.sizeNo = sizeNo;
		this.sizeName = sizeName;
		this.price = price;
		this.orderPrice = orderPrice;
		this.thumbnailFilename = thumbnailFilename;
		this.orderQuantity = orderQuantity;
		this.inventoryQuantity = inventoryQuantity;
		this.createdDate = createdDate;
		this.sellerName = sellerName;
	}

	public String getRownum() {
		return rownum;
	}

	public void setRownum(String rownum) {
		this.rownum = rownum;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getCartNo() {
		return cartNo;
	}

	public void setCartNo(String cartNo) {
		this.cartNo = cartNo;
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

	public String getInventoryNo() {
		return inventoryNo;
	}

	public void setInventoryNo(String inventoryNo) {
		this.inventoryNo = inventoryNo;
	}

	public String getColorNo() {
		return colorNo;
	}

	public void setColorNo(String colorNo) {
		this.colorNo = colorNo;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public String getSizeNo() {
		return sizeNo;
	}

	public void setSizeNo(String sizeNo) {
		this.sizeNo = sizeNo;
	}

	public String getSizeName() {
		return sizeName;
	}

	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getThumbnailFilename() {
		return thumbnailFilename;
	}

	public void setThumbnailFilename(String thumbnailFilename) {
		this.thumbnailFilename = thumbnailFilename;
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

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	@Override
	public String toString() {
		return "CartHomeDto [rownum=" + rownum + ", memberNo=" + memberNo + ", cartNo=" + cartNo + ", productNo="
				+ productNo + ", productName=" + productName + ", inventoryNo=" + inventoryNo + ", colorNo=" + colorNo
				+ ", colorName=" + colorName + ", sizeNo=" + sizeNo + ", sizeName=" + sizeName + ", price=" + price
				+ ", orderPrice=" + orderPrice + ", thumbnailFilename=" + thumbnailFilename + ", orderQuantity="
				+ orderQuantity + ", inventoryQuantity=" + inventoryQuantity + ", createdDate=" + createdDate
				+ ", sellerName=" + sellerName + "]";
	}

}
