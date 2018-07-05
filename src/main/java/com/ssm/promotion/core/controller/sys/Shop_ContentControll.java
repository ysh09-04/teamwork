package com.ssm.promotion.core.controller.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.promotion.core.common.Result;
import com.ssm.promotion.core.common.ResultGenerator;
import com.ssm.promotion.core.dto.ProductContentDto;
import com.ssm.promotion.core.dto.RoleFathermenuDto;
import com.ssm.promotion.core.entity.PageBean;
import com.ssm.promotion.core.entity.Role_Fathermenu;
import com.ssm.promotion.core.entity.SRole;
import com.ssm.promotion.core.service.RoleService;
import com.ssm.promotion.core.service.Shop_ContentService;
import com.ssm.promotion.core.util.ResponseUtil;
import com.ssm.promotion.core.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.ssm.promotion.core.entity.Shop_Content;

@Controller
@RequestMapping("/shop_content")
public class Shop_ContentControll {
	@Resource
	private Shop_ContentService shop_ContentService;

	//跳转
	@RequestMapping("/shop_content")
	public String Shop_Content(){
		return "shop_content/shop_contentManage";

	}
	//查询全部
	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public List<ProductContentDto> list(
		ProductContentDto productContentDto, HttpServletRequest request) throws Exception {						
		List<ProductContentDto> listProductContentDtos = shop_ContentService.findAll();
		request.getSession().setAttribute("listProductContentDtos", listProductContentDtos);
		return listProductContentDtos;
	}
	/**
	 * 添加角色
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Result save(@RequestBody Shop_Content shop_Content) throws Exception {
		int resultTotal = 0;
		resultTotal = shop_ContentService.add(shop_Content);
		if (resultTotal > 0) {
			return ResultGenerator.genSuccessResult();
		} else {
			return ResultGenerator.genFailResult("FAIL");
		}
	}
	/**
	 * 修改
	 * 
	 * @param 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Result update(@RequestBody ProductContentDto productContent,HttpServletRequest request) throws Exception {
		Map<String, Object> map=new HashMap<String, Object>();
		List<ProductContentDto> productContentDtos= (List<ProductContentDto>) request.getSession().getAttribute("listProductContentDtos");
		for (ProductContentDto productContentDto : productContentDtos) {
			if(productContentDto.getProductContentID()== productContent.getProductContentID()){
				map.put("oldproductId", productContentDto.getProductId());
				map.put("oldtype", productContentDto.getType());
				map.put("oldcontentId", productContentDto.getContentId());
				
			}
		}
		
		map.put("productId", productContent.getProductId());
		map.put("type", productContent.getType());
		map.put("contentId", productContent.getContentId());
		int resultTotal = shop_ContentService.update(map);
		if (resultTotal > 0) {
			return ResultGenerator.genSuccessResult();
		} else {
			return ResultGenerator.genFailResult("FAIL");
		}
	}
	/**
	 * 删除
	 * 
	 * @param 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Result delete(Shop_Content shop_Content)
			throws Exception {		
		shop_ContentService.delete(shop_Content);		
		return ResultGenerator.genSuccessResult();
	}
}
