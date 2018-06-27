package com.ssm.promotion.core.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ssm.promotion.core.entity.Teacher;

/**
 * 教师的dao层
 * @author 尤少辉
 * @日期 2018年6月27日
 */
@Repository
public interface TeacherDao {
	/**
	 * 查询 全部或者模糊查询
	 * @param page
	 * @param rows
	 * @param tname
	 * @return
	 */
	public List<Teacher> findAll(Map<String, Object> map);
	/**
	 * 查询全部的总数
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
