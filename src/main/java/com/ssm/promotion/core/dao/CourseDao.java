package com.ssm.promotion.core.dao;

import java.util.List;

/**
 * 课程
 * @author 尤少辉
 * @日期 2018年7月1日
 */
public interface CourseDao {
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
}
