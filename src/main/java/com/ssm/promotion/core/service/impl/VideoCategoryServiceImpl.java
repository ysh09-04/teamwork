package com.ssm.promotion.core.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.promotion.core.dao.VideoCategoryDao;
import com.ssm.promotion.core.entity.VideoCategory;
import com.ssm.promotion.core.service.VideoCategoryService;
/**
 * 视频类的实现类
 * @author 尤少辉
 * @日期 2018年7月2日
 */
@Service("videoCategoryService")
public class VideoCategoryServiceImpl implements VideoCategoryService {

	@Autowired
	private VideoCategoryDao videoCategoryDao;
	/**
	 * 删除
	 */
	@Override
	public int delete(int videoCategoryId) {
		// TODO Auto-generated method stub
		return videoCategoryDao.delete(videoCategoryId);
	}

	/**
	 * 添加
	 */
	@Override
	public int save(VideoCategory videoCategory) {
		// TODO Auto-generated method stub
		return videoCategoryDao.save(videoCategory);
	}

	/**
	 * 修改
	 */
	@Override
	public int update(VideoCategory videoCategory) {
		// TODO Auto-generated method stub
		return videoCategoryDao.update(videoCategory);
	}

	/**
	 * 根据name模糊查询/查询全部  分页
	 */
	@Override
	public List<VideoCategory> findByNameOrAllPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return videoCategoryDao.findByNameOrAllPage(map);
	}

	/**
	 * 根据name模糊查询/查询全部 的总条数
	 */
	@Override
	public int findByNameOrAllCount(String videoCategoryName) {
		// TODO Auto-generated method stub
		return videoCategoryDao.findByNameOrAllCount(videoCategoryName);
	}

}
