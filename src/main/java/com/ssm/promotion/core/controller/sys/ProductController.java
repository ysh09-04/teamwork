package com.ssm.promotion.core.controller.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.promotion.core.common.Constants;
import com.ssm.promotion.core.common.Result;
import com.ssm.promotion.core.common.ResultGenerator;
import com.ssm.promotion.core.entity.PageBean;
import com.ssm.promotion.core.entity.Product;
import com.ssm.promotion.core.entity.SUser;

import com.ssm.promotion.core.service.ProductService;

import com.ssm.promotion.core.util.MD5Util;
import com.ssm.promotion.core.util.ResponseUtil;
import com.ssm.promotion.core.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author 1034683568@qq.com
 * @project_name perfect-ssm
 * @date 2017-3-1
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	@Resource
	private ProductService productService;
	
	@RequestMapping("/product")
	public String product() {
		return "product/productmanage";
	}
	
	/**
	 * 增加
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value ="", method = RequestMethod.POST)
	@ResponseBody
	public Result save(@RequestBody Product product) throws Exception {
		int resultTotal = 0;
		resultTotal = productService.addProduct(product);
		if (resultTotal > 0) {
			return ResultGenerator.genSuccessResult();
		} else {
			return ResultGenerator.genFailResult("FAIL");
		}
	}
	
		/**
		 * 用户查询
		 * @return
		 */
		
	

		/**
		 * 分页功能
		 * @param page
		 * @param rows
		 * @return
		 * @throws Exception 
		 */
		
		@RequestMapping("/datagrid")
		@ResponseBody
		public List<Product> findProduct(@Param("page") String page,
				@Param("rows") String rows,
				Product product,HttpServletResponse response) throws Exception{
			PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("productName", StringUtil.formatLike(product.getProductName()));
			map.put("start", pageBean.getStart());
			map.put("size", pageBean.getPageSize());
			List<Product> listProduct = productService.findProduct(map);
			Long total = productService.getTotalProduct(map);
			JSONObject result = new JSONObject();
			JSONArray jsonArray = JSONArray.fromObject(listProduct);
			result.put("rows", jsonArray);
			result.put("total", total);
			ResponseUtil.write(response, result);
			return null;
		}
		/**
		 * 删除
		 * @param ids
		 * @return
		 */
		@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
		@ResponseBody
		public Result deleteProduct(@PathVariable(value = "ids") String ids){
			String[] productIds=ids.split(",");
			int resultTotal=0;
			for (int i = 0; i < productIds.length; i++) {
				resultTotal=productService.deleteProduct(Integer.parseInt(productIds[i]));
				
			}
			if (resultTotal > 0) {
				return ResultGenerator.genSuccessResult();
			} else {
				return ResultGenerator.genFailResult("FAIL");
			}
		}
	
	@RequestMapping(value="",method=RequestMethod.PUT)
	@ResponseBody
	public Result updateProduct(@RequestBody Product product){
		
		int resultTotal = 0;
		resultTotal = productService.updateProduct(product);
		if (resultTotal > 0) {
			return ResultGenerator.genSuccessResult();
		} else {
			return ResultGenerator.genFailResult("FAIL");
		}
	}
	/**
	 * 查询全部
	 * 
	 * @param 
	 * @return
	 * @throws 
	 */
	@RequestMapping("findAll")
	@ResponseBody
	public List<Product> findAll(){
		List<Product> listpProducts= productService.findAll();
		return listpProducts;
	}
}
