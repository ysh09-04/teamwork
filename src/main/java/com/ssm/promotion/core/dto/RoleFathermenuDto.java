package com.ssm.promotion.core.dto;

import java.util.ArrayList;
import java.util.List;

import com.ssm.promotion.core.entity.FatherMenu;
/**
 * 这是Role 和fatherMenus 的多对多关联实体类
 *
 */
public class RoleFathermenuDto {
	private int role_fatherMenuId;
	private int roleId;
	private int fatherMenuId;
	private String roleName;
	private String roleDescribe;
	private String enabled;
	private FatherMenu fatherMenus=new FatherMenu();
	
	public int getFatherMenuId() {
		return fatherMenuId;
	}
	public void setFatherMenuId(int fatherMenuId) {
		this.fatherMenuId = fatherMenuId;
	}
	public int getRole_fatherMenuId() {
		return role_fatherMenuId;
	}
	public void setRole_fatherMenuId(int role_fatherMenuId) {
		this.role_fatherMenuId = role_fatherMenuId;
	}
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
	public FatherMenu getFatherMenus() {
		return fatherMenus;
	}
	public void setFatherMenus(FatherMenu fatherMenus) {
		this.fatherMenus = fatherMenus;
	}
	public RoleFathermenuDto(int role_fatherMenuId, int roleId, int fatherMenuId, String roleName, String roleDescribe,
			String enabled, FatherMenu fatherMenus) {
		super();
		this.role_fatherMenuId = role_fatherMenuId;
		this.roleId = roleId;
		this.fatherMenuId = fatherMenuId;
		this.roleName = roleName;
		this.roleDescribe = roleDescribe;
		this.enabled = enabled;
		this.fatherMenus = fatherMenus;
	}
	public RoleFathermenuDto() {
		super();
	}
	
}
