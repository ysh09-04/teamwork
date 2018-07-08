package com.ssm.promotion.core.dao;

import java.util.List;
import java.util.Map;

import com.ssm.promotion.core.dto.TuserCourseAndTuserAndCourseDto;
import com.ssm.promotion.core.entity.UserCourse;

/**
 * 用户课程
 * @author 尤少辉
 * @日期 2018年7月8日
 */
public interface UserCourseDao {
	/**
     * 查找
     *
     * @param map
     * @return
     */
    public List<TuserCourseAndTuserAndCourseDto> findAll(Map<String, Object> map);
    /**
     * @param map
     * @return
     */
    public Long getTotalUserCourse(Map<String, Object> map);
    /**
     * 修改
     *
     * @param 
     * @return
     */
    public int updateStateAndastIdById(UserCourse userCourse);
}
