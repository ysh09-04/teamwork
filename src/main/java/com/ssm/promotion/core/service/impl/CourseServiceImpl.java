package com.ssm.promotion.core.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.promotion.core.dao.CourseDao;
import com.ssm.promotion.core.dao.PaperDao;
import com.ssm.promotion.core.dao.PaperQuestionDao;
import com.ssm.promotion.core.dao.ProductDao;
import com.ssm.promotion.core.dao.QuestionBankDao;
import com.ssm.promotion.core.dao.QuestionDao;
import com.ssm.promotion.core.dao.Shop_ContentDao;
import com.ssm.promotion.core.dao.VideoCategoryDao;
import com.ssm.promotion.core.dao.VideoDao;
import com.ssm.promotion.core.entity.Course;
import com.ssm.promotion.core.service.CourseService;

/**
 * 课程
 * @author 尤少辉
 * @日期 2018年7月1日
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;
	
	@Autowired
	private VideoCategoryDao videoCategoryDao;

	@Autowired
	private VideoDao videoDao;

	@Autowired
	private QuestionBankDao questionBankDao;

	@Autowired
	private QuestionDao questionDao;

	@Autowired
	private PaperDao paperDao;

	@Autowired
	private PaperQuestionDao paperQuestionDao;

	@Autowired
	private Shop_ContentDao shop_ContentDao;
	
	@Autowired
	private ProductDao productDao;
	/**
	 * 删除
	 * @param courseId
	 * @return
	 */
	@Override
	public int delete(int courseId) {
		// TODO Auto-generated method stub
		List<Integer> videoCategoryIds=new ArrayList<Integer>();//获取要删除的视频类
		List<Integer> questionBankIds=new ArrayList<Integer>();//获取要删除的题库
		List<Integer> paperIds=new ArrayList<Integer>();//获取要删除的考卷
		
		//查询添加数据
		videoCategoryIds.addAll(videoCategoryDao.findByCourseId(courseId));
		questionBankIds.addAll(questionBankDao.findByCourseId(courseId));
		paperIds.addAll(paperDao.findByCourseId(courseId));
		
		List<Integer> videoIds=new ArrayList<Integer>();//获取要删除的视频
		List<Integer> questionIds=new ArrayList<Integer>();//获取要删除的题目
		List<Integer> paperQuestionIds=new ArrayList<Integer>();//获取要删除的考卷题目
		//判断视频类是否为空
		if(0!=videoCategoryIds.size()){
			//添加要删除的视频
			for (Integer integer : videoCategoryIds) {
				videoIds.addAll(videoDao.findByVideoCategoryId(integer));
			}
			//判断视频是否为空
			if(0!=videoIds.size()){
				//删除视频
				for (Integer integer : videoIds) {
					videoDao.delete(integer);
				}
			}
			//删除视频类
			for (Integer integer : videoCategoryIds) {
				int productId= shop_ContentDao.findByContentId(integer);
				shop_ContentDao.delete(productId);
				productDao.deleteProduct(productId);
				videoCategoryDao.delete(integer);
			}
		}
		//判断题库是否为空
		if(0!=questionBankIds.size()){
			//添加题目
			for (Integer integer : questionBankIds) {
				questionIds.addAll(questionDao.findByQuestionBankId(integer));
			}
			//判断题目是否为空
			if(0!=questionIds.size()){
				//删除题目
				for (Integer integer : questionIds) {
					questionDao.delete(integer);
				}
			}
			//删除题库
			for (Integer integer : questionBankIds) {
				int productId= shop_ContentDao.findByContentId(integer);
				shop_ContentDao.delete(productId);
				productDao.deleteProduct(productId);
				questionBankDao.delete(integer);
			}
		}
		//判断考卷是否为空
		if(0!=paperIds.size()){
			//添加考卷题目
			for (Integer integer : paperIds) {
				paperQuestionIds.addAll(paperQuestionDao.findByPaperId(integer));
			}
			//短片题目是否为空
			if(0!=paperQuestionIds.size()){
				//删除题目
				for (Integer integer : paperQuestionIds) {
					paperQuestionDao.delete(integer);
				}
			}
			//删除考卷
			for (Integer integer : paperIds) {
				int productId= shop_ContentDao.findByContentId(integer);
				shop_ContentDao.delete(productId);
				productDao.deleteProduct(productId);
				paperDao.delete(integer);
			}
		}
		return courseDao.delete(courseId);
	}

	/**
	 * 模糊查询/查询全部(分页)
	 * @param map
	 * @return
	 */
	@Override
	public List<Course> findByCourseNameOrAllPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return courseDao.findByCourseNameOrAllPage(map);
	}
	/**
	 * 模糊查询/查询全部(分页)
	 */
	@Override
	public int findByCourseNameOrAllCount(String courseName) {
		// TODO Auto-generated method stub
		return courseDao.findByCourseNameOrAllCount(courseName);
	}

	/**
	 * 添加
	 * @param course
	 * @return
	 */
	@Override
	public int save(Course course) {
		// TODO Auto-generated method stub
		return courseDao.save(course);
	}

	/**
	 * 修改
	 * @param course
	 * @return
	 */
	@Override
	public int update(Course course) {
		// TODO Auto-generated method stub
		return courseDao.update(course);
	}
	/**
	 * 查询全部信息的名字和ID
	 * @return
	 */
	@Override
	public List<Course> findAll() {
		// TODO Auto-generated method stub
		return courseDao.findAll();
	}

}
