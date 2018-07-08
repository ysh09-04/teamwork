package com.ssm.promotion.core.service;

import java.util.List;
import java.util.Map;

import com.ssm.promotion.core.dto.ArticleCourseDto;
import com.ssm.promotion.core.entity.Article;



  public interface ArticleService {
	/**
	 * 根据课程id查询要删除的ID集合
	 * @param 
	 * @return
	 */
	public List<Integer> findByCourseId(int courseId);
	/**
	 * 根据ID删除
	 * @param courseId
	 * @return
	 */
	public int delete(int articleId);
	/**
	 * 查询全部
	 * @param map
	 * @return
	 */
	public List<ArticleCourseDto> findArticle(Map<String, Object> map); 
	

    /**分页
     * @param map
     * @return
     */
    public Long getTotalArticle(Map<String, Object> map);
    /**
     * 添加
     *
     * @param 
     * @return
     */
    public int addArticle(Article article);
    /**
     * 根据articleTitle获取
     * @param 
     * @return
     */
    Article getArticleByarticleTitle(String articleTitle);
    /**
     * 更新
     *
     * @param 
     * @return
     */
    public int updateArticle(Article article);
    /**
     * 查询全部
     *
     * @param 
     * @return
     */
    public List<Article> findAll();
   
}


