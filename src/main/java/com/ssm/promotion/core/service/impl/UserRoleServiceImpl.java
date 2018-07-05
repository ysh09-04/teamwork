package com.ssm.promotion.core.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.promotion.core.dao.UserRoleDao;
import com.ssm.promotion.core.dto.RoleFathermenuDto;
import com.ssm.promotion.core.dto.UserRoleDto;
import com.ssm.promotion.core.entity.UserRole;
import com.ssm.promotion.core.service.UserRoleService;
@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {

	 @Resource
	 private UserRoleDao userRoleDao;
	
	@Override
	public List<UserRoleDto> findAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<UserRoleDto> userRoleDtos=userRoleDao.findAll(map);
		for(int i=0;i<userRoleDtos.size();i++){
			userRoleDtos.get(i).setUser_roleId(i+1);
		}
		return userRoleDtos;
	}

	@Override
	public Long getTotalUserRole(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userRoleDao.getTotalUserRole(map);
	}

	@Override
	public int add(UserRole userRole) {
		// TODO Auto-generated method stub
		return userRoleDao.add(userRole);
	}

	@Override
	public int update(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return userRoleDao.update(map);
	}

	@Override
	public int delete(UserRole userRole) {
		// TODO Auto-generated method stub
		return userRoleDao.delete(userRole);
	}

}
