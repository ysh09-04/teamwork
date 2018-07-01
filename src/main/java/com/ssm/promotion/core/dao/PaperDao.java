package com.ssm.promotion.core.dao;

import java.util.List;

/**
 * 考卷
 * @author 尤少辉
 * @日期 2018年7月1日
 */
public interface PaperDao {
	/**
	 * 根据课程id查询要删除的ID集合
	 * @param categoryId
	 * @return
	 */
	public List<Integer> findByCourseId(int courseId);
	/**
	 * 根据ID删除
	 * @param courseId
	 * @return
	 */
	public int delete(int paperId);
}
