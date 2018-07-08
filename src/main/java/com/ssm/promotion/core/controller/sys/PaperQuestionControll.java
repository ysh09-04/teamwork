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
import com.ssm.promotion.core.dto.PaperQuestionDto;
import com.ssm.promotion.core.dto.QuestionbankCourseDto;
import com.ssm.promotion.core.entity.PageBean;
import com.ssm.promotion.core.entity.PaperQuestion;
import com.ssm.promotion.core.entity.QuestionBank;
import com.ssm.promotion.core.service.PaperQuestionService;
import com.ssm.promotion.core.service.QuestionBankService;
import com.ssm.promotion.core.util.ResponseUtil;
import com.ssm.promotion.core.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/paperquestion")
public class PaperQuestionControll {
	@Resource
	private PaperQuestionService paperQuestionService;
	//跳转
			@RequestMapping("/paperquestion")
			public String Paperquestion(){
				return "paperquestion/paperquestionManage";
				
			}
			//查找所有角色
			@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
			public String list(
					@RequestParam(value = "page", required = false) String page,
					@RequestParam(value = "rows", required = false) String rows,
					PaperQuestionDto paperQuestionDto, HttpServletResponse response) throws Exception {
				PageBean pageBean = new PageBean(Integer.parseInt(page),
						Integer.parseInt(rows));
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("paperId",paperQuestionDto.getPaperId());
				map.put("start", pageBean.getStart());
				map.put("size", pageBean.getPageSize());
				List<PaperQuestionDto> listPaperQuestionDtos = paperQuestionService.findAll(map);
				Long total = paperQuestionService.getTotal(map);
				JSONObject result = new JSONObject();
				JSONArray jsonArray = JSONArray.fromObject(listPaperQuestionDtos);
				result.put("rows", jsonArray);
				result.put("total", total);
				
				ResponseUtil.write(response, result);
				return null;
			}
			/**
			 * 添加
			 * 
			 * @return
			 * @throws Exception
			 */
			@RequestMapping(value = "/add", method = RequestMethod.POST)
			@ResponseBody
			public Result save(@RequestBody PaperQuestion paperQuestion) throws Exception {
				int resultTotal = 0;
				resultTotal = paperQuestionService.add(paperQuestion);
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
			public Result update(@RequestBody PaperQuestion paperQuestion) throws Exception {
				
				
				int resultTotal = paperQuestionService.update(paperQuestion);
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
			public Result delete(PaperQuestion paperQuestion)
					throws Exception {		
				
				int resultTotal=paperQuestionService.delete2(paperQuestion);
				if (resultTotal > 0) {
					return ResultGenerator.genSuccessResult();
				} else {
					return ResultGenerator.genFailResult("FAIL");
				}
			}
}
