package com.ssm.promotion.core.entity;

/**
 * 商品内容表
 * @author 尤少辉
 * @日期 2018年7月1日
 */
public class Shop_Content {
	private int productId;
	private String type;
	private int contentId;
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public Shop_Content(int productId, String type, int contentId) {
		super();
		this.productId = productId;
		this.type = type;
		this.contentId = contentId;
	}

	public Shop_Content() {
		super();
	}
	
}
