package com.lookman.app.inquiry.vo;

public class ProductInquiryVo {
	private String productInquiryNo;
	private String memberNo;
	private String sellerNo;
	private String productNo;
	private String statusNo;
	private String title;
	private String questionContent;
	private String responseContent;
	private String askDate;
	private String responseDate;
	private String privateYn;

	public ProductInquiryVo() {
	}

	public ProductInquiryVo(String productInquiryNo, String memberNo, String sellerNo, String productNo,
			String statusNo, String title, String questionContent, String responseContent, String askDate,
			String responseDate, String privateYn) {
		this.productInquiryNo = productInquiryNo;
		this.memberNo = memberNo;
		this.sellerNo = sellerNo;
		this.productNo = productNo;
		this.statusNo = statusNo;
		this.title = title;
		this.questionContent = questionContent;
		this.responseContent = responseContent;
		this.askDate = askDate;
		this.responseDate = responseDate;
		this.privateYn = privateYn;
	}

	public String getProductInquiryNo() {
		return productInquiryNo;
	}

	public void setProductInquiryNo(String productInquiryNo) {
		this.productInquiryNo = productInquiryNo;
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

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
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

	public String getPrivateYn() {
		return privateYn;
	}

	public void setPrivateYn(String privateYn) {
		this.privateYn = privateYn;
	}

	@Override
	public String toString() {
		return "ProductInquiryVo [productInquiryNo=" + productInquiryNo + ", memberNo=" + memberNo + ", sellerNo="
				+ sellerNo + ", productNo=" + productNo + ", statusNo=" + statusNo + ", title=" + title
				+ ", questionContent=" + questionContent + ", responseContent=" + responseContent + ", askDate="
				+ askDate + ", responseDate=" + responseDate + ", privateYn=" + privateYn + "]";
	}

}
