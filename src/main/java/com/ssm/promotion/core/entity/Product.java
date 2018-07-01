package com.ssm.promotion.core.entity;

/**
 * 产品
 * @author 尤少辉
 * @日期 2018年7月1日
 */
public class Product {
	private int productId;
	private String productName;
	private String productDescription;
	private String productEffectiveDate;
	private String enabled;
	private double productPrice;
	private int browseNumber;
	private int purchaseTimes;
	private String category;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductEffectiveDate() {
		return productEffectiveDate;
	}
	public void setProductEffectiveDate(String productEffectiveDate) {
		this.productEffectiveDate = productEffectiveDate;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getBrowseNumber() {
		return browseNumber;
	}
	public void setBrowseNumber(int browseNumber) {
		this.browseNumber = browseNumber;
	}
	public int getPurchaseTimes() {
		return purchaseTimes;
	}
	public void setPurchaseTimes(int purchaseTimes) {
		this.purchaseTimes = purchaseTimes;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Product(int productId, String productName, String productDescription, String productEffectiveDate,
			String enabled, double productPrice, int browseNumber, int purchaseTimes, String category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productEffectiveDate = productEffectiveDate;
		this.enabled = enabled;
		this.productPrice = productPrice;
		this.browseNumber = browseNumber;
		this.purchaseTimes = purchaseTimes;
		this.category = category;
	}
	public Product() {
		super();
	}
	
}
