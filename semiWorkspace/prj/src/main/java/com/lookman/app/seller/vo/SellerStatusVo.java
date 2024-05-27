package com.lookman.app.seller.vo;

public class SellerStatusVo {
	private String allProductCnt;
	private String allHitSum;
	private String allFavoriteCnt;
	private String allOrderCnt;
	private String allPriceSum;
	public SellerStatusVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SellerStatusVo(String allProductCnt, String allHitSum, String allFavoriteCnt, String allOrderCnt,
			String allPriceSum) {
		super();
		this.allProductCnt = allProductCnt;
		this.allHitSum = allHitSum;
		this.allFavoriteCnt = allFavoriteCnt;
		this.allOrderCnt = allOrderCnt;
		this.allPriceSum = allPriceSum;
	}
	public String getAllProductCnt() {
		return allProductCnt;
	}
	public void setAllProductCnt(String allProductCnt) {
		this.allProductCnt = allProductCnt;
	}
	public String getAllHitSum() {
		return allHitSum;
	}
	public void setAllHitSum(String allHitSum) {
		this.allHitSum = allHitSum;
	}
	public String getAllFavoriteCnt() {
		return allFavoriteCnt;
	}
	public void setAllFavoriteCnt(String allFavoriteCnt) {
		this.allFavoriteCnt = allFavoriteCnt;
	}
	public String getAllOrderCnt() {
		return allOrderCnt;
	}
	public void setAllOrderCnt(String allOrderCnt) {
		this.allOrderCnt = allOrderCnt;
	}
	public String getAllPriceSum() {
		return allPriceSum;
	}
	public void setAllPriceSum(String allPriceSum) {
		this.allPriceSum = allPriceSum;
	}
	@Override
	public String toString() {
		return "SellerStatusVo [allProductCnt=" + allProductCnt + ", allHitSum=" + allHitSum + ", allFavoriteCnt="
				+ allFavoriteCnt + ", allOrderCnt=" + allOrderCnt + ", allPriceSum=" + allPriceSum + "]";
	}
	
	
}