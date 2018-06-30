package com.ssm.promotion.core.entity;

/**
 * 角色
 * @author 尤少辉
 * @日期 2018年6月30日
 */
public class SRole {
	private int roleId;
	private String roleName;
	private String roleDescribe;
	private String enabled;
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDescribe() {
		return roleDescribe;
	}
	public void setRoleDescribe(String roleDescribe) {
		this.roleDescribe = roleDescribe;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public SRole(int roleId, String roleName, String roleDescribe, String enabled) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDescribe = roleDescribe;
		this.enabled = enabled;
	}
	public SRole() {
		super();
	}
	
}
