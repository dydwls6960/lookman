package com.lookman.app.admin.vo;

public class ReportListVo {
	private String reportNo;
	private String memberName;
	private String targetMemberNo;
	private String statusName;
	private String title;
	private String content;
	private String createdDate;
	public ReportListVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReportListVo(String reportNo, String memberName, String targetMemberNo, String statusName, String title,
			String content, String createdDate) {
		super();
		this.reportNo = reportNo;
		this.memberName = memberName;
		this.targetMemberNo = targetMemberNo;
		this.statusName = statusName;
		this.title = title;
		this.content = content;
		this.createdDate = createdDate;
	}
	public String getReportNo() {
		return reportNo;
	}
	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getTargetMemberNo() {
		return targetMemberNo;
	}
	public void setTargetMemberNo(String targetMemberNo) {
		this.targetMemberNo = targetMemberNo;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
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
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "ReportListVo [reportNo=" + reportNo + ", memberName=" + memberName + ", targetMemberNo="
				+ targetMemberNo + ", statusName=" + statusName + ", title=" + title + ", content=" + content
				+ ", createdDate=" + createdDate + "]";
	}
	
	
}
