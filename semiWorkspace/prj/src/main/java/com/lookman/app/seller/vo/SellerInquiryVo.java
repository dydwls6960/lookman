package com.lookman.app.seller.vo;

public class SellerInquiryVo {
	private String inquiryCnt;
	private String beforeInquiryCnt;
	private String afterInquiryCnt;
	private String deleteInquiryCnt;
	public SellerInquiryVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SellerInquiryVo(String inquiryCnt, String beforeInquiryCnt, String afterInquiryCnt,
			String deleteInquiryCnt) {
		super();
		this.inquiryCnt = inquiryCnt;
		this.beforeInquiryCnt = beforeInquiryCnt;
		this.afterInquiryCnt = afterInquiryCnt;
		this.deleteInquiryCnt = deleteInquiryCnt;
	}
	public String getInquiryCnt() {
		return inquiryCnt;
	}
	public void setInquiryCnt(String inquiryCnt) {
		this.inquiryCnt = inquiryCnt;
	}
	public String getBeforeInquiryCnt() {
		return beforeInquiryCnt;
	}
	public void setBeforeInquiryCnt(String beforeInquiryCnt) {
		this.beforeInquiryCnt = beforeInquiryCnt;
	}
	public String getAfterInquiryCnt() {
		return afterInquiryCnt;
	}
	public void setAfterInquiryCnt(String afterInquiryCnt) {
		this.afterInquiryCnt = afterInquiryCnt;
	}
	public String getDeleteInquiryCnt() {
		return deleteInquiryCnt;
	}
	public void setDeleteInquiryCnt(String deleteInquiryCnt) {
		this.deleteInquiryCnt = deleteInquiryCnt;
	}
	@Override
	public String toString() {
		return "SellerInquiryVo [inquiryCnt=" + inquiryCnt + ", beforeInquiryCnt=" + beforeInquiryCnt
				+ ", afterInquiryCnt=" + afterInquiryCnt + ", deleteInquiryCnt=" + deleteInquiryCnt + "]";
	}
	
	
}
