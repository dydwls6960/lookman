package com.lookman.app.review.dto;

public class ReviewDto {
	private String reviewNo;
	private String memberNo;
	private String memberName;
	private String productNo;
	private String productName;
	private String rating;
	private String content;
	private String createdDate;
	private String editedDate;
	private String deletedYn;
	private String productSize;
	private String productColor;
	private String colorHex;
	private String orderQuantity;
	private String thumbnailFilename;

	public ReviewDto() {
	}

	public ReviewDto(String reviewNo, String memberNo, String memberName, String productNo, String productName,
			String rating, String content, String createdDate, String editedDate, String deletedYn, String productSize,
			String productColor, String colorHex, String orderQuantity, String thumbnailFilename) {
		this.reviewNo = reviewNo;
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.productNo = productNo;
		this.productName = productName;
		this.rating = rating;
		this.content = content;
		this.createdDate = createdDate;
		this.editedDate = editedDate;
		this.deletedYn = deletedYn;
		this.productSize = productSize;
		this.productColor = productColor;
		this.colorHex = colorHex;
		this.orderQuantity = orderQuantity;
		this.thumbnailFilename = thumbnailFilename;
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

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
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

	public String getProductSize() {
		return productSize;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

	public String getProductColor() {
		return productColor;
	}

	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}

	public String getColorHex() {
		return colorHex;
	}

	public void setColorHex(String colorHex) {
		this.colorHex = colorHex;
	}

	public String getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(String orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public String getThumbnailFilename() {
		return thumbnailFilename;
	}

	public void setThumbnailFilename(String thumbnailFilename) {
		this.thumbnailFilename = thumbnailFilename;
	}

	@Override
	public String toString() {
		return "ReviewDto [reviewNo=" + reviewNo + ", memberNo=" + memberNo + ", memberName=" + memberName
				+ ", productNo=" + productNo + ", productName=" + productName + ", rating=" + rating + ", content="
				+ content + ", createdDate=" + createdDate + ", editedDate=" + editedDate + ", deletedYn=" + deletedYn
				+ ", productSize=" + productSize + ", productColor=" + productColor + ", colorHex=" + colorHex
				+ ", orderQuantity=" + orderQuantity + ", thumbnailFilename=" + thumbnailFilename + "]";
	}

}
