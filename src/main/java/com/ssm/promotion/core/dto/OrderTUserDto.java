package com.ssm.promotion.core.dto;

import com.ssm.promotion.core.entity.TUser;

public class OrderTUserDto {
	private int orderId;
	private String orderType;
	private String paymentType;
	private String paymentNumber;
	private double paymentMoney;
	private String state;
	private TUser tUser = new TUser();
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
	public TUser gettUser() {
		return tUser;
	}
	public void settUser(TUser tUser) {
		this.tUser = tUser;
	}
	public OrderTUserDto(int orderId, String orderType, String paymentType, String paymentNumber, double paymentMoney,
			String state, TUser tUser) {
		super();
		this.orderId = orderId;
		this.orderType = orderType;
		this.paymentType = paymentType;
		this.paymentNumber = paymentNumber;
		this.paymentMoney = paymentMoney;
		this.state = state;
		this.tUser = tUser;
	}
	public OrderTUserDto() {
		super();
	}
	
}
