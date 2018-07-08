package com.ssm.promotion.core.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.promotion.core.dao.ArticleDao;
import com.ssm.promotion.core.dto.ArticleCourseDto;
import com.ssm.promotion.core.entity.Article;
import com.ssm.promotion.core.service.ArticleService;
@Service("articleService")
public class ArticleServiceImpl implements ArticleService{

	
	@Autowired
	private ArticleDao articleDao;

	@Override
	public List<Integer> findByCourseId(int courseId) {
		// TODO Auto-generated method stub
		return articleDao.findByCourseId(courseId);
	}

	@Override
	public int delete(int articleId) {
		// TODO Auto-generated method stub
		return articleDao.delete(articleId);
	}

	@Override
	public List<ArticleCourseDto> findArticle(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return articleDao.findArticle(map);
	}

	@Override
	public Long getTotalArticle(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return articleDao.getTotalArticle(map);
	}

	@Override
	public int addArticle(Article article) {
		// TODO Auto-generated method stub
		return articleDao.addArticle(article);
	}

	@Override
	public Article getArticleByarticleTitle(String articleTitle) {
		// TODO Auto-generated method stub
		return articleDao.getArticleByarticleTitle(articleTitle);
	}

	@Override
	public int updateArticle(Article article) {
		// TODO Auto-generated method stub
		return articleDao.updateArticle(article);
	}

	@Override
	public List<Article> findAll() {
		// TODO Auto-generated method stub
		return articleDao.findAll();
	}
	
	
}
