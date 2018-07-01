package com.ssm.promotion.core.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.promotion.core.dao.CategoryDao;
import com.ssm.promotion.core.dao.CourseDao;
import com.ssm.promotion.core.dao.PaperDao;
import com.ssm.promotion.core.dao.PaperQuestionDao;
import com.ssm.promotion.core.dao.QuestionBankDao;
import com.ssm.promotion.core.dao.QuestionDao;
import com.ssm.promotion.core.dao.Shop_ContentDao;
import com.ssm.promotion.core.dao.VideoCategoryDao;
import com.ssm.promotion.core.dao.VideoDao;
import com.ssm.promotion.core.dto.CategoryCategoryDto;
import com.ssm.promotion.core.entity.Category;
import com.ssm.promotion.core.service.CategoryService;

/**
 * 类目的实现类
 * @author 尤少辉
 * @日期 2018年7月1日
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

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
	/**
	 * 添加
	 */
	@Override
	public int save(Category category) {
		// TODO Auto-generated method stub
		return categoryDao.save(category);
	}

	/**
	 * 修改
	 */
	@Override
	public int update(Category category) {
		// TODO Auto-generated method stub
		return categoryDao.update(category);
	}

	/**
	 * 查询
	 */
	@Override
	public List<Category> findByNameOrAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return categoryDao.findByNameOrAll(map);
	}

	/**
	 * 统计
	 */
	@Override
	public int findByNameOrAllcount(String categoryName) {
		// TODO Auto-generated method stub
		return categoryDao.findByNameOrAllcount(categoryName);
	}

	/**
	 * 删除类目及其子类
	 */
	@Override
	public int delete(int categoryId) {
		int categoryLevel=categoryDao.findByCategoryId(categoryId);
		List<Integer> categoryIds=new ArrayList<Integer>();//获取要删除的类目
		categoryIds.add(categoryId);
		//获取该类目的子类目
		for(int i=categoryLevel;i>1;i--){
			categoryIds.addAll(categoryDao.findByFatherId(categoryId));
		}
		//判断是否为空，不为空获取类目下的课程，视频类，题库，考卷，视频，题目，考卷题目
		if(0!=categoryIds.size()){
			List<Integer> courseIds=new ArrayList<Integer>();//获取要删除的课程
			for (Integer integer : categoryIds) {
				courseIds.addAll(courseDao.findByCategoryId(integer));
			}
			if(0!=courseIds.size()){
				List<Integer> videoCategoryIds=new ArrayList<Integer>();//获取要删除的视频类
				List<Integer> questionBankIds=new ArrayList<Integer>();//获取要删除的题库
				List<Integer> paperIds=new ArrayList<Integer>();//获取要删除的考卷
				for (Integer integer : courseIds) {
					videoCategoryIds.addAll(videoCategoryDao.findByCourseId(integer));
					questionBankIds.addAll(questionBankDao.findByCourseId(integer));
					paperIds.addAll(paperDao.findByCourseId(integer));
				}
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
						shop_ContentDao.delete("视频类",integer);
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
						shop_ContentDao.delete("题库",integer);
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
						shop_ContentDao.delete("考卷",integer);
						paperDao.delete(integer);
					}
				}
			}
			//删除课程
			for (Integer integer : courseIds) {
				courseDao.delete(integer);
			}
		}
		//删除类别
		for (Integer integer : categoryIds) {
			categoryDao.delete(integer);
		}
		return 1;
	}

	/**
	 * 根据父类查询子类
	 */
	@Override
	public List<Integer> findByFatherId(int categoryId) {
		// TODO Auto-generated method stub
		return categoryDao.findByFatherId(categoryId);
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryDao.findAll();
	}

}
