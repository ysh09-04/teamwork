package com.ssm.promotion.core.dto;

import com.ssm.promotion.core.entity.VideoCategory;
/**
 * @author 刘家霖
 * @project_ 商品内容 产品  视频类目
 * @date 2018-7-1
 */
public class ProductVideoCategoryDto {
	private int productId;
	private int contentId;
	private String type;
	private String productName;
	private String productDescription;
	private String productEffectiveDate;
	private String enabled;
	private double productPrice;
	private int browseNumber;
	private int purchaseTimes;
	private String category;
	private VideoCategory videoCategory=new VideoCategory();
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public VideoCategory getVideoCategory() {
		return videoCategory;
	}
	public void setVideoCategory(VideoCategory videoCategory) {
		this.videoCategory = videoCategory;
	}
	public ProductVideoCategoryDto(int productId, int contentId, String type, String productName, String productDescription,
			String productEffectiveDate, String enabled, double productPrice, int browseNumber, int purchaseTimes,
			String category, VideoCategory videoCategory) {
		super();
		this.productId = productId;
		this.contentId = contentId;
		this.type = type;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productEffectiveDate = productEffectiveDate;
		this.enabled = enabled;
		this.productPrice = productPrice;
		this.browseNumber = browseNumber;
		this.purchaseTimes = purchaseTimes;
		this.category = category;
		this.videoCategory = videoCategory;
	}
	public ProductVideoCategoryDto() {
		super();
	}
	
}
