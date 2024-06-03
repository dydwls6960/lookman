package com.lookman.app.inquiry.dto;

public class OrderMemberInquiryDto {
	private String orderInquiryNo;
	private String ordersNo;
	private String orderDetailNo;
	private String inventoryNo;
	private String productNo;
	private String productName;
	private String memberNo;
	private String memberName;
	private String sellerNo;
	private String sellerName;
	private String thumbnailFilename;
	private String status;
	private String title;
	private String questionContent;
	private String responseContent;
	private String askDate;
	private String responseDate;
	private String deletedYn;

	public OrderMemberInquiryDto() {
	}

	public OrderMemberInquiryDto(String orderInquiryNo, String ordersNo, String orderDetailNo, String inventoryNo,
			String productNo, String productName, String memberNo, String memberName, String sellerNo,
			String sellerName, String thumbnailFilename, String status, String title, String questionContent,
			String responseContent, String askDate, String responseDate, String deletedYn) {
		this.orderInquiryNo = orderInquiryNo;
		this.ordersNo = ordersNo;
		this.orderDetailNo = orderDetailNo;
		this.inventoryNo = inventoryNo;
		this.productNo = productNo;
		this.productName = productName;
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.sellerNo = sellerNo;
		this.sellerName = sellerName;
		this.thumbnailFilename = thumbnailFilename;
		this.status = status;
		this.title = title;
		this.questionContent = questionContent;
		this.responseContent = responseContent;
		this.askDate = askDate;
		this.responseDate = responseDate;
		this.deletedYn = deletedYn;
	}

	public String getOrderInquiryNo() {
		return orderInquiryNo;
	}

	public void setOrderInquiryNo(String orderInquiryNo) {
		this.orderInquiryNo = orderInquiryNo;
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public String getThumbnailFilename() {
		return thumbnailFilename;
	}

	public void setThumbnailFilename(String thumbnailFilename) {
		this.thumbnailFilename = thumbnailFilename;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public String getResponseContent() {
		return responseContent;
	}

	public void setResponseContent(String responseContent) {
		this.responseContent = responseContent;
	}

	public String getAskDate() {
		return askDate;
	}

	public void setAskDate(String askDate) {
		this.askDate = askDate;
	}

	public String getResponseDate() {
		return responseDate;
	}

	public void setResponseDate(String responseDate) {
		this.responseDate = responseDate;
	}

	public String getDeletedYn() {
		return deletedYn;
	}

	public void setDeletedYn(String deletedYn) {
		this.deletedYn = deletedYn;
	}

	@Override
	public String toString() {
		return "OrderMemberInquiryDto [orderInquiryNo=" + orderInquiryNo + ", ordersNo=" + ordersNo + ", orderDetailNo="
				+ orderDetailNo + ", inventoryNo=" + inventoryNo + ", productNo=" + productNo + ", productName="
				+ productName + ", memberNo=" + memberNo + ", memberName=" + memberName + ", sellerNo=" + sellerNo
				+ ", sellerName=" + sellerName + ", thumbnailFilename=" + thumbnailFilename + ", status=" + status
				+ ", title=" + title + ", questionContent=" + questionContent + ", responseContent=" + responseContent
				+ ", askDate=" + askDate + ", responseDate=" + responseDate + ", deletedYn=" + deletedYn + "]";
	}

}
