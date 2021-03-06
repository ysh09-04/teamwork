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
import com.ssm.promotion.core.dto.QuestionbankCourseDto;
import com.ssm.promotion.core.entity.PageBean;
import com.ssm.promotion.core.entity.QuestionBank;
import com.ssm.promotion.core.service.QuestionBankService;
import com.ssm.promotion.core.util.ResponseUtil;
import com.ssm.promotion.core.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/questionBank")
public class QuestionBankControll {
	@Resource
	private QuestionBankService questionBankService;
	
	//跳转
		@RequestMapping("/questionBank")
		public String questionBank(){
			return "questionbank/questionbankManage";
			
		}
		//查找所有角色
		@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
		public String list(
				@RequestParam(value = "page", required = false) String page,
				@RequestParam(value = "rows", required = false) String rows,
				QuestionBank questionBank, HttpServletResponse response) throws Exception {
			PageBean pageBean = new PageBean(Integer.parseInt(page),
					Integer.parseInt(rows));
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("questionBankName", StringUtil.formatLike(questionBank.getQuestionBankName()));
			map.put("start", pageBean.getStart());
			map.put("size", pageBean.getPageSize());
			List<QuestionbankCourseDto> questionbankCourseDtos = questionBankService.findAll(map);
			Long total = questionBankService.getTotalQuestionbank(map);
			JSONObject result = new JSONObject();
			JSONArray jsonArray = JSONArray.fromObject(questionbankCourseDtos);
			result.put("rows", jsonArray);
			result.put("total", total);
			
			ResponseUtil.write(response, result);
			return null;
		}
		/**
		 * 添加角色
		 * 
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value = "/add", method = RequestMethod.POST)
		@ResponseBody
		public Result save(@RequestBody QuestionBank questionBank) throws Exception {
			int resultTotal = 0;
			resultTotal = questionBankService.add(questionBank);
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
		public Result update(@RequestBody QuestionBank questionBank) throws Exception {
			
			
			int resultTotal = questionBankService.update(questionBank);
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
		public Result delete(int questionBankId)
				throws Exception {		
			
			int resultTotal=questionBankService.delete(questionBankId);	
			if (resultTotal > 0) {
				return ResultGenerator.genSuccessResult();
			} else {
				return ResultGenerator.genFailResult("FAIL");
			}
		}
		/**
		 * 用于ajax加载数据
		 * @return
		 */
		@RequestMapping("linkbutton")
		@ResponseBody
		public List<QuestionBank> linkbutton(){
			return questionBankService.findAllIdAndName();
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
		public List<QuestionBank> findAll(){
			List<QuestionBank> listQuestionBanks= questionBankService.findAll2();
			return listQuestionBanks;
		}
}
