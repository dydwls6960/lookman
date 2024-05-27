package com.lookman.app.product.dto;

public class ProductInventoryDto {
	private String inventoryNo;
	private String productNo;
	private String colorNo;
	private String colorName;
	private String sizeNo;
	private String sizeName;
	private String inventoryQuantity;

	public ProductInventoryDto() {
	}

	public ProductInventoryDto(String inventoryNo, String productNo, String colorNo, String colorName, String sizeNo,
			String sizeName, String inventoryQuantity) {
		this.inventoryNo = inventoryNo;
		this.productNo = productNo;
		this.colorNo = colorNo;
		this.colorName = colorName;
		this.sizeNo = sizeNo;
		this.sizeName = sizeName;
		this.inventoryQuantity = inventoryQuantity;
	}

	public String getInventoryNo() {
		return inventoryNo;
	}

	public void setInventoryNo(String inventoryNo) {
		this.inventoryNo = inventoryNo;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
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

	public String getInventoryQuantity() {
		return inventoryQuantity;
	}

	public void setInventoryQuantity(String inventoryQuantity) {
		this.inventoryQuantity = inventoryQuantity;
	}

	@Override
	public String toString() {
		return "ProductInventoryDto [inventoryNo=" + inventoryNo + ", productNo=" + productNo + ", colorNo=" + colorNo
				+ ", colorName=" + colorName + ", sizeNo=" + sizeNo + ", sizeName=" + sizeName + ", inventoryQuantity="
				+ inventoryQuantity + "]";
	}

}
