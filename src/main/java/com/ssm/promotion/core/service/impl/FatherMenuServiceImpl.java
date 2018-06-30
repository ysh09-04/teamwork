package com.ssm.promotion.core.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.promotion.core.dao.FatherMenuDao;
import com.ssm.promotion.core.dao.FatherMenu_RoleDao;
import com.ssm.promotion.core.dao.SonMenuDao;
import com.ssm.promotion.core.dao.UserDao;
import com.ssm.promotion.core.dto.FatherMenuSonMenuDto;
import com.ssm.promotion.core.entity.FatherMenu;
import com.ssm.promotion.core.entity.SUser;
import com.ssm.promotion.core.service.FatherMenuService;

/**
 * 父菜单
 * @author 尤少辉
 * @日期 2018年6月30日
 */
@Service("fatherMenuService")
public class FatherMenuServiceImpl implements FatherMenuService{

	@Autowired
	private FatherMenuDao fatherMenuDao;

	@Resource
	private SonMenuDao sonMenuDao;
	
	@Resource
	private UserDao userDao;
	
	@Resource
	private FatherMenu_RoleDao fatherMenu_RoleDao;
	/**
	 * 根据用户名查询该角色所能操作的功能
	 */
	@Override
	public List<FatherMenuSonMenuDto> findByUserName(String username) {
		// TODO Auto-generated method stub
		return fatherMenuDao.findByUserName(username);
	}

	/**
	 * 统计总条数
	 */
	@Override
	public List<FatherMenu> findByFatherMenuOrAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return fatherMenuDao.findByFatherMenuOrAll(map);
	}

	@Override
	public int findByFatherMenuOrAllCount(String menuName) {
		// TODO Auto-generated method stub
		return fatherMenuDao.findByFatherMenuOrAllCount(menuName);
	}

	/**
	 * 删除父菜单以及他的子菜单
	 */
	@Override
	public int delete(int fatherMenuId) {
		// TODO Auto-generated method stub
		int count=0;
		List<Integer> ids=sonMenuDao.findByFatherMenuId(fatherMenuId);
		if(0!=ids.size()){
			for (Integer integer : ids) {
				sonMenuDao.delete(integer);
			}
		}
		fatherMenuDao.delete(fatherMenuId);
		count=fatherMenu_RoleDao.delete(fatherMenuId);
		return count;
	}

	/**
	 * 修改
	 */
	@Override
	public int update(FatherMenu fatherMenu) {
		// TODO Auto-generated method stub
		return fatherMenuDao.update(fatherMenu);
	}

	/**
	 * 添加自己和关联表
	 */
	@Override
	public int save(FatherMenu fatherMenu,SUser user) {
		int count=0;
		fatherMenuDao.save(fatherMenu);
		int roleId= userDao.getRoleIdByName(user.getUserName());
		count=fatherMenu_RoleDao.save(fatherMenu.getFatherMenuId(), roleId);
		// TODO Auto-generated method stub
		return count;
	}
	/**
	 * 查询全部的id和菜单名
	 * @param fatherMenu
	 * @return
	 */
	@Override
	public List<FatherMenu> findAllIdAndName() {
		// TODO Auto-generated method stub
		return fatherMenuDao.findAllIdAndName();
	}
}
