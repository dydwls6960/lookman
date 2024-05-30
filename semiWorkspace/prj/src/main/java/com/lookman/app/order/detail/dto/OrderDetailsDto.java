package com.lookman.app.order.detail.dto;

public class OrderDetailsDto {
	private String ordersNo;
	private String orderDetailNo;
	private String sellerNo;
	private String sellerName;
	private String productNo;
	private String productName;
	private String productPrice;
	private String orderDetailPrice;
	private String orderDetailQuantity;
	private String orderStatusNo;
	private String orderStatusName;
	private String orderDetailStatusNo;
	private String orderDetailStatusName;
	private String inventoryNo;
	private String sizeName;
	private String colorName;
	private String thumbnailFilename;
	private String orderDate;

	public OrderDetailsDto() {
	}

	public OrderDetailsDto(String ordersNo, String orderDetailNo, String sellerNo, String sellerName, String productNo,
			String productName, String productPrice, String orderDetailPrice, String orderDetailQuantity,
			String orderStatusNo, String orderStatusName, String orderDetailStatusNo, String orderDetailStatusName,
			String inventoryNo, String sizeName, String colorName, String thumbnailFilename, String orderDate) {
		this.ordersNo = ordersNo;
		this.orderDetailNo = orderDetailNo;
		this.sellerNo = sellerNo;
		this.sellerName = sellerName;
		this.productNo = productNo;
		this.productName = productName;
		this.productPrice = productPrice;
		this.orderDetailPrice = orderDetailPrice;
		this.orderDetailQuantity = orderDetailQuantity;
		this.orderStatusNo = orderStatusNo;
		this.orderStatusName = orderStatusName;
		this.orderDetailStatusNo = orderDetailStatusNo;
		this.orderDetailStatusName = orderDetailStatusName;
		this.inventoryNo = inventoryNo;
		this.sizeName = sizeName;
		this.colorName = colorName;
		this.thumbnailFilename = thumbnailFilename;
		this.orderDate = orderDate;
	}

	public String getOrdersNo() {
		return ordersNo;
	}

	public void setOrdersNo(String ordersNo) {
		this.ordersNo = ordersNo;
	}

	public String getOrderDetailNo() {
		return orderDetailNo;
	}

	public void setOrderDetailNo(String orderDetailNo) {
		this.orderDetailNo = orderDetailNo;
	}

	public String getSellerNo() {
		return sellerNo;
	}

	public void setSellerNo(String sellerNo) {
		this.sellerNo = sellerNo;
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

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getOrderDetailPrice() {
		return orderDetailPrice;
	}

	public void setOrderDetailPrice(String orderDetailPrice) {
		this.orderDetailPrice = orderDetailPrice;
	}

	public String getOrderDetailQuantity() {
		return orderDetailQuantity;
	}

	public void setOrderDetailQuantity(String orderDetailQuantity) {
		this.orderDetailQuantity = orderDetailQuantity;
	}

	public String getOrderStatusNo() {
		return orderStatusNo;
	}

	public void setOrderStatusNo(String orderStatusNo) {
		this.orderStatusNo = orderStatusNo;
	}

	public String getOrderStatusName() {
		return orderStatusName;
	}

	public void setOrderStatusName(String orderStatusName) {
		this.orderStatusName = orderStatusName;
	}

	public String getOrderDetailStatusNo() {
		return orderDetailStatusNo;
	}

	public void setOrderDetailStatusNo(String orderDetailStatusNo) {
		this.orderDetailStatusNo = orderDetailStatusNo;
	}

	public String getOrderDetailStatusName() {
		return orderDetailStatusName;
	}

	public void setOrderDetailStatusName(String orderDetailStatusName) {
		this.orderDetailStatusName = orderDetailStatusName;
	}

	public String getInventoryNo() {
		return inventoryNo;
	}

	public void setInventoryNo(String inventoryNo) {
		this.inventoryNo = inventoryNo;
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

	public String getThumbnailFilename() {
		return thumbnailFilename;
	}

	public void setThumbnailFilename(String thumbnailFilename) {
		this.thumbnailFilename = thumbnailFilename;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "OrderDetailsDto [ordersNo=" + ordersNo + ", orderDetailNo=" + orderDetailNo + ", sellerNo=" + sellerNo
				+ ", sellerName=" + sellerName + ", productNo=" + productNo + ", productName=" + productName
				+ ", productPrice=" + productPrice + ", orderDetailPrice=" + orderDetailPrice + ", orderDetailQuantity="
				+ orderDetailQuantity + ", orderStatusNo=" + orderStatusNo + ", orderStatusName=" + orderStatusName
				+ ", orderDetailStatusNo=" + orderDetailStatusNo + ", orderDetailStatusName=" + orderDetailStatusName
				+ ", inventoryNo=" + inventoryNo + ", sizeName=" + sizeName + ", colorName=" + colorName
				+ ", thumbnailFilename=" + thumbnailFilename + ", orderDate=" + orderDate + "]";
	}

}
