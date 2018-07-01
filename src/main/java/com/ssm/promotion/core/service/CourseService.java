package com.ssm.promotion.core.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ssm.promotion.core.entity.Course;
/**
 * 课程
 * @author 尤少辉
 * @日期 2018年7月1日
 */
public interface CourseService {
	/**
	 * 根据ID删除
	 * @param courseId
	 * @return
	 */
	public int delete(int courseId);
	/**
	 * 模糊查询/查询全部(分页)
	 */
	public List<Course> findByCourseNameOrAllPage(Map<String, Object> map);
	/**
	 * 模糊查询/查询全部(分页)
	 */
	public int findByCourseNameOrAllCount(@Param("courseName")String courseName);
	/**
	 * 添加
	 */
	public int save(Course course);
	/**
	 * 修改
	 */
	public int update(Course course);
}
