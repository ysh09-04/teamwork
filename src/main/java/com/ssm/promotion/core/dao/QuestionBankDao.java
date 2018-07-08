package com.ssm.promotion.core.dao;

import java.util.List;
import java.util.Map;

import com.ssm.promotion.core.dto.QuestionbankCourseDto;
import com.ssm.promotion.core.entity.QuestionBank;

/**
 * 题库
 * @author 尤少辉
 * @日期 2018年7月1日
 */
public interface QuestionBankDao {
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
	public int delete(Integer questionBankId);
	/**
     * 查找题库
     *
     * @param map
     * @return
     */
    public List<QuestionbankCourseDto> findAll(Map<String, Object> map);

    /**
     * @param map
     * @return
     */
    public Long getTotalQuestionbank(Map<String, Object> map);
    /**
     * 添加题库
     *
     * @param srole
     * @return
     */
    public int add(QuestionBank questionBank);
    /**
     * 修改角色信息
     *
     * @param questionBank
     * @return
     */
    public int update(QuestionBank questionBank);
    
    /**
     * 查询全部课程ID和name
     * @return
     */
    public List<QuestionBank> findAllIdAndName();
    /**
     * 查询全部
     * @param 
     * @return
     */
    public List<QuestionBank> findAll2(); 
}
