package com.ssm.promotion.core.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.promotion.core.dao.Role_FathermenuDao;
import com.ssm.promotion.core.dto.RoleFathermenuDto;
import com.ssm.promotion.core.entity.Role_Fathermenu;
import com.ssm.promotion.core.service.Role_FathermenuService;
/**
 * @author 刘家霖
 * @project_name perfect-ssm
 * @date 2018-7-2
 */
@Service("role_FathermenuService")
public class Role_FathermenuServiceImpl implements Role_FathermenuService {
	 @Resource
	 private Role_FathermenuDao role_FathermenuDao;
	@Override
	public List<RoleFathermenuDto> findAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<RoleFathermenuDto> roleFathermenuDtos=role_FathermenuDao.findAll(map);
		for(int i=0;i<roleFathermenuDtos.size();i++){
			roleFathermenuDtos.get(i).setRole_fatherMenuId(i+1);
		}
		return roleFathermenuDtos;
	}

	@Override
	public Long getTotalRole_Fathermenu(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return role_FathermenuDao.getTotalRole_Fathermenu(map);
	}

	@Override
	public int add(Role_Fathermenu role_Fathermenu) {
		// TODO Auto-generated method stub
		return role_FathermenuDao.add(role_Fathermenu);
	}

	@Override
	public int update(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return role_FathermenuDao.update(map);
	}

	@Override
	public int delete(Role_Fathermenu role_Fathermenu) {
		// TODO Auto-generated method stub
		return role_FathermenuDao.delete(role_Fathermenu);
	}

}
