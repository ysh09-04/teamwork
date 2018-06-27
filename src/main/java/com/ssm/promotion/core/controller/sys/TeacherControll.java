package com.ssm.promotion.core.controller.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.promotion.core.common.Result;
import com.ssm.promotion.core.common.ResultGenerator;
import com.ssm.promotion.core.entity.PageBean;
import com.ssm.promotion.core.entity.Teacher;
import com.ssm.promotion.core.service.TeacherService;
import com.ssm.promotion.core.util.ResponseUtil;
import com.ssm.promotion.core.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 教师
 * @author 尤少辉
 * @日期 2018年6月27日
 */
@Controller
@RequestMapping("/teacher")
public class TeacherControll {
	
	@Resource
	private TeacherService teacherService;
	
	private static final Logger log = Logger.getLogger(UserController.class);// 日志文件
	
	/**
	 * 前往教师主界面
	 * @return
	 */
	@RequestMapping("/tofindAll")
	public String tofindAll(){
		return "teacher/teacherManage";
	}
	/**
	 * 分页查询
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public String findAll(
			@RequestParam(value="page",required=false )String page,
			@RequestParam(value="rows",required=false )String rows,
			Teacher teacher,HttpServletResponse response) throws Exception{
		PageBean pageBean = new PageBean(Integer.parseInt(page),
				Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tname", StringUtil.formatLike(teacher.getTname()));
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<Teacher> teachers=teacherService.findAll(map);
		Long total = (long) teacherService.findAllCount(map);
		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(teachers);
		result.put("rows", jsonArray);
		result.put("total", total);
		log.info("request: user/list , map: " + map.toString());
		ResponseUtil.write(response, result);
		return null;
	}
	/**
	 * 添加
	 * @return
	 */
	@RequestMapping(value="",method=RequestMethod.POST)
	@ResponseBody
	public Result save(@RequestBody Teacher teacher){
		int count=0;
		count=teacherService.save(teacher);
		if(count>0){
			return ResultGenerator.genSuccessResult();
		}else{
			return ResultGenerator.genFailResult("FAIL");
		}
		
	}
	/**
	 * 添加
	 * @return
	 */
	@RequestMapping(value="",method=RequestMethod.PUT)
	@ResponseBody
	public Result update(@RequestBody Teacher teacher){
		int count=0;
		count=teacherService.update(teacher);
		if(count>0){
			return ResultGenerator.genSuccessResult();
		}else{
			return ResultGenerator.genFailResult("FAIL");
		}
	}
	/**
	 * 删除
	 * @return
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@ResponseBody
	public Result delete(@PathVariable(value = "ids") String ids){
		if (ids.length() > 20) {
			return ResultGenerator.genFailResult("ERROR");
		}
		String[] idsStr = ids.split(",");
		for (int i = 0; i < idsStr.length; i++) {
			teacherService.delete(Integer.valueOf(idsStr[i]));
		}
		log.info("request: article/delete , ids: " + ids);
		return ResultGenerator.genSuccessResult();
	}
}
