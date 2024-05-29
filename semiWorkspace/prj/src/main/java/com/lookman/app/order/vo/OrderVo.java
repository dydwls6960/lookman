package com.lookman.app.order.vo;

public class OrderVo {
	private String ordersNo;
	private String memberNo;
	private String addressNo;
	private String statusNo;
	private String createdDate;
	private String totalPrice;
	private String shippingReq;
	private String shippingFee;

	public OrderVo() {
	}

	public OrderVo(String ordersNo, String memberNo, String addressNo, String statusNo, String createdDate,
			String totalPrice, String shippingReq, String shippingFee) {
		this.ordersNo = ordersNo;
		this.memberNo = memberNo;
		this.addressNo = addressNo;
		this.statusNo = statusNo;
		this.createdDate = createdDate;
		this.totalPrice = totalPrice;
		this.shippingReq = shippingReq;
		this.shippingFee = shippingFee;
	}

	public String getOrdersNo() {
		return ordersNo;
	}

	public void setOrdersNo(String ordersNo) {
		this.ordersNo = ordersNo;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getAddressNo() {
		return addressNo;
	}

	public void setAddressNo(String addressNo) {
		this.addressNo = addressNo;
	}

	public String getStatusNo() {
		return statusNo;
	}

	public void setStatusNo(String statusNo) {
		this.statusNo = statusNo;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getShippingReq() {
		return shippingReq;
	}

	public void setShippingReq(String shippingReq) {
		this.shippingReq = shippingReq;
	}

	public String getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(String shippingFee) {
		this.shippingFee = shippingFee;
	}

	@Override
	public String toString() {
		return "OrdersVo [ordersNo=" + ordersNo + ", memberNo=" + memberNo + ", addressNo=" + addressNo + ", statusNo="
				+ statusNo + ", createdDate=" + createdDate + ", totalPrice=" + totalPrice + ", shippingReq="
				+ shippingReq + ", shippingFee=" + shippingFee + "]";
	}

}
