package com.ssm.promotion.core.dto;

import java.util.ArrayList;
import java.util.List;

public class ProductContentDto {
	private int productContentID;//自己加的字段用于update
	private int productId;
	private int contentId;//存放考卷ID/题库ID/视频类目Id
	private String type;
	private String productName;
	private String contentName;//存放考卷名字/题库名字/视频类目名字
	
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

	public String getContentName() {
		return contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
	}

	public int getProductContentID() {
		return productContentID;
	}

	public void setProductContentID(int productContentID) {
		productContentID = productContentID;
	}

	public ProductContentDto() {
		super();
	}

	
	
}
