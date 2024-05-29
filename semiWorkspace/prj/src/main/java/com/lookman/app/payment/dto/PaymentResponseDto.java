package com.lookman.app.payment.dto;

import com.google.gson.annotations.SerializedName;

public class PaymentResponseDto {
	@SerializedName("success")
	private boolean success;

	@SerializedName("imp_uid")
	private String impUid;

	@SerializedName("pay_method")
	private String payMethod;

	@SerializedName("merchant_uid")
	private String merchantUid;

	@SerializedName("name")
	private String name;

	@SerializedName("paid_amount")
	private int paidAmount;

	@SerializedName("currency")
	private String currency;

	@SerializedName("pg_provider")
	private String pgProvider;

	@SerializedName("pg_type")
	private String pgType;

	@SerializedName("pg_tid")
	private String pgTid;

	@SerializedName("apply_num")
	private String applyNum;

	@SerializedName("buyer_name")
	private String buyerName;

	@SerializedName("buyer_email")
	private String buyerEmail;

	@SerializedName("buyer_tel")
	private String buyerTel;

	@SerializedName("buyer_addr")
	private String buyerAddr;

	@SerializedName("buyer_postcode")
	private String buyerPostcode;

	@SerializedName("custom_data")
	private Object customData;

	@SerializedName("status")
	private String status;

	@SerializedName("paid_at")
	private long paidAt;

	@SerializedName("receipt_url")
	private String receiptUrl;

	@SerializedName("card_name")
	private String cardName;

	@SerializedName("bank_name")
	private String bankName;

	@SerializedName("card_quota")
	private int cardQuota;

	@SerializedName("card_number")
	private String cardNumber;

	public PaymentResponseDto() {
	}

	public PaymentResponseDto(boolean success, String impUid, String payMethod, String merchantUid, String name,
			int paidAmount, String currency, String pgProvider, String pgType, String pgTid, String applyNum,
			String buyerName, String buyerEmail, String buyerTel, String buyerAddr, String buyerPostcode,
			Object customData, String status, long paidAt, String receiptUrl, String cardName, String bankName,
			int cardQuota, String cardNumber) {
		this.success = success;
		this.impUid = impUid;
		this.payMethod = payMethod;
		this.merchantUid = merchantUid;
		this.name = name;
		this.paidAmount = paidAmount;
		this.currency = currency;
		this.pgProvider = pgProvider;
		this.pgType = pgType;
		this.pgTid = pgTid;
		this.applyNum = applyNum;
		this.buyerName = buyerName;
		this.buyerEmail = buyerEmail;
		this.buyerTel = buyerTel;
		this.buyerAddr = buyerAddr;
		this.buyerPostcode = buyerPostcode;
		this.customData = customData;
		this.status = status;
		this.paidAt = paidAt;
		this.receiptUrl = receiptUrl;
		this.cardName = cardName;
		this.bankName = bankName;
		this.cardQuota = cardQuota;
		this.cardNumber = cardNumber;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getImpUid() {
		return impUid;
	}

	public void setImpUid(String impUid) {
		this.impUid = impUid;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public String getMerchantUid() {
		return merchantUid;
	}

	public void setMerchantUid(String merchantUid) {
		this.merchantUid = merchantUid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(int paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getPgProvider() {
		return pgProvider;
	}

	public void setPgProvider(String pgProvider) {
		this.pgProvider = pgProvider;
	}

	public String getPgType() {
		return pgType;
	}

	public void setPgType(String pgType) {
		this.pgType = pgType;
	}

	public String getPgTid() {
		return pgTid;
	}

	public void setPgTid(String pgTid) {
		this.pgTid = pgTid;
	}

	public String getApplyNum() {
		return applyNum;
	}

	public void setApplyNum(String applyNum) {
		this.applyNum = applyNum;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	public String getBuyerTel() {
		return buyerTel;
	}

	public void setBuyerTel(String buyerTel) {
		this.buyerTel = buyerTel;
	}

	public String getBuyerAddr() {
		return buyerAddr;
	}

	public void setBuyerAddr(String buyerAddr) {
		this.buyerAddr = buyerAddr;
	}

	public String getBuyerPostcode() {
		return buyerPostcode;
	}

	public void setBuyerPostcode(String buyerPostcode) {
		this.buyerPostcode = buyerPostcode;
	}

	public Object getCustomData() {
		return customData;
	}

	public void setCustomData(Object customData) {
		this.customData = customData;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getPaidAt() {
		return paidAt;
	}

	public void setPaidAt(long paidAt) {
		this.paidAt = paidAt;
	}

	public String getReceiptUrl() {
		return receiptUrl;
	}

	public void setReceiptUrl(String receiptUrl) {
		this.receiptUrl = receiptUrl;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public int getCardQuota() {
		return cardQuota;
	}

	public void setCardQuota(int cardQuota) {
		this.cardQuota = cardQuota;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public String toString() {
		return "PaymentResponseDto [success=" + success + ", impUid=" + impUid + ", payMethod=" + payMethod
				+ ", merchantUid=" + merchantUid + ", name=" + name + ", paidAmount=" + paidAmount + ", currency="
				+ currency + ", pgProvider=" + pgProvider + ", pgType=" + pgType + ", pgTid=" + pgTid + ", applyNum="
				+ applyNum + ", buyerName=" + buyerName + ", buyerEmail=" + buyerEmail + ", buyerTel=" + buyerTel
				+ ", buyerAddr=" + buyerAddr + ", buyerPostcode=" + buyerPostcode + ", customData=" + customData
				+ ", status=" + status + ", paidAt=" + paidAt + ", receiptUrl=" + receiptUrl + ", cardName=" + cardName
				+ ", bankName=" + bankName + ", cardQuota=" + cardQuota + ", cardNumber=" + cardNumber + "]";
	}

}
