package com.ssm.promotion.core.dto;

import java.util.ArrayList;
import java.util.List;

import com.ssm.promotion.core.entity.FatherMenu;
/**
 * 这是Role 和fatherMenus 的多对多关联实体类
 *
 */
public class RoleFathermenuDto {
	private int roleId;
	private String roleName;
	private String roleDescribe;
	private String enabled;
	private List<FatherMenu> fatherMenus=new ArrayList<FatherMenu>();
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
	public List<FatherMenu> getFatherMenus() {
		return fatherMenus;
	}
	public void setFatherMenus(List<FatherMenu> fatherMenus) {
		this.fatherMenus = fatherMenus;
	}
	public RoleFathermenuDto(int roleId, String roleName, String roleDescribe, String enabled,
			List<FatherMenu> fatherMenus) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDescribe = roleDescribe;
		this.enabled = enabled;
		this.fatherMenus = fatherMenus;
	}
	public RoleFathermenuDto() {
		super();
	}
	
}
