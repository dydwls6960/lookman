package com.lookman.app.seller.product.vo;

public class SellerProductReviewListVo {
	private String reviewNo;
	private String productNo;
	private String memberNo;
	private String memberName;
	private String rating;
	private String content;
	private String createdDate;
	public SellerProductReviewListVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SellerProductReviewListVo(String reviewNo, String productNo, String memberNo, String memberName,
			String rating, String content, String createdDate) {
		super();
		this.reviewNo = reviewNo;
		this.productNo = productNo;
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.rating = rating;
		this.content = content;
		this.createdDate = createdDate;
	}
	public String getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(String reviewNo) {
		this.reviewNo = reviewNo;
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
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "SellerProductReviewListVo [reviewNo=" + reviewNo + ", productNo=" + productNo + ", memberNo=" + memberNo
				+ ", memberName=" + memberName + ", rating=" + rating + ", content=" + content + ", createdDate="
				+ createdDate + "]";
	}
	
	

}
