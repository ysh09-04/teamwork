package com.ssm.promotion.core.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.promotion.core.dao.ProductDao;
import com.ssm.promotion.core.entity.Product;
import com.ssm.promotion.core.service.ProductService;


@Service("productService")
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<Product> findProduct(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return productDao.findProduct(map);
	}

	@Override
	public Long getTotalProduct(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return productDao.getTotalProduct(map);
	}

	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.updateProduct(product);
	}

	@Override
	public int addProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.addProduct(product);
	}

	@Override
	public int deleteProduct(Integer productId) {
		// TODO Auto-generated method stub
		return productDao.deleteProduct(productId);
	}

	@Override
	public Product getProductByName(String productName) {
		// TODO Auto-generated method stub
		return productDao.getProductByName(productName);
	}

	@Override
	public Product getProductById(Integer productId) {
		// TODO Auto-generated method stub
		return productDao.getProductById(productId);
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

}
