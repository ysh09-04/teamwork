package com.ssm.promotion.core.service;

import java.util.List;
import java.util.Map;

import com.ssm.promotion.core.dto.ProductContentDto;
import com.ssm.promotion.core.entity.Shop_Content;

public interface Shop_ContentService {
	
    /**
     * 查找商品内容表
     *
     * @param map
     * @return
     */
    public List<ProductContentDto> findAll();
    /**
   	 * 添加商品
   	 * @param 
   	 * @return
   	 */
   	public int add(Shop_Content shop_Content);
   	/**
     * 修改商品内容
     *
     * @param 
     * @return
     */
    public int update(Map<String, Object> map);
    /**
     * 删除商品角色
     *
     * @param 
     * @return
     */
    public int delete(Shop_Content shop_Content);
   	
}
