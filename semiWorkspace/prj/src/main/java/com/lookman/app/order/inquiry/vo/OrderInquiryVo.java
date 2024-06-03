package com.lookman.app.order.inquiry.vo;

public class OrderInquiryVo {
	private String orderInquiryNo;
	private String orderDetailNo;
	private String memberNo;
	private String sellerNo;
	private String statusNo;
	private String title;
	private String questionContent;
	private String responseContent;
	private String askDate;
	private String responseDate;
	private String deletedYn;

	public OrderInquiryVo() {
	}

	public OrderInquiryVo(String orderInquiryNo, String orderDetailNo, String memberNo, String sellerNo,
			String statusNo, String title, String questionContent, String responseContent, String askDate,
			String responseDate, String deletedYn) {
		this.orderInquiryNo = orderInquiryNo;
		this.orderDetailNo = orderDetailNo;
		this.memberNo = memberNo;
		this.sellerNo = sellerNo;
		this.statusNo = statusNo;
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

	public String getSellerNo() {
		return sellerNo;
	}

	public void setSellerNo(String sellerNo) {
		this.sellerNo = sellerNo;
	}

	public String getStatusNo() {
		return statusNo;
	}

	public void setStatusNo(String statusNo) {
		this.statusNo = statusNo;
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
		return "OrderInquiryVo [orderInquiryNo=" + orderInquiryNo + ", orderDetailNo=" + orderDetailNo + ", memberNo="
				+ memberNo + ", sellerNo=" + sellerNo + ", statusNo=" + statusNo + ", title=" + title
				+ ", questionContent=" + questionContent + ", responseContent=" + responseContent + ", askDate="
				+ askDate + ", responseDate=" + responseDate + ", deletedYn=" + deletedYn + "]";
	}

}
