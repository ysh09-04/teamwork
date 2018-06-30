package com.ssm.promotion.core.entity;

/**
 * 角色和子菜单关联
 * @author 尤少辉
 * @日期 2018年6月30日
 */
public class Role_SonMenu {
	private int roleId;
	private int sonMenuId;
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getSonMenuId() {
		return sonMenuId;
	}
	public void setSonMenuId(int sonMenuId) {
		this.sonMenuId = sonMenuId;
	}
	public Role_SonMenu(int roleId, int sonMenuId) {
		super();
		this.roleId = roleId;
		this.sonMenuId = sonMenuId;
	}
	public Role_SonMenu() {
		super();
	}
	
}
