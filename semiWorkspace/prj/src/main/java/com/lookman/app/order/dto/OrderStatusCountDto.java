package com.lookman.app.order.dto;

public class OrderStatusCountDto {
	private String statusNo;
	private String statusName;
	private String count;

	public OrderStatusCountDto() {
	}

	public OrderStatusCountDto(String statusNo, String statusName, String count) {
		this.statusNo = statusNo;
		this.statusName = statusName;
		this.count = count;
	}

	public String getStatusNo() {
		return statusNo;
	}

	public void setStatusNo(String statusNo) {
		this.statusNo = statusNo;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "OrderStatusCountDto [statusNo=" + statusNo + ", statusName=" + statusName + ", count=" + count + "]";
	}

}
