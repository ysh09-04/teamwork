package com.ssm.promotion.core.controller.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.promotion.core.common.Result;
import com.ssm.promotion.core.common.ResultGenerator;
import com.ssm.promotion.core.dto.OrderTUserDto;
import com.ssm.promotion.core.dto.QuestionbankCourseDto;
import com.ssm.promotion.core.entity.PageBean;
import com.ssm.promotion.core.entity.QuestionBank;
import com.ssm.promotion.core.entity.TOrder;
import com.ssm.promotion.core.service.OrderService;
import com.ssm.promotion.core.service.QuestionBankService;
import com.ssm.promotion.core.util.ResponseUtil;
import com.ssm.promotion.core.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/order")
public class OrderControll {
	@Resource
	private OrderService orderService;
	
	//跳转
			@RequestMapping("/order")
			public String Order(){
				return "order/orderManage";
				
			}
			//查找所有角色
			@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
			public String list(
					@RequestParam(value = "page", required = false) String page,
					@RequestParam(value = "rows", required = false) String rows,
					OrderTUserDto orderTUserDto, HttpServletResponse response) throws Exception {
				PageBean pageBean = new PageBean(Integer.parseInt(page),
						Integer.parseInt(rows));
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("state", StringUtil.formatLike(orderTUserDto.getState()));
				map.put("start", pageBean.getStart());
				map.put("size", pageBean.getPageSize());
				List<OrderTUserDto> listOrderTUserDtos = orderService.findPage(map);
				Long total = orderService.getTotal(map);
				JSONObject result = new JSONObject();
				JSONArray jsonArray = JSONArray.fromObject(listOrderTUserDtos);
				result.put("rows", jsonArray);
				result.put("total", total);
				
				ResponseUtil.write(response, result);
				return null;
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
			public Result update(@RequestBody TOrder tOrder) throws Exception {
				
				
				int resultTotal = orderService.update(tOrder);
				if (resultTotal > 0) {
					return ResultGenerator.genSuccessResult();
				} else {
					return ResultGenerator.genFailResult("FAIL");
				}
			}
}
