package com.lookman.app.seller.vo;

public class SellerSimpleOrderListVo {
	private String ordersNo;
	private String memberId;
	private String memberName;
	private String statusName; 
	private String cardName;
	private String shippingFee;
	private String productPrice;
	private String createdDate;
	public SellerSimpleOrderListVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SellerSimpleOrderListVo(String ordersNo, String memberId, String memberName, String statusName,
			String cardName, String shippingFee, String productPrice, String createdDate) {
		super();
		this.ordersNo = ordersNo;
		this.memberId = memberId;
		this.memberName = memberName;
		this.statusName = statusName;
		this.cardName = cardName;
		this.shippingFee = shippingFee;
		this.productPrice = productPrice;
		this.createdDate = createdDate;
	}
	public String getOrdersNo() {
		return ordersNo;
	}
	public void setOrdersNo(String ordersNo) {
		this.ordersNo = ordersNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getShippingFee() {
		return shippingFee;
	}
	public void setShippingFee(String shippingFee) {
		this.shippingFee = shippingFee;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "SellerSimpleOrderListVo [ordersNo=" + ordersNo + ", memberId=" + memberId + ", memberName=" + memberName
				+ ", statusName=" + statusName + ", cardName=" + cardName + ", shippingFee=" + shippingFee
				+ ", productPrice=" + productPrice + ", createdDate=" + createdDate + "]";
	}
	
	
}
