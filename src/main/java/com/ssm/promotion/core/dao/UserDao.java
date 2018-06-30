package com.ssm.promotion.core.dao;

import java.util.List;
import java.util.Map;

import com.ssm.promotion.core.entity.SUser;
import org.springframework.stereotype.Repository;

/**
 * @author 1034683568@qq.com
 * @project_name perfect-ssm
 * @date 2017-3-1
 */
@Repository
public interface UserDao {

    /**
     * 登录
     *
     * @param user
     * @return
     */
    public SUser login(SUser user);

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    public int addUser(SUser user);
   
    /**
     * 根据用户名获取用户
     * @param user
     * @return
     */
    public SUser getUserByName(String userName);
    /**
     * 根据用户名获取角色Id
     * @param user
     * @return
     */
    public int getRoleIdByName(String userName);
}
