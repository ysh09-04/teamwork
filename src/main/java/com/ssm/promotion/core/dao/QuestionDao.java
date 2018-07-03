package com.ssm.promotion.core.dao;

import java.util.List;
import java.util.Map;


import com.ssm.promotion.core.dto.QuestionAndbankDto;
import com.ssm.promotion.core.entity.Paper;
import com.ssm.promotion.core.entity.Question;

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
	
	/**
	 * 查询全部
	 * @param map
	 * @return
	 */
	public List<QuestionAndbankDto> findQuestion(Map<String, Object> map); 
	

    /**分页
     * @param map
     * @return
     */
    public Long getTotalQuestion(Map<String, Object> map);
    /**
     * 添加
     *
     * @param 
     * @return
     */
    public int addQuestion(Question question);
    /**
     * 根据类型获取
     * @param 
     * @return
     */
    Paper getQuestionByName(String questionType);
    /**
     * 更新
     *
     * @param 
     * @return
     */
    public int updateQuestion(Question question);
}
