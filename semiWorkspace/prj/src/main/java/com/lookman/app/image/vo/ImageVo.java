package com.lookman.app.image.vo;

public class ImageVo {
	private String imgNo;
	private String productNo;
	private String filename;
	private String thumbnailYn;
	private String deletedYn;
	private String createdDate;

	public ImageVo() {
	}

	public ImageVo(String imgNo, String productNo, String filename, String thumbnailYn, String deletedYn,
			String createdDate) {
		this.imgNo = imgNo;
		this.productNo = productNo;
		this.filename = filename;
		this.thumbnailYn = thumbnailYn;
		this.deletedYn = deletedYn;
		this.createdDate = createdDate;
	}

	public String getImgNo() {
		return imgNo;
	}

	public void setImgNo(String imgNo) {
		this.imgNo = imgNo;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getThumbnailYn() {
		return thumbnailYn;
	}

	public void setThumbnailYn(String thumbnailYn) {
		this.thumbnailYn = thumbnailYn;
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

	@Override
	public String toString() {
		return "ImageVo [imgNo=" + imgNo + ", productNo=" + productNo + ", filename=" + filename + ", thumbnailYn="
				+ thumbnailYn + ", deletedYn=" + deletedYn + ", createdDate=" + createdDate + "]";
	}

}
