package com.ssm.promotion.core.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.promotion.core.dao.Role_FathermenuDao;
import com.ssm.promotion.core.dao.Shop_ContentDao;
import com.ssm.promotion.core.dto.ProductContentDto;
import com.ssm.promotion.core.dto.ProductPaperDto;
import com.ssm.promotion.core.dto.ProductQuestionBankDto;
import com.ssm.promotion.core.dto.ProductVideoCategoryDto;
import com.ssm.promotion.core.entity.Shop_Content;
import com.ssm.promotion.core.service.Shop_ContentService;
/**
 * @author 刘家霖
 * @project_name perfect-ssm
 * @date 2018-7-3
 */
@Service("shop_ContentService")
public class Shop_ContentServiceImpl implements Shop_ContentService {
	@Resource
	 private Shop_ContentDao shop_ContentDao;
	@Override
	//查询题库  视频类目  试卷 
	public List<ProductContentDto> findAll() {
		List<ProductContentDto> productContentDtos=new ArrayList<ProductContentDto>();
		List<ProductQuestionBankDto> listProductQuestionBankDtos = shop_ContentDao.findProductQuestionBank();//查找类型为题库
		List<ProductPaperDto> listProductPaperDtos = shop_ContentDao.findProductPaper();//查询类型为试卷
		List<ProductVideoCategoryDto> listVideoCategoryDtos = shop_ContentDao.findProductVideoCategory();//查询类型为视频类目的
		for (ProductQuestionBankDto productQuestionBankDto : listProductQuestionBankDtos) {
			ProductContentDto productContentDto=new ProductContentDto();
			productContentDto.setContentId(productQuestionBankDto.getContentId());
			productContentDto.setContentName(productQuestionBankDto.getQuestionBank().getQuestionBankName());
			productContentDto.setProductId(productQuestionBankDto.getProductId());
			productContentDto.setProductName(productQuestionBankDto.getProductName());
			productContentDto.setType(productQuestionBankDto.getType());
			productContentDtos.add(productContentDto);
			
		}
		for (ProductPaperDto productPaperDto : listProductPaperDtos) {
			ProductContentDto productContentDto=new ProductContentDto();
			productContentDto.setContentId(productPaperDto.getContentId());
			productContentDto.setContentName(productPaperDto.getPaper().getPaperName());
			productContentDto.setProductId(productPaperDto.getProductId());
			productContentDto.setProductName(productPaperDto.getProductName());
			productContentDto.setType(productPaperDto.getType());
			productContentDtos.add(productContentDto);
		}
		for (ProductVideoCategoryDto productVideoCategoryDto : listVideoCategoryDtos) {
			ProductContentDto productContentDto=new ProductContentDto();
			productContentDto.setContentId(productVideoCategoryDto.getContentId());
			productContentDto.setContentName(productVideoCategoryDto.getVideoCategory().getVideoCategoryName());
			productContentDto.setProductId(productVideoCategoryDto.getProductId());
			productContentDto.setProductName(productVideoCategoryDto.getProductName());
			productContentDto.setType(productVideoCategoryDto.getType());
			productContentDtos.add(productContentDto);
		}
		for(int i=0;i<productContentDtos.size();i++){
			productContentDtos.get(i).setProductContentID(i+1);
		}
		return productContentDtos;
	}
	@Override
	public int add(Shop_Content shop_Content) {
		// TODO Auto-generated method stub
		return shop_ContentDao.add(shop_Content);
	}
	@Override
	public int update(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return shop_ContentDao.update(map);
	}
	@Override
	public int delete(Shop_Content shop_Content) {
		// TODO Auto-generated method stub
		return shop_ContentDao.delete2(shop_Content);
	}
	
	
   
}
