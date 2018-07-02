package com.ssm.promotion.core.service;

import java.util.List;
import java.util.Map;

import com.ssm.promotion.core.entity.Product;



public interface ProductService {

	  /**
     * 查找用户列表
     *
     * @param map
     * @return
     */
    public List<Product> findProduct(Map<String, Object> map);

    /**
     * @param map
     * @return
     */
    public Long getTotalProduct(Map<String, Object> map);

    /**
     * 更新
     *
     * @param 
     * @return
     */
    public int updateProduct(Product product);

    /**
     * 添加用户
     *
     * @param 
     * @return
     */
    public int addProduct(Product product);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    public int deleteProduct(Integer productId);
    
    /**
     * 根据用户名获取用户
     * @param 
     * @return
     */
    Product getProductByName(String productName);
    
    /**
     * 根据id获取用户
     * @param 
     * @return
     */
    Product getProductById(Integer productId);
    
}
    
