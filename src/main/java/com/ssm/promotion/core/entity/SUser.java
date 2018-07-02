package com.ssm.promotion.core.entity;

/**
 * @author 1034683568@qq.com
 * @project_name perfect-ssm
 * @date 2017-3-1
 */
public class SUser {

    private Integer userId; // 主键
    private String userName; // 用户姓名
    private String password; // 密码
    private String uuid;// 唯一id
    private Integer state;// 状态 
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
	public void setStatus(Integer state) {
		this.state = state;
	}
	public SUser(Integer userId, String userName, String password, String uuid, Integer state) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.uuid = uuid;
		this.state = state;
	}
	
	public SUser() {
		super();
	}
	@Override
	public String toString() {
		return "SUser [userId=" + userId + ", userName=" + userName + ", password=" + password + ", uuid=" + uuid
				+ ", state=" + state + "]";
	}
   

	
    
}
