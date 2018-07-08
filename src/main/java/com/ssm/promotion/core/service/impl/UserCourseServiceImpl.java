package com.ssm.promotion.core.service.impl;

import java.util.List;

import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.ssm.promotion.core.dao.UserCourseDao;
import com.ssm.promotion.core.dto.TuserCourseAndTuserAndCourseDto;
import com.ssm.promotion.core.entity.UserCourse;
import com.ssm.promotion.core.service.UserCourseService;

/**
 * 用户课程
 * @author 尤少辉
 * @日期 2018年7月8日
 */
@Service("userCourseService")
public class UserCourseServiceImpl implements UserCourseService {
	@Resource
	private UserCourseDao userCourseDao;
	
	@Override
	public List<TuserCourseAndTuserAndCourseDto> findAll(Map<String, Object> map) {
		List<TuserCourseAndTuserAndCourseDto> userCourseDtos=userCourseDao.findAll(map);
		return userCourseDtos;
	}

	@Override
	public Long getTotalUserCourse(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userCourseDao.getTotalUserCourse(map);
	}

	@Override
	public int updateStateAndastIdById(UserCourse userCourse) {
		// TODO Auto-generated method stub
		return userCourseDao.updateStateAndastIdById(userCourse);
	}

	

}
