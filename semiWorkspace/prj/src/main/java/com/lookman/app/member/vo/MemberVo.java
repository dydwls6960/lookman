package com.lookman.app.member.vo;

public class MemberVo {

	private String memberNo;
	private String id;
	private String pwd;
	private String pwd2;
	private String newPwd;
	private String newPwd2;
	private String name;
	private String phoneNo;
	private String premiumYn;
	private String deletedYn;
	private String createdDate;
	private String banDate;

	public MemberVo() {
	}

	public MemberVo(String memberNo, String id, String pwd, String pwd2, String newPwd, String newPwd2, String name,
			String phoneNo, String premiumYn, String deletedYn, String createdDate, String banDate) {
		this.memberNo = memberNo;
		this.id = id;
		this.pwd = pwd;
		this.pwd2 = pwd2;
		this.newPwd = newPwd;
		this.newPwd2 = newPwd2;
		this.name = name;
		this.phoneNo = phoneNo;
		this.premiumYn = premiumYn;
		this.deletedYn = deletedYn;
		this.createdDate = createdDate;
		this.banDate = banDate;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPwd2() {
		return pwd2;
	}

	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public String getNewPwd2() {
		return newPwd2;
	}

	public void setNewPwd2(String newPwd2) {
		this.newPwd2 = newPwd2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPremiumYn() {
		return premiumYn;
	}

	public void setPremiumYn(String premiumYn) {
		this.premiumYn = premiumYn;
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

	public String getBanDate() {
		return banDate;
	}

	public void setBanDate(String banDate) {
		this.banDate = banDate;
	}

	@Override
	public String toString() {
		return "MemberVo [memberNo=" + memberNo + ", id=" + id + ", pwd=" + pwd + ", pwd2=" + pwd2 + ", newPwd="
				+ newPwd + ", newPwd2=" + newPwd2 + ", name=" + name + ", phoneNo=" + phoneNo + ", premiumYn="
				+ premiumYn + ", deletedYn=" + deletedYn + ", createdDate=" + createdDate + ", banDate=" + banDate
				+ "]";
	}

}
