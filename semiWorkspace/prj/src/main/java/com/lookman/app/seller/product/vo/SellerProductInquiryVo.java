package com.lookman.app.seller.product.vo;

public class SellerProductInquiryVo {
	private String productInquiryNo;
	private String productNo;
	private String sellerNo;
	private String statusNo;
	private String statusName;
	private String memberName;
	private String memberNo;
	private String productInquiryTitle;
	private String askDate;
	private String qContent;
	private String respContent;
	private String respDate;
	public SellerProductInquiryVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SellerProductInquiryVo(String productInquiryNo, String productNo, String sellerNo, String statusNo,
			String statusName, String memberName, String memberNo, String productInquiryTitle, String askDate,
			String qContent, String respContent, String respDate) {
		super();
		this.productInquiryNo = productInquiryNo;
		this.productNo = productNo;
		this.sellerNo = sellerNo;
		this.statusNo = statusNo;
		this.statusName = statusName;
		this.memberName = memberName;
		this.memberNo = memberNo;
		this.productInquiryTitle = productInquiryTitle;
		this.askDate = askDate;
		this.qContent = qContent;
		this.respContent = respContent;
		this.respDate = respDate;
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
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getProductInquiryTitle() {
		return productInquiryTitle;
	}
	public void setProductInquiryTitle(String productInquiryTitle) {
		this.productInquiryTitle = productInquiryTitle;
	}
	public String getAskDate() {
		return askDate;
	}
	public void setAskDate(String askDate) {
		this.askDate = askDate;
	}
	public String getqContent() {
		return qContent;
	}
	public void setqContent(String qContent) {
		this.qContent = qContent;
	}
	public String getRespContent() {
		return respContent;
	}
	public void setRespContent(String respContent) {
		this.respContent = respContent;
	}
	public String getRespDate() {
		return respDate;
	}
	public void setRespDate(String respDate) {
		this.respDate = respDate;
	}
	@Override
	public String toString() {
		return "SellerProductInquiryVo [productInquiryNo=" + productInquiryNo + ", productNo=" + productNo
				+ ", sellerNo=" + sellerNo + ", statusNo=" + statusNo + ", statusName=" + statusName + ", memberName="
				+ memberName + ", memberNo=" + memberNo + ", productInquiryTitle=" + productInquiryTitle + ", askDate="
				+ askDate + ", qContent=" + qContent + ", respContent=" + respContent + ", respDate=" + respDate + "]";
	}
	
	
	
	
	
	
	
}
