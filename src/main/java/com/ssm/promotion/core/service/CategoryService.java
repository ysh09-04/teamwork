package com.ssm.promotion.core.service;

import java.util.List;
import java.util.Map;

import com.ssm.promotion.core.dto.CategoryCategoryDto;
import com.ssm.promotion.core.entity.Category;

/**
 * 类目
 * @author 尤少辉
 * @日期 2018年7月1日
 */
public interface CategoryService {
	/**
	 * 查询全部信息
	 * @return
	 */
	public List<Category> findAll();
	/**
	 * 添加
	 * @return
	 */
	public int save(Category category);
	/**
	 * 修改
	 * @return
	 */
	public int update(Category category);
	/**
	 * 根据名字模糊查询，或者查询全部（分页）
	 * @return
	 */
	public List<Category> findByNameOrAll(Map<String, Object> map);
	/**
	 * 根据名字模糊查询，或者查询全部的数目
	 * @return
	 */
	public int findByNameOrAllcount(String categoryName);
	/**
	 * 删除
	 * @param categoryId
	 * @return
	 */
	public int delete(int categoryId);
	/**
	 * 根据id查询子类的id
	 * @param categoryId
	 * @return
	 */
	public List<Integer> findByFatherId(int categoryId);
}
