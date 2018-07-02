package com.ssm.promotion.core.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.promotion.core.dao.RoleDao;
import com.ssm.promotion.core.dao.UserDao;
import com.ssm.promotion.core.entity.SRole;
import com.ssm.promotion.core.service.RoleService;
/**
 * @author 刘家霖
 * @project_name perfect-ssm
 * @date 2018-7-1
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao ;

	@Override
	public List<SRole> findRole(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return roleDao.findRole(map);
	}

	@Override
	public Long getTotalRole(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return roleDao.getTotalRole(map);
	}

	@Override
	public int addSRole(SRole sRole) {
		// TODO Auto-generated method stub
		return roleDao.addSRole(sRole);
	}

	@Override
	public int updateSRole(SRole sRole) {
		// TODO Auto-generated method stub
		return roleDao.updateSRole(sRole);
	}

	@Override
	public int deleteSRole(Integer roleId) {
		// TODO Auto-generated method stub
		return roleDao.deleteSRole(roleId);
	}

}
