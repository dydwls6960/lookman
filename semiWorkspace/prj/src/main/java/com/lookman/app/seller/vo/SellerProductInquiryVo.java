package com.lookman.app.seller.vo;

public class SellerProductInquiryVo {
	private String product_inquiry_no;
	private String product_no;
	private String product_name;
	private String seller_name;
	private String status_name;
	private String member_name;
	private String member_id;
	private String title;
	private String question_content;
	private String response_content;
	private String ask_date;
	private String response_date;
	private String private_yn;
	private String deleted_yn;
	public SellerProductInquiryVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SellerProductInquiryVo(String product_inquiry_no, String product_no, String product_name, String seller_name,
			String status_name, String member_name, String member_id, String title, String question_content,
			String response_content, String ask_date, String response_date, String private_yn, String deleted_yn) {
		super();
		this.product_inquiry_no = product_inquiry_no;
		this.product_no = product_no;
		this.product_name = product_name;
		this.seller_name = seller_name;
		this.status_name = status_name;
		this.member_name = member_name;
		this.member_id = member_id;
		this.title = title;
		this.question_content = question_content;
		this.response_content = response_content;
		this.ask_date = ask_date;
		this.response_date = response_date;
		this.private_yn = private_yn;
		this.deleted_yn = deleted_yn;
	}
	public String getProduct_inquiry_no() {
		return product_inquiry_no;
	}
	public void setProduct_inquiry_no(String product_inquiry_no) {
		this.product_inquiry_no = product_inquiry_no;
	}
	public String getProduct_no() {
		return product_no;
	}
	public void setProduct_no(String product_no) {
		this.product_no = product_no;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getSeller_name() {
		return seller_name;
	}
	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}
	public String getStatus_name() {
		return status_name;
	}
	public void setStatus_name(String status_name) {
		this.status_name = status_name;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getQuestion_content() {
		return question_content;
	}
	public void setQuestion_content(String question_content) {
		this.question_content = question_content;
	}
	public String getResponse_content() {
		return response_content;
	}
	public void setResponse_content(String response_content) {
		this.response_content = response_content;
	}
	public String getAsk_date() {
		return ask_date;
	}
	public void setAsk_date(String ask_date) {
		this.ask_date = ask_date;
	}
	public String getResponse_date() {
		return response_date;
	}
	public void setResponse_date(String response_date) {
		this.response_date = response_date;
	}
	public String getPrivate_yn() {
		return private_yn;
	}
	public void setPrivate_yn(String private_yn) {
		this.private_yn = private_yn;
	}
	public String getDeleted_yn() {
		return deleted_yn;
	}
	public void setDeleted_yn(String deleted_yn) {
		this.deleted_yn = deleted_yn;
	}
	@Override
	public String toString() {
		return "SellerProductInquiryVo [product_inquiry_no=" + product_inquiry_no + ", product_no=" + product_no
				+ ", product_name=" + product_name + ", seller_name=" + seller_name + ", status_name=" + status_name
				+ ", member_name=" + member_name + ", member_id=" + member_id + ", title=" + title
				+ ", question_content=" + question_content + ", response_content=" + response_content + ", ask_date="
				+ ask_date + ", response_date=" + response_date + ", private_yn=" + private_yn + ", deleted_yn="
				+ deleted_yn + "]";
	}
	
	
	
}
