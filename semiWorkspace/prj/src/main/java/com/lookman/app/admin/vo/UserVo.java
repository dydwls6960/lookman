package com.lookman.app.admin.vo;

public class UserVo {
	private String member;
	private String membershipMember;
	private String seller;
	private String totalUser;
	public UserVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserVo(String member, String membershipMember, String seller, String totalUser) {
		super();
		this.member = member;
		this.membershipMember = membershipMember;
		this.seller = seller;
		this.totalUser = totalUser;
	}
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	public String getMembershipMember() {
		return membershipMember;
	}
	public void setMembershipMember(String membershipMember) {
		this.membershipMember = membershipMember;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public String getTotalUser() {
		return totalUser;
	}
	public void setTotalUser(String totalUser) {
		this.totalUser = totalUser;
	}
	@Override
	public String toString() {
		return "UserVo [member=" + member + ", membershipMember=" + membershipMember + ", seller=" + seller
				+ ", totalUser=" + totalUser + "]";
	}
	
	
}
