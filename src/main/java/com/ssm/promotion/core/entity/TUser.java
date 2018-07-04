package com.ssm.promotion.core.entity;

/**
 * 商城用户登录的
 * @author 尤少辉
 * @日期 2018年7月4日
 */
public class TUser {
	private int tUserId;
	private int uuid;
	private String userName;
	private String password;
	private String state;
	public int gettUserId() {
		return tUserId;
	}
	public void settUserId(int tUserId) {
		this.tUserId = tUserId;
	}
	public int getUuid() {
		return uuid;
	}
	public void setUuid(int uuid) {
		this.uuid = uuid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public TUser(int tUserId, int uuid, String userName, String password, String state) {
		super();
		this.tUserId = tUserId;
		this.uuid = uuid;
		this.userName = userName;
		this.password = password;
		this.state = state;
	}
	public TUser() {
		super();
	}
	
}
