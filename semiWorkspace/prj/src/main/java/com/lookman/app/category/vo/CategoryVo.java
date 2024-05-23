package com.lookman.app.category.vo;

public class CategoryVo {
	private String categoryNo;
	private String name;

	public CategoryVo() {
	}

	public CategoryVo(String categoryNo, String name) {
		this.categoryNo = categoryNo;
		this.name = name;
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

	@Override
	public String toString() {
		return "CategoryVo [categoryNo=" + categoryNo + ", name=" + name + "]";
	}

}
