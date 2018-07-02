package com.ssm.promotion.core.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ssm.promotion.core.entity.VideoCategory;

/**
 * 视频类
 * @author 尤少辉
 * @日期 2018年7月2日
 */
public interface VideoCategoryService {
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
}
