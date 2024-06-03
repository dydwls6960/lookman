package com.lookman.app.admin.member.vo;

public class AdminOrderListVo {
	private String orderNo;
	private String memberName;
	private String createdDate;
	private String totalPrice;
	public AdminOrderListVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminOrderListVo(String orderNo, String memberName, String createdDate, String totalPrice) {
		super();
		this.orderNo = orderNo;
		this.memberName = memberName;
		this.createdDate = createdDate;
		this.totalPrice = totalPrice;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
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
	@Override
	public String toString() {
		return "AdminOrderListVo [orderNo=" + orderNo + ", memberName=" + memberName + ", createdDate=" + createdDate
				+ ", totalPrice=" + totalPrice + "]";
	}
	
	

}
