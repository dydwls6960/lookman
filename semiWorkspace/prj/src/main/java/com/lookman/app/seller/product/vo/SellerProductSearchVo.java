package com.lookman.app.seller.product.vo;

public class SellerProductSearchVo {
	private String search;
	private String searchText;
	private String categoryNo;
	private String sizeNo;
	private String colorNo;
	private String statusNo;
	public SellerProductSearchVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SellerProductSearchVo(String search, String searchText, String categoryNo, String sizeNo, String colorNo,
			String statusNo) {
		super();
		this.search = search;
		this.searchText = searchText;
		this.categoryNo = categoryNo;
		this.sizeNo = sizeNo;
		this.colorNo = colorNo;
		this.statusNo = statusNo;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	public String getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getSizeNo() {
		return sizeNo;
	}
	public void setSizeNo(String sizeNo) {
		this.sizeNo = sizeNo;
	}
	public String getColorNo() {
		return colorNo;
	}
	public void setColorNo(String colorNo) {
		this.colorNo = colorNo;
	}
	public String getStatusNo() {
		return statusNo;
	}
	public void setStatusNo(String statusNo) {
		this.statusNo = statusNo;
	}
	@Override
	public String toString() {
		return "SellerProductSearchVo [search=" + search + ", searchText=" + searchText + ", categoryNo=" + categoryNo
				+ ", sizeNo=" + sizeNo + ", colorNo=" + colorNo + ", statusNo=" + statusNo + "]";
	}
	
	
	
}
