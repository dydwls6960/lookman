package com.lookman.app.review.vo;

public class ReviewVo {
	private String reviewNo;
	private String memberNo;
	private String productNo;
	private String ordersNo;
	private String rating;
	private String content;
	private String createdDate;
	private String editedDate;
	private String deletedYn;

	public ReviewVo() {
	}

	public ReviewVo(String reviewNo, String memberNo, String productNo, String ordersNo, String rating, String content,
			String createdDate, String editedDate, String deletedYn) {
		this.reviewNo = reviewNo;
		this.memberNo = memberNo;
		this.productNo = productNo;
		this.ordersNo = ordersNo;
		this.rating = rating;
		this.content = content;
		this.createdDate = createdDate;
		this.editedDate = editedDate;
		this.deletedYn = deletedYn;
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

	public String getOrdersNo() {
		return ordersNo;
	}

	public void setOrdersNo(String ordersNo) {
		this.ordersNo = ordersNo;
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

	public String getEditedDate() {
		return editedDate;
	}

	public void setEditedDate(String editedDate) {
		this.editedDate = editedDate;
	}

	public String getDeletedYn() {
		return deletedYn;
	}

	public void setDeletedYn(String deletedYn) {
		this.deletedYn = deletedYn;
	}

	@Override
	public String toString() {
		return "ReviewVo [reviewNo=" + reviewNo + ", memberNo=" + memberNo + ", productNo=" + productNo + ", ordersNo="
				+ ordersNo + ", rating=" + rating + ", content=" + content + ", createdDate=" + createdDate
				+ ", editedDate=" + editedDate + ", deletedYn=" + deletedYn + "]";
	}

}
