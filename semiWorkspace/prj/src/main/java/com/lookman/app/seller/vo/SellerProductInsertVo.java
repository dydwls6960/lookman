package com.lookman.app.seller.vo;

public class SellerProductInsertVo {
	 private String category;
	 private String size;
	 private String color;
	 private String title;
	 private String content;
	 private String price;
	 private String thumbnailFileName;
	 private String cnt;
	public SellerProductInsertVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SellerProductInsertVo(String category, String size, String color, String title, String content, String price,
			String thumbnailFileName, String cnt) {
		super();
		this.category = category;
		this.size = size;
		this.color = color;
		this.title = title;
		this.content = content;
		this.price = price;
		this.thumbnailFileName = thumbnailFileName;
		this.cnt = cnt;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getThumbnailFileName() {
		return thumbnailFileName;
	}
	public void setThumbnailFileName(String thumbnailFileName) {
		this.thumbnailFileName = thumbnailFileName;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "SellerProductInsertVo [category=" + category + ", size=" + size + ", color=" + color + ", title="
				+ title + ", content=" + content + ", price=" + price + ", thumbnailFileName=" + thumbnailFileName
				+ ", cnt=" + cnt + "]";
	}
	
	 
	 

}
