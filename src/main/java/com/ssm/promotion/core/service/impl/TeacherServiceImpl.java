package com.ssm.promotion.core.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.promotion.core.dao.TeacherDao;
import com.ssm.promotion.core.entity.Teacher;
import com.ssm.promotion.core.service.TeacherService;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherDao teacherDao;
	/**
	 * 分页   查询全部或者根据名字的模糊查询
	 */
	@Override
	public List<Teacher> findAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return teacherDao.findAll(map);
	}

	/**
	 * 添加
	 */
	@Override
	public int save(Teacher teacher) {
		if(null!=teacher){
		    return teacherDao.save(teacher);
		}else{
			return 0;
		}
	}
	/**
	 * 根据ID删除
	 */
	@Override
	public int delete(int tid) {
		if(0==tid){
			return 0;
		}
		return teacherDao.delete(tid);
	}
	/**
	 * 修改
	 */
	@Override
	public int update(Teacher teacher) {
		if(null!=teacher){
		    return teacherDao.update(teacher);
		}else{
			return 0;
		}
	}
	/**
	 * 根据ID查询信息
	 */
	@Override
	public Teacher findByTid(int tid) {
		if(0==tid){
			return null;
		}
		return teacherDao.findByTid(tid);
	}

	/**
	 * 查询模糊或者全部总条数
	 */
	@Override
	public int findAllCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return teacherDao.findAllCount(map);
	}

}
