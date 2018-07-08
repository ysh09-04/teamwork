package com.ssm.promotion.core.service;

import java.util.List;
import java.util.Map;

import com.ssm.promotion.core.dto.PaperQuestionDto;
import com.ssm.promotion.core.entity.PaperQuestion;

public interface PaperQuestionService {
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
