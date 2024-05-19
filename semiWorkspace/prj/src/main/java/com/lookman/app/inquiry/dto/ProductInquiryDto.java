package com.lookman.app.inquiry.dto;

public class ProductInquiryDto {
	private String productInquiryNo;
	private String productNo;
	private String memberNo;
	private String memberName;
	private String sellerName;
	private String status;
	private String title;
	private String questionContent;
	private String responseContent;
	private String questionDate;
	private String responseDate;
	private String privateYn;
	private String deletedYn;

	public ProductInquiryDto() {
	}

	public ProductInquiryDto(String productInquiryNo, String productNo, String memberNo, String memberName,
			String sellerName, String status, String title, String questionContent, String responseContent,
			String questionDate, String responseDate, String privateYn, String deletedYn) {
		this.productInquiryNo = productInquiryNo;
		this.productNo = productNo;
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.sellerName = sellerName;
		this.status = status;
		this.title = title;
		this.questionContent = questionContent;
		this.responseContent = responseContent;
		this.questionDate = questionDate;
		this.responseDate = responseDate;
		this.privateYn = privateYn;
		this.deletedYn = deletedYn;
	}

	public String getProductInquiryNo() {
		return productInquiryNo;
	}

	public void setProductInquiryNo(String productInquiryNo) {
		this.productInquiryNo = productInquiryNo;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
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

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
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

	public String getQuestionDate() {
		return questionDate;
	}

	public void setQuestionDate(String questionDate) {
		this.questionDate = questionDate;
	}

	public String getResponseDate() {
		return responseDate;
	}

	public void setResponseDate(String responseDate) {
		this.responseDate = responseDate;
	}

	public String getPrivateYn() {
		return privateYn;
	}

	public void setPrivateYn(String privateYn) {
		this.privateYn = privateYn;
	}

	public String getDeletedYn() {
		return deletedYn;
	}

	public void setDeletedYn(String deletedYn) {
		this.deletedYn = deletedYn;
	}

	@Override
	public String toString() {
		return "ProductInquiryDto [productInquiryNo=" + productInquiryNo + ", productNo=" + productNo + ", memberNo="
				+ memberNo + ", memberName=" + memberName + ", sellerName=" + sellerName + ", status=" + status
				+ ", title=" + title + ", questionContent=" + questionContent + ", responseContent=" + responseContent
				+ ", questionDate=" + questionDate + ", responseDate=" + responseDate + ", privateYn=" + privateYn
				+ ", deletedYn=" + deletedYn + "]";
	}

}
