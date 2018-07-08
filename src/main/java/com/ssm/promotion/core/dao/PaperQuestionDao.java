package com.ssm.promotion.core.dao;

import java.util.List;
import java.util.Map;

import com.ssm.promotion.core.dto.PaperQuestionDto;
import com.ssm.promotion.core.entity.PaperQuestion;
import com.ssm.promotion.core.entity.Product;
import com.ssm.promotion.core.entity.QuestionBank;

/**
 * 考卷
 * @author 尤少辉
 * @日期 2018年7月1日
 */
public interface PaperQuestionDao {
	/**
	 * 根据考卷id查询要删除的ID集合
	 * @param categoryId
	 * @return
	 */
	public List<Integer> findByPaperId(int paperId);
	/**
	 * 根据ID删除
	 * @param courseId
	 * @return
	 */
	public int delete(int paperQuestionId);
	/**
     * 查找搜索
     *
     * @param map
     * @return
     */
    public List<PaperQuestionDto> findAll(Map<String, Object> map);

    /**
     * @param map
     * @return
     */
    public Long getTotal(Map<String, Object> map);
    /**
     * 添加
     *
     * @param 
     * @return
     */
    public int add(PaperQuestion paperQuestion);
    /**
     * 修改
     *
     * @param 
     * @return
     */
    public int update(PaperQuestion paperQuestion);
    /**
	 * 删除
	 * @param 
	 * @return
	 */
	public int delete2(PaperQuestion paperQuestion);
}
