package com.ssm.promotion.core.dao;

import java.util.List;
import java.util.Map;

import com.ssm.promotion.core.dto.PaperCourseDto;
import com.ssm.promotion.core.entity.Paper;
import com.ssm.promotion.core.entity.Product;


/**
 * 考卷
 * @author 尤少辉
 * @日期 2018年7月1日
 */
public interface PaperDao {
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
	public int delete(int paperId);
	/**
	 * 查询全部
	 * @param map
	 * @return
	 */
	public List<PaperCourseDto> findPaper(Map<String, Object> map); 
	

    /**分页
     * @param map
     * @return
     */
    public Long getTotalPaper(Map<String, Object> map);
    /**
     * 添加
     *
     * @param 
     * @return
     */
    public int addPaper(Paper paper);
    /**
     * 根据名字获取
     * @param 
     * @return
     */
    Paper getPaperByName(String paperName);
    /**
     * 更新
     *
     * @param 
     * @return
     */
    public int updatePaper(Paper paper);
    /**
     * 查询全部
     *
     * @param 
     * @return
     */
    public List<Paper> findAll();
}
