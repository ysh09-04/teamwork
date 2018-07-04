package com.ssm.promotion.core.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ssm.promotion.core.dto.CourseCategoryDto;
import com.ssm.promotion.core.entity.Course;

/**
 * 课程
 * @author 尤少辉
 * @日期 2018年7月1日
 */
public interface CourseDao {
	/**
	 * 查询全部信息的名字和ID
	 * @return
	 */
	public List<Course> findAll();
	/**
	 * 根据类目id查询要删除的ID集合
	 * @param categoryId
	 * @return
	 */
	public List<Integer> findByCategoryId(int categoryId);
	/**
	 * 根据ID删除
	 * @param courseId
	 * @return
	 */
	public int delete(int courseId);
	/**
	 * 模糊查询/查询全部(分页)
	 */
	public List<CourseCategoryDto> findByCourseNameOrAllPage(Map<String, Object> map);
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
