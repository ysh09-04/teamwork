package com.ssm.promotion.core.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.promotion.core.dao.SonMenuDao;
import com.ssm.promotion.core.entity.SonMenu;
import com.ssm.promotion.core.service.SonMenuService;

@Service("sonMenuService")
public class SonMenuServiceImpl implements SonMenuService {
	
	@Autowired
	private SonMenuDao sonMenuDao;
	/**
	 * 根据菜单名分页查询信息
	 * @param map
	 * @return
	 */
	@Override
	public List<SonMenu> findByMenuNameOrAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sonMenuDao.findByMenuNameOrAll(map);
	}
	/**
	 * 统计所有的数目
	 * @param menuName
	 * @return
	 */
	@Override
	public int findAllCount(String menuName) {
		// TODO Auto-generated method stub
		return sonMenuDao.findAllCount(menuName);
	}
	/**
	 * 添加
	 * @param sonMenu
	 * @return
	 */
	@Override
	public int save(SonMenu sonMenu) {
		// TODO Auto-generated method stub
		return sonMenuDao.save(sonMenu);
	}
	/**
	 * 修改
	 * @param sonMenu
	 * @return
	 */
	@Override
	public int update(SonMenu sonMenu) {
		// TODO Auto-generated method stub
		return sonMenuDao.update(sonMenu);
	}
	/**
	 * 删除
	 * @param sonMenu
	 * @return
	 */
	@Override
	public int delete(int sonMenuId) {
		// TODO Auto-generated method stub
		return sonMenuDao.delete(sonMenuId);
	}
}
