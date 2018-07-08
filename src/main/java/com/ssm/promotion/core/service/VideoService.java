package com.ssm.promotion.core.service;

import java.util.List;
import java.util.Map;

import com.ssm.promotion.core.dto.VideoVideoCategoryDto;
import com.ssm.promotion.core.entity.Video;

/**
 * 视频
 * @author 尤少辉
 * @日期 2018年7月7日
 */
public interface VideoService {
	/**
	 * 根据视频类id查询要删除的ID集合
	 * @param categoryId
	 * @return
	 */
	public List<Integer> findByVideoCategoryId(int videoCategoryId);
	/**
	 * 根据ID删除
	 * @param courseId
	 * @return
	 */
	public int delete(int videoId);
	/**
	 * 根据视频名模糊查询/查询全部 (分页)
	 * @param map
	 * @return
	 */
	public List<VideoVideoCategoryDto> findByVideoNameOrAllpage(Map<String, Object> map);
	/**
	 * 根据视频名模糊查询/查询全部 总数
	 * @param map
	 * @return
	 */
	public int findByVideoNameOrAllCount(Map<String, Object> map);
	/**
	 * 修改
	 * @param video
	 * @return
	 */
	public int update(Video video,String videoName);
	/**
	 * 添加
	 * @param video
	 * @return
	 */
	public int save(Video video,String videoName);
}
