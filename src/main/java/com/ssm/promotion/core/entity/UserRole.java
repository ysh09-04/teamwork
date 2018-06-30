package com.ssm.promotion.core.entity;

/**
 * 角色用户关联
 * @author 尤少辉
 * @日期 2018年6月30日
 */
public class UserRole {
	private int userId;
	private int roleId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public UserRole(int userId, int roleId) {
		super();
		this.userId = userId;
		this.roleId = roleId;
	}
	public UserRole() {
		super();
	}
	
}
