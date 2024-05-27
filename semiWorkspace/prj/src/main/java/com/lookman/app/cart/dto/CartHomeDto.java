package com.lookman.app.cart.dto;

public class CartHomeDto {
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
	private String thumbnailFilename;
	private String quantity;
	private String createdDate;

	public CartHomeDto() {
	}

	public CartHomeDto(String memberNo, String cartNo, String productNo, String productName, String inventoryNo,
			String colorNo, String colorName, String sizeNo, String sizeName, String price, String thumbnailFilename,
			String quantity, String createdDate) {
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
		this.thumbnailFilename = thumbnailFilename;
		this.quantity = quantity;
		this.createdDate = createdDate;
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

	public String getThumbnailFilename() {
		return thumbnailFilename;
	}

	public void setThumbnailFilename(String thumbnailFilename) {
		this.thumbnailFilename = thumbnailFilename;
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
		return "CartHomeDto [memberNo=" + memberNo + ", cartNo=" + cartNo + ", productNo=" + productNo
				+ ", productName=" + productName + ", inventoryNo=" + inventoryNo + ", colorNo=" + colorNo
				+ ", colorName=" + colorName + ", sizeNo=" + sizeNo + ", sizeName=" + sizeName + ", price=" + price
				+ ", thumbnailFilename=" + thumbnailFilename + ", quantity=" + quantity + ", createdDate=" + createdDate
				+ "]";
	}

}
