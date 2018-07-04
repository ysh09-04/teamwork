package com.ssm.promotion.core.entity;

/**
 * 订单详情
 * @author 尤少辉
 * @日期 2018年7月4日
 */
public class OrderDetail {
	private int orderDetailId;
	private int orderId;
	private int productId;
	public int getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public OrderDetail(int orderDetailId, int orderId, int productId) {
		super();
		this.orderDetailId = orderDetailId;
		this.orderId = orderId;
		this.productId = productId;
	}
	public OrderDetail() {
		super();
	}
	
}
