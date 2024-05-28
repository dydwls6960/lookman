package com.lookman.app.favorite.dto;

public class FavoriteHomeDto {
	private String favoriteNo;
	private String sellerNo;
	private String sellerName;
	private String productNo;
	private String productName;
	private String price;
	private String favoriteCnt;
	private String thumbnailFilename;

	public FavoriteHomeDto() {
	}

	public FavoriteHomeDto(String favoriteNo, String sellerNo, String sellerName, String productNo, String productName,
			String price, String favoriteCnt, String thumbnailFilename) {
		this.favoriteNo = favoriteNo;
		this.sellerNo = sellerNo;
		this.sellerName = sellerName;
		this.productNo = productNo;
		this.productName = productName;
		this.price = price;
		this.favoriteCnt = favoriteCnt;
		this.thumbnailFilename = thumbnailFilename;
	}

	public String getFavoriteNo() {
		return favoriteNo;
	}

	public void setFavoriteNo(String favoriteNo) {
		this.favoriteNo = favoriteNo;
	}

	public String getSellerNo() {
		return sellerNo;
	}

	public void setSellerNo(String sellerNo) {
		this.sellerNo = sellerNo;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getFavoriteCnt() {
		return favoriteCnt;
	}

	public void setFavoriteCnt(String favoriteCnt) {
		this.favoriteCnt = favoriteCnt;
	}

	public String getThumbnailFilename() {
		return thumbnailFilename;
	}

	public void setThumbnailFilename(String thumbnailFilename) {
		this.thumbnailFilename = thumbnailFilename;
	}

	@Override
	public String toString() {
		return "FavoriteHomeDto [favoriteNo=" + favoriteNo + ", sellerNo=" + sellerNo + ", sellerName=" + sellerName
				+ ", productNo=" + productNo + ", productName=" + productName + ", price=" + price + ", favoriteCnt="
				+ favoriteCnt + ", thumbnailFilename=" + thumbnailFilename + "]";
	}

}
