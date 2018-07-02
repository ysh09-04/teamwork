package com.ssm.promotion.core.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ssm.promotion.core.entity.UserRole;

/**
 * 用户角色
 * @author 尤少辉
 * @日期 2018年7月2日
 */
public interface User_RoleDao {
	/**
	 * 添加
	 * @param userRole
	 * @return
	 */
	public int save(UserRole userRole);
	/**
	 * 修改
	 * @param userRole
	 * @return
	 */
	public int update(UserRole userRole);
	/**
	 * 删除
	 * @param userRole
	 * @return
	 */
	public int delete(UserRole userRole);
	/**
	 * 根据roleName模糊查询/查询全部 (分页)
	 * @param roleName
	 * @return
	 */
	public List<UserRole> findByNameOrAllPage(Map<String, Object> map);
	/**
	 * 根据roleName模糊查询/查询全部 记录
	 * @param roleName
	 * @return
	 */
	public int findByNameOrAllCount(@Param("roleName")String roleName);
}
