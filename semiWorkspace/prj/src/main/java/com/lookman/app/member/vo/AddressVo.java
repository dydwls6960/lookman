package com.lookman.app.member.vo;

public class AddressVo {
	private String addressNo;
	private String memberNo;
	private String postcode;
	private String address;
	private String detailedAddress;
	private String extraAddress;
	private String defaultAddressYn;
	private String defaultShippingReq;

	public AddressVo() {
	}

	public AddressVo(String addressNo, String memberNo, String postcode, String address, String detailedAddress,
			String extraAddress, String defaultAddressYn, String defaultShippingReq) {
		this.addressNo = addressNo;
		this.memberNo = memberNo;
		this.postcode = postcode;
		this.address = address;
		this.detailedAddress = detailedAddress;
		this.extraAddress = extraAddress;
		this.defaultAddressYn = defaultAddressYn;
		this.defaultShippingReq = defaultShippingReq;
	}

	public String getAddressNo() {
		return addressNo;
	}

	public void setAddressNo(String addressNo) {
		this.addressNo = addressNo;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
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

	public String getDefaultAddressYn() {
		return defaultAddressYn;
	}

	public void setDefaultAddressYn(String defaultAddressYn) {
		this.defaultAddressYn = defaultAddressYn;
	}

	public String getDefaultShippingReq() {
		return defaultShippingReq;
	}

	public void setDefaultShippingReq(String defaultShippingReq) {
		this.defaultShippingReq = defaultShippingReq;
	}

	@Override
	public String toString() {
		return "AddressVo [addressNo=" + addressNo + ", memberNo=" + memberNo + ", postcode=" + postcode + ", address="
				+ address + ", detailedAddress=" + detailedAddress + ", extraAddress=" + extraAddress
				+ ", defaultAddressYn=" + defaultAddressYn + ", defaultShippingReq=" + defaultShippingReq + "]";
	}

}
