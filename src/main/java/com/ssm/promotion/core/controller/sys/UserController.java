package com.ssm.promotion.core.controller.sys;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.promotion.core.common.Constants;
import com.ssm.promotion.core.common.Result;
import com.ssm.promotion.core.common.ResultGenerator;
import com.ssm.promotion.core.entity.SUser;
import com.ssm.promotion.core.service.UserService;
import com.ssm.promotion.core.util.MD5Util;

/**
 * @author 1034683568@qq.com
 * @project_name perfect-ssm
 * @date 2017-3-1
 */
@Controller
@RequestMapping("/users")
public class UserController {

	@Resource
	private UserService userService;
	/**
	 * 登录
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	@ResponseBody
	public Result login(SUser user, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();;
		SUser sUser= userService.getUserByName(user.getUserName());
		String MD5pwd = MD5Util.MD5Encode(user.getPassword(), "UTF-8");
		System.out.println(MD5pwd);
		if(sUser.getPassword().equals(MD5pwd)){
			Map data = new HashMap();
			session.setAttribute(Constants.SESSION_USER, sUser);
			data.put("currentUser", sUser);
			return ResultGenerator.genSuccessResult(data);
		}
		return ResultGenerator.genFailResult("账号状态异常，请联系管理员。");
	}

	

	/**
	 * 跳转tab
	 * 
	 * @return
	 */
	@RequestMapping("/list")
	public String index() {
		return "user/userManage";
	}
	/**
	 * 跳转tab
	 * 
	 * @return
	 */
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	/**
	 * 添加或修改管理员
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Result save(@RequestBody SUser user) throws Exception {
		int resultTotal = 0;
		resultTotal = userService.addUser(user);
		if (resultTotal > 0) {
			return ResultGenerator.genSuccessResult();
		} else {
			return ResultGenerator.genFailResult("FAIL");
		}
	}
	
}
