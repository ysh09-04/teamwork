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

import com.ssm.promotion.core.common.Constants;
import com.ssm.promotion.core.common.Result;
import com.ssm.promotion.core.common.ResultGenerator;
import com.ssm.promotion.core.dto.TuserCourseAndTuserAndCourseDto;
import com.ssm.promotion.core.entity.PageBean;
import com.ssm.promotion.core.entity.SUser;
import com.ssm.promotion.core.entity.TUser;
import com.ssm.promotion.core.entity.UserCourse;
import com.ssm.promotion.core.service.UserCourseService;
import com.ssm.promotion.core.util.ResponseUtil;
import com.ssm.promotion.core.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 
 * @author huangping
 *
 */
@Controller
@RequestMapping("/UserCourse")
public class UserCourseControll {
	@Resource
	private UserCourseService userCourseService;

	//跳转
	@RequestMapping("/UserCourse")
	public String UserCourse(){
		return "userCourse/usercourseManage";

	}
	//查找所有角色
	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	public String list(
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows,
			TUser tUser, HttpServletResponse response,HttpServletRequest request) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page),
				Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName", StringUtil.formatLike(tUser.getUserName()));
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<TuserCourseAndTuserAndCourseDto> userCourseDtos = userCourseService.findAll(map);
		request.getSession().setAttribute("userCourseDtos", userCourseDtos);
		Long total = userCourseService.getTotalUserCourse(map);
		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(userCourseDtos);
		result.put("rows", jsonArray);
		result.put("total", total);

		ResponseUtil.write(response, result);
		return null;
	}
	/**
	 * 修改
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/update")
	@ResponseBody
	public Result update(@RequestBody UserCourse userCourse,HttpServletRequest request) throws Exception {
		SUser tUser = (SUser)request.getSession().getAttribute(Constants.SESSION_USER);
		if("正常".equals(userCourse.getCourseState())){
			userCourse.setCourseState("停封");
		}else{
			userCourse.setCourseState("正常");
		}
		userCourse.setLastSystemOperatorId(tUser.getUserId());
		int resultTotal = userCourseService.updateStateAndastIdById(userCourse);
		if (resultTotal > 0) {
			return ResultGenerator.genSuccessResult();
		} else {
			return ResultGenerator.genFailResult("FAIL");
		}
	}
}
