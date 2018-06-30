package com.ssm.promotion.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.promotion.core.dao.UserDao;
import com.ssm.promotion.core.entity.SUser;
import com.ssm.promotion.core.service.UserService;
import com.ssm.promotion.core.util.MD5Util;
import com.ssm.promotion.core.util.StringUtil;

/**
 * @author 1034683568@qq.com
 * @project_name perfect-ssm
 * @date 2017-3-1
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
    
    @Override
    public SUser login(SUser user) {
        return userDao.login(user);
    }

  
    @Override
    public int addUser(SUser user) {
        if (user.getUserName() == null || user.getPassword() == null) {
            return 0;
        }
    	String MD5pwd = MD5Util.MD5Encode(user.getPassword(), "UTF-8");
		user.setPassword(MD5pwd);
		user.setStatus(0);//正常状态
        user.setUuid(StringUtil.getUUID());//唯一ID
        return userDao.addUser(user);
    }

	@Override
	public SUser getUserByName(String userName) {
		return userDao.getUserByName(userName);
	}


}
