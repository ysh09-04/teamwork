package com.ssm.promotion.core.dao;

import java.util.List;
import java.util.Map;

import com.ssm.promotion.core.dto.QuestionbankCourseDto;
import com.ssm.promotion.core.dto.RoleFathermenuDto;

public interface Role_FathermenuDao {
	/**
     * 查找题库
     *
     * @param map
     * @return
     */
    public List<RoleFathermenuDto> findAll(Map<String, Object> map);
    /**
     * @param map
     * @return
     */
    public Long getTotalRole_Fathermenu(Map<String, Object> map);

}