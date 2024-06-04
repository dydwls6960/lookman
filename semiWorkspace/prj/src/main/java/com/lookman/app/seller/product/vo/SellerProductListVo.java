package com.lookman.app.seller.product.vo;

public class SellerProductListVo {
	private String productNo;
	private String categoryNo;
	private String categoryName;
	private String imgNo;
	private String imgName;
	private String productName;
	private String productPrice;
	private String sellerName;
	private String createDate;
	
	private String colorNo;
	private String colorName;
	private String sizeNo;
	private String sizeName;
	private String Quantity;
	public SellerProductListVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SellerProductListVo(String productNo, String categoryNo, String categoryName, String imgNo, String imgName,
			String productName, String productPrice, String sellerName, String createDate, String colorNo,
			String colorName, String sizeNo, String sizeName, String quantity) {
		super();
		this.productNo = productNo;
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
		this.imgNo = imgNo;
		this.imgName = imgName;
		this.productName = productName;
		this.productPrice = productPrice;
		this.sellerName = sellerName;
		this.createDate = createDate;
		this.colorNo = colorNo;
		this.colorName = colorName;
		this.sizeNo = sizeNo;
		this.sizeName = sizeName;
		Quantity = quantity;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getImgNo() {
		return imgNo;
	}
	public void setImgNo(String imgNo) {
		this.imgNo = imgNo;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getColorNo() {
		return colorNo;
	}
	public void setColorNo(String colorNo) {
		this.colorNo = colorNo;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public String getSizeNo() {
		return sizeNo;
	}
	public void setSizeNo(String sizeNo) {
		this.sizeNo = sizeNo;
	}
	public String getSizeName() {
		return sizeName;
	}
	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}
	public String getQuantity() {
		return Quantity;
	}
	public void setQuantity(String quantity) {
		Quantity = quantity;
	}
	@Override
	public String toString() {
		return "SellerProductListVo [productNo=" + productNo + ", categoryNo=" + categoryNo + ", categoryName="
				+ categoryName + ", imgNo=" + imgNo + ", imgName=" + imgName + ", productName=" + productName
				+ ", productPrice=" + productPrice + ", sellerName=" + sellerName + ", createDate=" + createDate
				+ ", colorNo=" + colorNo + ", colorName=" + colorName + ", sizeNo=" + sizeNo + ", sizeName=" + sizeName
				+ ", Quantity=" + Quantity + "]";
	}
	
	
	
	
}
