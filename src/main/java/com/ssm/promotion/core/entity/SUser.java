package com.ssm.promotion.core.entity;

/**
 * @author 1034683568@qq.com
 * @project_name perfect-ssm
 * @date 2017-3-1
 */
public class SUser {

    private Integer id; // 主键
    private String userName; // 用户姓名
    private String password; // 密码
    private String uuid;// 唯一id
    private Integer status;// 状态 
   

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public SUser(Integer id, String userName, String password, String uuid, Integer status) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.uuid = uuid;
		this.status = status;
	}

	public SUser() {
		super();
	}
    
    
}
