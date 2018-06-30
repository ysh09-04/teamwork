package com.ssm.promotion.core.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ssm.promotion.core.entity.SonMenu;

/**
 * 子菜单
 * @author 尤少辉
 * @日期 2018年6月30日
 */
public interface SonMenuService {
	/**
	 * 根据菜单名分页查询信息
	 * @param map
	 * @return
	 */
	public List<SonMenu> findByMenuNameOrAll(Map<String, Object> map);
	/**
	 * 统计所有的数目
	 * @param menuName
	 * @return
	 */
	public int findAllCount(@Param("menuName")String menuName);
	/**
	 * 添加
	 * @param sonMenu
	 * @return
	 */
	public int save(SonMenu sonMenu);
	/**
	 * 修改
	 * @param sonMenu
	 * @return
	 */
	public int update(SonMenu sonMenu);
	/**
	 * 根据ID删除
	 * @param sonMenuId
	 * @return
	 */
	public int delete(int sonMenuId);
}
