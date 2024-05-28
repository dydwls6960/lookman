package com.lookman.app.address.dto;

public class AddressDto {
	private String addressNo;
	private String memberName;
	private String memberNo;
	private String phoneNo;
	private String postcode;
	private String address;
	private String detailedAddress;
	private String extraAddress;
	private String defaultReq;
	private String defaultYn;
	private String deletedYn;

	public AddressDto() {
	}

	public AddressDto(String addressNo, String memberName, String memberNo, String phoneNo, String postcode,
			String address, String detailedAddress, String extraAddress, String defaultReq, String defaultYn,
			String deletedYn) {
		this.addressNo = addressNo;
		this.memberName = memberName;
		this.memberNo = memberNo;
		this.phoneNo = phoneNo;
		this.postcode = postcode;
		this.address = address;
		this.detailedAddress = detailedAddress;
		this.extraAddress = extraAddress;
		this.defaultReq = defaultReq;
		this.defaultYn = defaultYn;
		this.deletedYn = deletedYn;
	}

	public String getAddressNo() {
		return addressNo;
	}

	public void setAddressNo(String addressNo) {
		this.addressNo = addressNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetailedAddress() {
		return detailedAddress;
	}

	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}

	public String getExtraAddress() {
		return extraAddress;
	}

	public void setExtraAddress(String extraAddress) {
		this.extraAddress = extraAddress;
	}

	public String getDefaultReq() {
		return defaultReq;
	}

	public void setDefaultReq(String defaultReq) {
		this.defaultReq = defaultReq;
	}

	public String getDefaultYn() {
		return defaultYn;
	}

	public void setDefaultYn(String defaultYn) {
		this.defaultYn = defaultYn;
	}

	public String getDeletedYn() {
		return deletedYn;
	}

	public void setDeletedYn(String deletedYn) {
		this.deletedYn = deletedYn;
	}

	@Override
	public String toString() {
		return "AddressDto [addressNo=" + addressNo + ", memberName=" + memberName + ", memberNo=" + memberNo
				+ ", phoneNo=" + phoneNo + ", postcode=" + postcode + ", address=" + address + ", detailedAddress="
				+ detailedAddress + ", extraAddress=" + extraAddress + ", defaultReq=" + defaultReq + ", defaultYn="
				+ defaultYn + ", deletedYn=" + deletedYn + "]";
	}

}
