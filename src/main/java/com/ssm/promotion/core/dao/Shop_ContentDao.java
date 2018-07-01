package com.ssm.promotion.core.dao;

import org.apache.ibatis.annotations.Param;

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
	public int delete(@Param("type")String type,@Param("contentId")int contentId);
}
