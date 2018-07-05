package com.ssm.promotion.core.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ssm.promotion.core.entity.VideoCategory;

/**
 * 视频类目
 * @author 尤少辉
 * @日期 2018年7月1日
 */
public interface VideoCategoryDao {
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
	public int delete(int videoCategoryId);
	/**
	 * 添加
	 * @param videoCategory
	 * @return
	 */
	public int save(VideoCategory videoCategory);
	/**
	 * 修改
	 * @param videoCategory
	 * @return
	 */
	public int update(VideoCategory videoCategory);
	/**
	 * 根据name模糊查询/查询全部  分页
	 * @param videoCategoryName
	 * @return
	 */
	public List<VideoCategory> findByNameOrAllPage(Map<String, Object> map);
	/**
	 * 统计总条数
	 * @param videoCategoryName
	 * @return
	 */
	public int findByNameOrAllCount(@Param("videoCategoryName")String videoCategoryName);
	 /**
     * 查询全部
     * @param 
     * @return
     */
    public List<VideoCategory> findAll(); 
}
