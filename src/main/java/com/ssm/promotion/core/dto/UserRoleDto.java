package com.ssm.promotion.core.dto;

import com.ssm.promotion.core.entity.SRole;
import com.ssm.promotion.core.entity.SUser;
/**
 * 
 * @author 
 *
 */
public class UserRoleDto {
	private Integer user_roleId;
	private Integer userId;
	private Integer roleId;
	private String userName; // 用户姓名
    private String password; // 密码
    private String uuid;// 唯一id
    private Integer state;// 状态
	private SRole SRole = new SRole();
	public Integer getUser_roleId() {
		return user_roleId;
	}
	public void setUser_roleId(Integer user_roleId) {
		this.user_roleId = user_roleId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
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
	public SRole getSRole() {
		return SRole;
	}
	public void setSRole(SRole SRole) {
		this.SRole = SRole;
	}
	public UserRoleDto(Integer user_roleId, Integer userId, Integer roleId, String userName, String password,
			String uuid, Integer state, SRole SRole) {
		super();
		this.user_roleId = user_roleId;
		this.userId = userId;
		this.roleId = roleId;
		this.userName = userName;
		this.password = password;
		this.uuid = uuid;
		this.state = state;
		this.SRole = SRole;
	}
	public UserRoleDto(Integer userId, Integer roleId, String userName, String password, String uuid, Integer state,
			SRole SRole) {
		super();
		this.userId = userId;
		this.roleId = roleId;
		this.userName = userName;
		this.password = password;
		this.uuid = uuid;
		this.state = state;
		this.SRole = SRole;
	}
	public UserRoleDto() {
		super();
	}
	
}
