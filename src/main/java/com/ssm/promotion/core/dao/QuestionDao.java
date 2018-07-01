package com.ssm.promotion.core.dao;

import java.util.List;

/**
 * 题目
 * @author 尤少辉
 * @日期 2018年7月1日
 */
public interface QuestionDao {
	/**
	 * 根据题库id查询要删除的ID集合
	 * @param categoryId
	 * @return
	 */
	public List<Integer> findByQuestionBankId(int questionBankId);
	/**
	 * 根据ID删除
	 * @param courseId
	 * @return
	 */
	public int delete(int questionId);
}
