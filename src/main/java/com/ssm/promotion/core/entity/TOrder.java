package com.ssm.promotion.core.entity;

/**
 * 订单
 * @author 尤少辉
 * @日期 2018年7月4日
 */
public class TOrder {
	private int orderId;
	private String orderType;
	private String paymentType;
	private String paymentNumber;
	private double paymentMoney;
	private String state;
	private int tUserId;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getPaymentNumber() {
		return paymentNumber;
	}
	public void setPaymentNumber(String paymentNumber) {
		this.paymentNumber = paymentNumber;
	}
	public double getPaymentMoney() {
		return paymentMoney;
	}
	public void setPaymentMoney(double paymentMoney) {
		this.paymentMoney = paymentMoney;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int gettUserId() {
		return tUserId;
	}
	public void settUserId(int tUserId) {
		this.tUserId = tUserId;
	}
	public TOrder(int orderId, String orderType, String paymentType, String paymentNumber, double paymentMoney,
			String state, int tUserId) {
		super();
		this.orderId = orderId;
		this.orderType = orderType;
		this.paymentType = paymentType;
		this.paymentNumber = paymentNumber;
		this.paymentMoney = paymentMoney;
		this.state = state;
		this.tUserId = tUserId;
	}
	public TOrder() {
		super();
	}
	
}
