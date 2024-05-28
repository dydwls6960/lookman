package com.lookman.app.order.dto;

import java.util.List;

import com.lookman.app.address.vo.AddressVo;

public class OrderFormDto {
	private String memberName;
	private String phoneNumber;
	private String totalPrice;
	List<AddressVo> addresses;
	List<OrderFormDetailsDto> details;

	public OrderFormDto() {
	}

	public OrderFormDto(String memberName, String phoneNumber, String totalPrice, List<AddressVo> addresses,
			List<OrderFormDetailsDto> details) {
		super();
		this.memberName = memberName;
		this.phoneNumber = phoneNumber;
		this.totalPrice = totalPrice;
		this.addresses = addresses;
		this.details = details;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<AddressVo> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressVo> addresses) {
		this.addresses = addresses;
	}

	public List<OrderFormDetailsDto> getDetails() {
		return details;
	}

	public void setDetails(List<OrderFormDetailsDto> details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "OrderFormDto [memberName=" + memberName + ", phoneNumber=" + phoneNumber + ", totalPrice=" + totalPrice
				+ ", addresses=" + addresses + ", details=" + details + "]";
	}

}
