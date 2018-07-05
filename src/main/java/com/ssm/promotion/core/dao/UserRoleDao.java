package com.ssm.promotion.core.dao;

import java.util.List;
import java.util.Map;




import com.ssm.promotion.core.dto.UserRoleDto;

import com.ssm.promotion.core.entity.UserRole;
/**
 * 
 * @author 煌平
 *
 */

public interface UserRoleDao {

	/**
     * 查找
     *
     * @param map
     * @return
     */
    public List<UserRoleDto> findAll(Map<String, Object> map);
    /**
     * @param map
     * @return
     */
    public Long getTotalUserRole(Map<String, Object> map);
    /**
     * 添加
     *
     * @param 
     * @return
     */
    public int add(UserRole userRole);
    /**
     * 修改
     *
     * @param role_Fathermenu
     * @return
     */
    public int update(Map<String, Integer> map);
    /**
     * 删除
     *
     * @param role_Fathermenu
     * @return
     */
    public int delete(UserRole userRole);

	
}
