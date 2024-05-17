package com.lookman.app.product.vo;

public class ProductVo {
	private String productNo;
	private String sellerNo;
	private String categoryNo;
	private String name;
	private String details;
	private String price;
	private String createdDate;
	private String editedDate;
	private String hit;
	private String deletedYn;

	public ProductVo() {
		super();
	}

	public ProductVo(String productNo, String sellerNo, String categoryNo, String name, String details, String price,
			String createdDate, String editedDate, String hit, String deletedYn) {
		super();
		this.productNo = productNo;
		this.sellerNo = sellerNo;
		this.categoryNo = categoryNo;
		this.name = name;
		this.details = details;
		this.price = price;
		this.createdDate = createdDate;
		this.editedDate = editedDate;
		this.hit = hit;
		this.deletedYn = deletedYn;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getSellerNo() {
		return sellerNo;
	}

	public void setSellerNo(String sellerNo) {
		this.sellerNo = sellerNo;
	}

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getEditedDate() {
		return editedDate;
	}

	public void setEditedDate(String editedDate) {
		this.editedDate = editedDate;
	}

	public String getHit() {
		return hit;
	}

	public void setHit(String hit) {
		this.hit = hit;
	}

	public String getDeletedYn() {
		return deletedYn;
	}

	public void setDeletedYn(String deletedYn) {
		this.deletedYn = deletedYn;
	}

	@Override
	public String toString() {
		return "ProductVo [productNo=" + productNo + ", sellerNo=" + sellerNo + ", categoryNo=" + categoryNo + ", name="
				+ name + ", details=" + details + ", price=" + price + ", createdDate=" + createdDate + ", editedDate="
				+ editedDate + ", hit=" + hit + ", deletedYn=" + deletedYn + "]";
	}

}
