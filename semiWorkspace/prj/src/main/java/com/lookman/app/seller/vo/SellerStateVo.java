package com.lookman.app.seller.vo;

public class SellerStateVo {
	private String productCnt;		//판매자상품수
	private String favoriteCnt;		//찜수
	private String orderCnt;		//주문수
	private String totalPrice;		//총판매금액
	private String charge;			//수수료
	private String netProfit;		//순이익
	public SellerStateVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SellerStateVo(String productCnt, String favoriteCnt, String orderCnt, String totalPrice,
			String charge, String netProfit) {
		super();
		this.productCnt = productCnt;
		this.favoriteCnt = favoriteCnt;
		this.orderCnt = orderCnt;
		this.totalPrice = totalPrice;
		this.charge = charge;
		this.netProfit = netProfit;
	}
	public String getProductCnt() {
		return productCnt;
	}
	public void setProductCnt(String productCnt) {
		this.productCnt = productCnt;
	}
	public String getFavoriteCnt() {
		return favoriteCnt;
	}
	public void setFavoriteCnt(String favoriteCnt) {
		this.favoriteCnt = favoriteCnt;
	}
	public String getOrderCnt() {
		return orderCnt;
	}
	public void setOrderCnt(String orderCnt) {
		this.orderCnt = orderCnt;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
	public String getNetProfit() {
		return netProfit;
	}
	public void setNetProfit(String netProfit) {
		this.netProfit = netProfit;
	}
	@Override
	public String toString() {
		return "SellerProductStateVo [productCnt=" + productCnt + ", favoriteCnt=" + favoriteCnt + ", orderCnt="
				+ orderCnt + ", totalPrice=" + totalPrice + ", charge=" + charge + ", netProfit=" + netProfit + "]";
	}
	
	

}
