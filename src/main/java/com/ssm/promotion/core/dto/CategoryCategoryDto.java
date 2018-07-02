package com.ssm.promotion.core.dto;

import com.ssm.promotion.core.entity.Category;
import com.ssm.promotion.core.entity.Course;

/**
 * 自己和父类的关联
 * @author 尤少辉
 * @日期 2018年7月1日
 */
public class CategoryCategoryDto {
	private int categoryId;
	private String categoryName;
	private String categoryDescribe;
	private int categoryLevel;
	private Category category=new Category();
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
	public int getCategoryLevel() {
		return categoryLevel;
	}
	public void setCategoryLevel(int categoryLevel) {
		this.categoryLevel = categoryLevel;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public CategoryCategoryDto(int categoryId, String categoryName, String categoryDescribe, int categoryLevel,
			Category category) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDescribe = categoryDescribe;
		this.categoryLevel = categoryLevel;
		this.category = category;
	}
	public CategoryCategoryDto() {
		super();
	}
	
}
