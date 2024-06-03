package com.lookman.app.seller.order.vo;

public class SellerOrderListVo {
	private String orderDetailNo;
	private String memberNo;
	private String memberName;
	private String statusNo;
	private String statusName;
	private String productNo;
	private String sellerNo;
	private String createDate;
	private String price;
	public SellerOrderListVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SellerOrderListVo(String orderDetailNo, String memberNo, String memberName, String statusNo,
			String statusName, String productNo, String sellerNo, String createDate, String price) {
		super();
		this.orderDetailNo = orderDetailNo;
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.statusNo = statusNo;
		this.statusName = statusName;
		this.productNo = productNo;
		this.sellerNo = sellerNo;
		this.createDate = createDate;
		this.price = price;
	}
	public String getOrderDetailNo() {
		return orderDetailNo;
	}
	public void setOrderDetailNo(String orderDetailNo) {
		this.orderDetailNo = orderDetailNo;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getStatusNo() {
		return statusNo;
	}
	public void setStatusNo(String statusNo) {
		this.statusNo = statusNo;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getSellerNo() {
		return sellerNo;
	}
	public void setSellerNo(String sellerNo) {
		this.sellerNo = sellerNo;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "SellerOrderListVo [orderDetailNo=" + orderDetailNo + ", memberNo=" + memberNo + ", memberName="
				+ memberName + ", statusNo=" + statusNo + ", statusName=" + statusName + ", productNo=" + productNo
				+ ", sellerNo=" + sellerNo + ", createDate=" + createDate + ", price=" + price + "]";
	}
	
	
	
	
	
}
