package com.ssm.promotion.core.service;

import com.ssm.promotion.core.entity.SUser;

/**
 * @author 1034683568@qq.com
 * @project_name perfect-ssm
 * @date 2017-3-1
 */
public interface UserService {

    /**
     * @param user
     * @return
     */
    public SUser login(SUser user);

    /**
     * @param user
     * @return
     */
    public int addUser(SUser user);

    /**
     * 根据用户名获取用户（仅在登录时用到）
     * @param userName
     * @return
     */
    public SUser getUserByName(String userName);
}
    
