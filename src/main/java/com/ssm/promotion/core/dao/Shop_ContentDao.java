package com.ssm.promotion.core.dao;

import java.util.List;
import java.util.Map;

import com.ssm.promotion.core.dto.ProductPaperDto;
import com.ssm.promotion.core.dto.ProductQuestionBankDto;
import com.ssm.promotion.core.dto.ProductVideoCategoryDto;
import com.ssm.promotion.core.entity.Role_Fathermenu;
import com.ssm.promotion.core.entity.SRole;
import com.ssm.promotion.core.entity.Shop_Content;

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
	public Shop_Content findByContentId(int contentId,String type);
	 /**
     * 查找商品题库
     *
     * @param map
     * @return
     */
    public List<ProductQuestionBankDto> findProductQuestionBank();
    /**
     * 查找商品试卷
     *
     * @param map
     * @return
     */
    public List<ProductPaperDto> findProductPaper();
    /**
     * 查找商品视频类目
     *
     * @param map
     * @return
     */
    public List<ProductVideoCategoryDto> findProductVideoCategory();
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
    public int delete2(Shop_Content shop_Content);


}
