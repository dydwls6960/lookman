package com.lookman.app.seller.vo;

public class SellerVo {
	private String sellerNo;
	private String accName;
	private String pwd;
	private String name;
	private String deletedYn;
	private String createdDate;
	private String bannerImg;
	private String info;
	private String shippingInfo;

	public SellerVo() {
	}

	public SellerVo(String sellerNo, String accName, String pwd, String name, String deletedYn, String createdDate,
			String bannerImg, String info, String shippingInfo) {
		this.sellerNo = sellerNo;
		this.accName = accName;
		this.pwd = pwd;
		this.name = name;
		this.deletedYn = deletedYn;
		this.createdDate = createdDate;
		this.bannerImg = bannerImg;
		this.info = info;
		this.shippingInfo = shippingInfo;
	}

	public String getSellerNo() {
		return sellerNo;
	}

	public void setSellerNo(String sellerNo) {
		this.sellerNo = sellerNo;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeletedYn() {
		return deletedYn;
	}

	public void setDeletedYn(String deletedYn) {
		this.deletedYn = deletedYn;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getBannerImg() {
		return bannerImg;
	}

	public void setBannerImg(String bannerImg) {
		this.bannerImg = bannerImg;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getShippingInfo() {
		return shippingInfo;
	}

	public void setShippingInfo(String shippingInfo) {
		this.shippingInfo = shippingInfo;
	}

	@Override
	public String toString() {
		return "SellerVo [sellerNo=" + sellerNo + ", accName=" + accName + ", pwd=" + pwd + ", name=" + name
				+ ", deletedYn=" + deletedYn + ", createdDate=" + createdDate + ", bannerImg=" + bannerImg + ", info="
				+ info + ", shippingInfo=" + shippingInfo + "]";
	}

}
