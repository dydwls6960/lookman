package com.lookman.app.product.dto;

import java.util.List;

import com.lookman.app.image.vo.ImageVo;
import com.lookman.app.review.vo.ReviewVo;

public class ProductDetailsDto {
	private String sellerName;
	private String productName;
	private String price;
	private String details;
	private String shippingDetails;
	private String avgRating;
	private String reviewCnt;
	private String hit;
	private String thumbnailFilename;
	List<ImageVo> images;
	List<ReviewVo> reviews;

	public ProductDetailsDto() {
	}

	public ProductDetailsDto(String sellerName, String productName, String price, String details,
			String shippingDetails, String avgRating, String reviewCnt, String hit, String thumbnailFilename,
			List<ImageVo> images, List<ReviewVo> reviews) {
		this.sellerName = sellerName;
		this.productName = productName;
		this.price = price;
		this.details = details;
		this.shippingDetails = shippingDetails;
		this.avgRating = avgRating;
		this.reviewCnt = reviewCnt;
		this.hit = hit;
		this.thumbnailFilename = thumbnailFilename;
		this.images = images;
		this.reviews = reviews;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getShippingDetails() {
		return shippingDetails;
	}

	public void setShippingDetails(String shippingDetails) {
		this.shippingDetails = shippingDetails;
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

	public String getHit() {
		return hit;
	}

	public void setHit(String hit) {
		this.hit = hit;
	}

	public String getThumbnailFilename() {
		return thumbnailFilename;
	}

	public void setThumbnailFilename(String thumbnailFilename) {
		this.thumbnailFilename = thumbnailFilename;
	}

	public List<ImageVo> getImages() {
		return images;
	}

	public void setImages(List<ImageVo> images) {
		this.images = images;
	}

	public List<ReviewVo> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewVo> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "ProductDetailsDto [sellerName=" + sellerName + ", productName=" + productName + ", price=" + price
				+ ", details=" + details + ", shippingDetails=" + shippingDetails + ", avgRating=" + avgRating
				+ ", reviewCnt=" + reviewCnt + ", hit=" + hit + ", thumbnailFilename=" + thumbnailFilename + ", images="
				+ images + ", reviews=" + reviews + "]";
	}

}
