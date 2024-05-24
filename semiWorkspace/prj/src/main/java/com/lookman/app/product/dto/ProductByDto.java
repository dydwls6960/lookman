package com.lookman.app.product.dto;

public class ProductByDto {
	private String productNo;
	private String price;
	private String sellerName;
	private String productName;
	private String thumbnailFilename;
	private String avgRating;
	private String reviewCnt;
	private String categoryName;

	public ProductByDto() {
	}

	public ProductByDto(String productNo, String price, String sellerName, String productName,
			String thumbnailFilename, String avgRating, String reviewCnt, String categoryName) {
		this.productNo = productNo;
		this.price = price;
		this.sellerName = sellerName;
		this.productName = productName;
		this.thumbnailFilename = thumbnailFilename;
		this.avgRating = avgRating;
		this.reviewCnt = reviewCnt;
		this.categoryName = categoryName;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getThumbnailFilename() {
		return thumbnailFilename;
	}

	public void setThumbnailFilename(String thumbnailFilename) {
		this.thumbnailFilename = thumbnailFilename;
	}

	public String getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(String avgRating) {
		this.avgRating = avgRating;
	}

	public String getReviewCnt() {
		return reviewCnt;
	}

	public void setReviewCnt(String reviewCnt) {
		this.reviewCnt = reviewCnt;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "ProductByCategoryDto [productNo=" + productNo + ", price=" + price + ", sellerName=" + sellerName
				+ ", productName=" + productName + ", thumbnailFilename=" + thumbnailFilename + ", avgRating="
				+ avgRating + ", reviewCnt=" + reviewCnt + ", categoryName=" + categoryName + "]";
	}

}
