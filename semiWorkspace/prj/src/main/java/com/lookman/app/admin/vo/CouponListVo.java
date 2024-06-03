package com.lookman.app.admin.vo;

public class CouponListVo {
	private String couponNo;
	private String adminNo;
	private String name;
	private String code;
	private String discountPrice;
	private String createdDate;
	private String expiryDate;
	private String usageLimit;
	public CouponListVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CouponListVo(String couponNo, String adminNo, String name, String code, String discountPrice,
			String createdDate, String expiryDate, String usageLimit) {
		super();
		this.couponNo = couponNo;
		this.adminNo = adminNo;
		this.name = name;
		this.code = code;
		this.discountPrice = discountPrice;
		this.createdDate = createdDate;
		this.expiryDate = expiryDate;
		this.usageLimit = usageLimit;
	}
	public String getCouponNo() {
		return couponNo;
	}
	public void setCouponNo(String couponNo) {
		this.couponNo = couponNo;
	}
	public String getAdminNo() {
		return adminNo;
	}
	public void setAdminNo(String adminNo) {
		this.adminNo = adminNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(String discountPrice) {
		this.discountPrice = discountPrice;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getUsageLimit() {
		return usageLimit;
	}
	public void setUsageLimit(String usageLimit) {
		this.usageLimit = usageLimit;
	}
	@Override
	public String toString() {
		return "CouponListVo [couponNo=" + couponNo + ", adminNo=" + adminNo + ", name=" + name + ", code=" + code
				+ ", discountPrice=" + discountPrice + ", createdDate=" + createdDate + ", expiryDate=" + expiryDate
				+ ", usageLimit=" + usageLimit + "]";
	}
	
	
}
