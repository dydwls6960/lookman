package com.lookman.app.product.vo;

public class ProductColorVo {
	private String colorNo;
	private String name;
	private String hexcode;
	public ProductColorVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductColorVo(String colorNo, String name, String hexcode) {
		super();
		this.colorNo = colorNo;
		this.name = name;
		this.hexcode = hexcode;
	}
	public String getColorNo() {
		return colorNo;
	}
	public void setColorNo(String colorNo) {
		this.colorNo = colorNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHexcode() {
		return hexcode;
	}
	public void setHexcode(String hexcode) {
		this.hexcode = hexcode;
	}
	@Override
	public String toString() {
		return "ProductColorVo [colorNo=" + colorNo + ", name=" + name + ", hexcode=" + hexcode + "]";
	}
	
	

}
