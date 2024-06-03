package com.lookman.app.admin.vo;

public class AdminVo {
	private String adminId;
	private String adminPwd;
	private String adminNick;
	private String adminNo;
	public AdminVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminVo(String adminId, String adminPwd, String adminNick, String adminNo) {
		super();
		this.adminId = adminId;
		this.adminPwd = adminPwd;
		this.adminNick = adminNick;
		this.adminNo = adminNo;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	public String getAdminNick() {
		return adminNick;
	}
	public void setAdminNick(String adminNick) {
		this.adminNick = adminNick;
	}
	public String getAdminNo() {
		return adminNo;
	}
	public void setAdminNo(String adminNo) {
		this.adminNo = adminNo;
	}
	@Override
	public String toString() {
		return "AdminVo [adminId=" + adminId + ", adminPwd=" + adminPwd + ", adminNick=" + adminNick + ", adminNo="
				+ adminNo + "]";
	}
	
	
	

}
