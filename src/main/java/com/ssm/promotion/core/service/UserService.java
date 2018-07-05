package com.ssm.promotion.core.service;

import java.util.List;
import java.util.Map;

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
    
    /**
     * 查找用户列表
     *
     * @param map
     * @return
     */
    public List<SUser> findSUser(Map<String, Object> map);

    /**
     * @param map
     * @return
     */
    public Long getTotalSUser(Map<String, Object> map);

    /**
     * 实体修改
     *
     * @param 
     * @return
     */
    public int updateSUser(SUser user);
    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    public int deleteSUser(Integer userId);
    /**
     * 根据id获取用户
     * @param uuid
     * @return
     */
    SUser getSUserById(Integer userId);
    /**
     * 查询全部Id
     */
    public List<SUser> findAll();

}
    
