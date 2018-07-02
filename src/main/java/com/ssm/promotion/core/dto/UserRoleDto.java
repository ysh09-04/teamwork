package com.ssm.promotion.core.dto;

import java.util.ArrayList;
import java.util.List;

import com.ssm.promotion.core.entity.SRole;

/**
 * 用户角色
 * @author 尤少辉
 * @日期 2018年7月2日
 */
public class UserRoleDto {
	private Integer userId; // 主键
	private String userName; // 用户姓名
	private String password; // 密码
	private String uuid;// 唯一id
	private Integer state;// 状态 
	private List<SRole> sRoles=new ArrayList<SRole>();
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public List<SRole> getsRoles() {
		return sRoles;
	}
	public void setsRoles(List<SRole> sRoles) {
		this.sRoles = sRoles;
	}
	public UserRoleDto(Integer userId, String userName, String password, String uuid, Integer state,
			List<SRole> sRoles) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.uuid = uuid;
		this.state = state;
		this.sRoles = sRoles;
	}
	public UserRoleDto() {
		super();
	}
	
}
