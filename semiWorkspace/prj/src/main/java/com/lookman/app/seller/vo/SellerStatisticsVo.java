package com.lookman.app.seller.vo;

public class SellerStatisticsVo {
	
	private String avg;
	private String total;
	private String max;
	private String min;
	private String cnt;
	public SellerStatisticsVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SellerStatisticsVo(String avg, String total, String max, String min, String cnt) {
		super();
		this.avg = avg;
		this.total = total;
		this.max = max;
		this.min = min;
		this.cnt = cnt;
	}
	public String getAvg() {
		return avg;
	}
	public void setAvg(String avg) {
		this.avg = avg;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getMax() {
		return max;
	}
	public void setMax(String max) {
		this.max = max;
	}
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		this.min = min;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "SellerStatisticsVo [avg=" + avg + ", total=" + total + ", max=" + max + ", min=" + min + ", cnt=" + cnt
				+ "]";
	}
	
	
	
	
}
