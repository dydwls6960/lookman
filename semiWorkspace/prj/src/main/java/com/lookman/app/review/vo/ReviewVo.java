package com.lookman.app.review.vo;

public class ReviewVo {
	private String reviewNo;
	private String memberNo;
	private String productNo;
	private String rating;
	private String content;
	private String createdDate;

	public ReviewVo() {
		super();
	}

	public ReviewVo(String reviewNo, String memberNo, String productNo, String rating, String content,
			String createdDate) {
		super();
		this.reviewNo = reviewNo;
		this.memberNo = memberNo;
		this.productNo = productNo;
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

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
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
		return "ReviewVo [reviewNo=" + reviewNo + ", memberNo=" + memberNo + ", productNo=" + productNo + ", rating="
				+ rating + ", content=" + content + ", createdDate=" + createdDate + "]";
	}

}
