package com.ssm.promotion.core.entity;

/**
 * 用户地址的信息
 * @author 尤少辉
 * @日期 2018年7月4日
 */
public class UserAddress {
	private int userAddressId;
	private String postalCode;//邮政编码
	private String addresseeName;//收件人的名字
	private String creationTime;//创建时间
	private String isDefault;//是否为默认
	private int tUserId;
	public int getUserAddressId() {
		return userAddressId;
	}
	public void setUserAddressId(int userAddressId) {
		this.userAddressId = userAddressId;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getAddresseeName() {
		return addresseeName;
	}
	public void setAddresseeName(String addresseeName) {
		this.addresseeName = addresseeName;
	}
	public String getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}
	public String getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}
	public int gettUserId() {
		return tUserId;
	}
	public void settUserId(int tUserId) {
		this.tUserId = tUserId;
	}
	public UserAddress(int userAddressId, String postalCode, String addresseeName, String creationTime,
			String isDefault, int tUserId) {
		super();
		this.userAddressId = userAddressId;
		this.postalCode = postalCode;
		this.addresseeName = addresseeName;
		this.creationTime = creationTime;
		this.isDefault = isDefault;
		this.tUserId = tUserId;
	}
	public UserAddress() {
		super();
	}
	
}
