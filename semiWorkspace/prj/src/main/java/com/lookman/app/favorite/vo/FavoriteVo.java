package com.lookman.app.favorite.vo;

public class FavoriteVo {
	private String favoriteNo;
	private String memberNo;
	private String productNo;
	private String createdDate;

	public FavoriteVo() {
	}

	public FavoriteVo(String favoriteNo, String memberNo, String productNo, String createdDate) {
		this.favoriteNo = favoriteNo;
		this.memberNo = memberNo;
		this.productNo = productNo;
		this.createdDate = createdDate;
	}

	public String getFavoriteNo() {
		return favoriteNo;
	}

	public void setFavoriteNo(String favoriteNo) {
		this.favoriteNo = favoriteNo;
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

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "FavoriteVo [favoriteNo=" + favoriteNo + ", memberNo=" + memberNo + ", productNo=" + productNo
				+ ", createdDate=" + createdDate + "]";
	}

}
