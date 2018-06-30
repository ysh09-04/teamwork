package com.ssm.promotion.core.entity;

/**
 * 角色父菜单关联
 * @author 尤少辉
 * @日期 2018年6月30日
 */
public class Role_Fathermenu {
	private int roleId;
	private int fatherMenuId;
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getFatherMenuId() {
		return fatherMenuId;
	}
	public void setFatherMenuId(int fatherMenuId) {
		this.fatherMenuId = fatherMenuId;
	}
	public Role_Fathermenu(int roleId, int fatherMenuId) {
		super();
		this.roleId = roleId;
		this.fatherMenuId = fatherMenuId;
	}
	public Role_Fathermenu() {
		super();
	}
	
}
