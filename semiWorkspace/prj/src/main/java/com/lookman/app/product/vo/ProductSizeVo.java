package com.lookman.app.product.vo;

public class ProductSizeVo {
	private String sizeNo;
	private String name;
	public ProductSizeVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductSizeVo(String sizeNo, String name) {
		super();
		this.sizeNo = sizeNo;
		this.name = name;
	}
	public String getSizeNo() {
		return sizeNo;
	}
	public void setSizeNo(String sizeNo) {
		this.sizeNo = sizeNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ProductSizeVo [sizeNo=" + sizeNo + ", name=" + name + "]";
	}
	
	
}
