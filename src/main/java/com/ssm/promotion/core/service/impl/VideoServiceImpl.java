package com.ssm.promotion.core.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.promotion.core.dao.VideoDao;
import com.ssm.promotion.core.dto.VideoVideoCategoryDto;
import com.ssm.promotion.core.entity.Video;
import com.ssm.promotion.core.service.VideoService;
import com.ssm.promotion.core.util.UploadVideoDemo;

/**
 * 视频
 * @author 尤少辉
 * @日期 2018年7月7日
 */
@Service("videoService")
public class VideoServiceImpl implements VideoService {
	
	@Autowired
	private VideoDao videoDao;
	/**
	 * 根据视频类id查询要删除的ID集合
	 * @param categoryId
	 * @return
	 */
	@Override
	public List<Integer> findByVideoCategoryId(int videoCategoryId) {
		// TODO Auto-generated method stub
		return videoDao.findByVideoCategoryId(videoCategoryId);
	}
	/**
	 * 根据ID删除
	 * @param courseId
	 * @return
	 */
	@Override
	public int delete(int videoId) {
		// TODO Auto-generated method stub
		return videoDao.delete(videoId);
	}
	/**
	 * 根据视频名模糊查询/查询全部 (分页)
	 * @param map
	 * @return
	 */
	@Override
	public List<VideoVideoCategoryDto> findByVideoNameOrAllpage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return videoDao.findByVideoNameOrAllpage(map);
	}
	/**
	 * 根据视频名模糊查询/查询全部 总数
	 * @param map
	 * @return
	 */
	@Override
	public int findByVideoNameOrAllCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return videoDao.findByVideoNameOrAllCount(map);
	}
	/**
	 * 修改
	 * @param video
	 * @return
	 */
	@Override
	public int update(Video video,String videoName) {
		String videoUrl= UploadVideoDemo.upload(video.getVideoUrl(),videoName);
		video.setVideoUrl(videoUrl);
		return videoDao.update(video);
	}
	/**
	 * 添加
	 * @param video
	 * @return
	 */
	@Override
	public int save(Video video,String videoName) {
		String videoUrl= UploadVideoDemo.upload(video.getVideoUrl(),videoName);
		video.setVideoUrl(videoUrl);
		return videoDao.save(video);
	}

}
