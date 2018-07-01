package com.ssm.promotion.core.entity;

/**
 * 类目
 * @author 尤少辉
 * @日期 2018年7月1日
 */
public class Category {
	private int categoryId;
	private String categoryName;
	private String categoryDescribe;
	private int fatherId;
	private int categoryLevel;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDescribe() {
		return categoryDescribe;
	}
	public void setCategoryDescribe(String categoryDescribe) {
		this.categoryDescribe = categoryDescribe;
	}
	public int getFatherId() {
		return fatherId;
	}
	public void setFatherId(int fatherId) {
		this.fatherId = fatherId;
	}
	public int getCategoryLevel() {
		return categoryLevel;
	}
	public void setCategoryLevel(int categoryLevel) {
		this.categoryLevel = categoryLevel;
	}
	public Category(int categoryId, String categoryName, String categoryDescribe, int fatherId, int categoryLevel) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDescribe = categoryDescribe;
		this.fatherId = fatherId;
		this.categoryLevel = categoryLevel;
	}
	public Category() {
		super();
	}
	
}
