package com.ssm.promotion.core.service;

import java.util.List;
import java.util.Map;

import com.ssm.promotion.core.dto.QuestionbankCourseDto;
import com.ssm.promotion.core.entity.QuestionBank;
/**
 * @author 刘家霖
 * @project_name perfect-ssm
 * @date 2018-7-2
 */
public interface QuestionBankService {
	
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
	 * 根据ID删除
	 * @param courseId
	 * @return
	 */
	public int delete(int questionBankId);
	/**
     * 查询全部课程ID和name
     * @return
     */
    public List<QuestionBank> findAllIdAndName();
}
