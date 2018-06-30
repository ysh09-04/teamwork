package com.ssm.promotion.core.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ssm.promotion.core.dto.FatherMenuSonMenuDto;
import com.ssm.promotion.core.entity.FatherMenu;

/**
 * 父菜单
 * @author 尤少辉
 * @日期 2018年6月30日
 */
public interface FatherMenuDao {
	/**
	 * 根据用户名查询该角色所能操作的功能
	 * @param username
	 * @return
	 */
	public List<FatherMenuSonMenuDto> findByUserName(String username);
	
	/**
	 * 根据  名字的模糊查询/查询全部的分页
	 * @param map
	 * @return
	 */
	public List<FatherMenu> findByFatherMenuOrAll(Map<String, Object> map);
	
	/**
	 * 根据  名字的模糊查询/查询全部的分页
	 * @param map
	 * @return
	 */
	public int findByFatherMenuOrAllCount(@Param("menuName")String menuName);
	
	/**
	 * 删除
	 * @param fatherMenuId
	 * @return
	 */
	public int delete(int fatherMenuId);
	
	/**
	 * 修改
	 * @param fatherMenu
	 * @return
	 */
	public int update(FatherMenu fatherMenu);
	
	/**
	 * 添加
	 * @param fatherMenu
	 * @return
	 */
	public int save(FatherMenu fatherMenu);
	/**
	 * 查询全部的id和菜单名
	 * @param fatherMenu
	 * @return
	 */
	public List<FatherMenu> findAllIdAndName();
}
