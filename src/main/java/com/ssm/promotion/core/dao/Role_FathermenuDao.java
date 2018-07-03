package com.ssm.promotion.core.dao;

import java.util.List;
import java.util.Map;

import com.ssm.promotion.core.dto.QuestionbankCourseDto;
import com.ssm.promotion.core.dto.RoleFathermenuDto;
import com.ssm.promotion.core.entity.Role_Fathermenu;
import com.ssm.promotion.core.entity.SRole;

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
    /**
     * 添加角色菜单
     *
     * @param 
     * @return
     */
    public int add(Role_Fathermenu role_Fathermenu);
    /**
     * 修改角色父菜单
     *
     * @param role_Fathermenu
     * @return
     */
    public int update(Map<String, Integer> map);
    /**
     * 删除角色父菜单
     *
     * @param role_Fathermenu
     * @return
     */
    public int delete(Role_Fathermenu role_Fathermenu);

}
