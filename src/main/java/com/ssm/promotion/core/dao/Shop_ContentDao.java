package com.ssm.promotion.core.dao;

/**
 * 商品内容
 * @author 尤少辉
 * @日期 2018年7月1日
 */
public interface Shop_ContentDao {
	/**
	 * 根据类型和contentId删除
	 * @param shop_Content
	 * @return
	 */
	public int delete(int productId);
	/**
	 * 根据contentId查询productId
	 * @param contentId
	 * @return
	 */
	public int findByContentId(int contentId);
}
