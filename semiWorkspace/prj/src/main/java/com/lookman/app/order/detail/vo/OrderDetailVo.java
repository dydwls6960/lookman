package com.lookman.app.order.detail.vo;

public class OrderDetailVo {
	private String orderDetailNo;
	private String ordersNo;
	private String productNo;
	private String inventoryNo;
	private String quantity;

	public OrderDetailVo() {
	}

	public OrderDetailVo(String orderDetailNo, String ordersNo, String productNo, String inventoryNo, String quantity) {
		this.orderDetailNo = orderDetailNo;
		this.ordersNo = ordersNo;
		this.productNo = productNo;
		this.inventoryNo = inventoryNo;
		this.quantity = quantity;
	}

	public String getOrderDetailNo() {
		return orderDetailNo;
	}

	public void setOrderDetailNo(String orderDetailNo) {
		this.orderDetailNo = orderDetailNo;
	}

	public String getOrdersNo() {
		return ordersNo;
	}

	public void setOrdersNo(String ordersNo) {
		this.ordersNo = ordersNo;
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
		return "OrderDetailVo [orderDetailNo=" + orderDetailNo + ", ordersNo=" + ordersNo + ", productNo=" + productNo
				+ ", inventoryNo=" + inventoryNo + ", quantity=" + quantity + "]";
	}

}
