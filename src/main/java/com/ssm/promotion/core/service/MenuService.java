package com.ssm.promotion.core.service;

import java.util.List;
import java.util.Map;

import com.ssm.promotion.core.dto.MenuDTO;
import com.ssm.promotion.core.dto.MenuManageDTO;
import com.ssm.promotion.core.dto.RoleAuthParentMenuDTO;
import com.ssm.promotion.core.entity.Menu;

/**
 * @description
 * @author chj
 * @date 创建时间：2018-4-25 下午2:27:57
 * @version 1.0
 * @since
 */
public interface MenuService {
	
	/**
	 * 构建左侧导航菜单
	 * 
	 * @return
	 */
	List<MenuDTO> findRoleMenus(Integer roleId);

	/**
	 * 菜单管理表格
	 * 
	 * @return
	 */
	List<MenuManageDTO> datagrid(Map map);

	/**
	 * 添加菜单
	 * 
	 * @param menu
	 * @return
	 */
	int insert(Menu menu);

	/**
	 * 编辑菜单
	 * 
	 * @param menu
	 * @return
	 */
	int update(Menu menu);

	/**
	 * 删除菜单
	 * 
	 * @param id
	 * @return
	 */
	int delete(int id);

	/**
	 * 获取所有父菜单
	 * 
	 * @return
	 */
	List<MenuDTO> findParentMenus();
	
	/**
	 * 获取菜单总数
	 * @return
	 */
	Long getTotalMenu(Map map);
}
