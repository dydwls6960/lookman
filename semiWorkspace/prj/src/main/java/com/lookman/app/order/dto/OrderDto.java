package com.lookman.app.order.dto;

public class OrderDto {
	private String productName;
	private String sizeNo;
	private String sizeName;
	private String colorNo;
	private String colorName;
	private String orderQuantity;
	private String orderPrice;

	public OrderDto() {
	}

	public OrderDto(String productName, String sizeNo, String sizeName, String colorNo, String colorName,
			String orderQuantity, String orderPrice) {
		this.productName = productName;
		this.sizeNo = sizeNo;
		this.sizeName = sizeName;
		this.colorNo = colorNo;
		this.colorName = colorName;
		this.orderQuantity = orderQuantity;
		this.orderPrice = orderPrice;
	}

	public String getProductName() {
		return productName;
		
		
		
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public String getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(String orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public String getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
	}

	@Override
	public String toString() {
		return "OrderDto [productName=" + productName + ", sizeNo=" + sizeNo + ", sizeName=" + sizeName + ", colorNo="
				+ colorNo + ", colorName=" + colorName + ", orderQuantity=" + orderQuantity + ", orderPrice="
				+ orderPrice + "]";
	}

}
