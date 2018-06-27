package com.ssm.promotion.core.service;

import java.util.List;
import java.util.Map;

import com.ssm.promotion.core.entity.Teacher;

/**
 * 老师的接口
 * @author 尤少辉
 * @日期 2018年6月27日
 */
public interface TeacherService {
	/**
	 * 查询全部
	 * @param page
	 * @param rows
	 * @param tname
	 * @return
	 */
	public List<Teacher> findAll(Map<String, Object> map);
	/**
	 * 查询全部
	 * @param page
	 * @param rows
	 * @param tname
	 * @return
	 */
	public int findAllCount(Map<String, Object> map);
	/**
	 * 添加
	 * @param teacher
	 * @return
	 */
	public int save(Teacher teacher);
	/**
	 * 删除
	 * @param tid
	 * @return
	 */
	public int delete(int tid);
	/**
	 * 修改
	 * @param teacher
	 * @return
	 */
	public int update(Teacher teacher);
	/**
	 * 根据ID查询
	 * @param tid
	 * @return
	 */
	public Teacher findByTid(int tid);
}
