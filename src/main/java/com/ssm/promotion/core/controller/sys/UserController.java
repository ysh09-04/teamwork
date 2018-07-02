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
import com.ssm.promotion.core.entity.SUser;

import com.ssm.promotion.core.service.UserService;
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
		return "user/usermanage";
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
	@RequestMapping(value ="", method = RequestMethod.POST)
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
	
		/**
		 * 用户查询
		 * @return
		 */
		
		@RequestMapping("/findSuser")
		public String findSuser(){
			return "user/usermanage";
		}

		/**
		 * datagrid��ҳ�������ݵķ���
		 * @param page
		 * @param rows
		 * @return
		 * @throws Exception 
		 */
		
		@RequestMapping("/datagrid")
		@ResponseBody
		public List<SUser> findSuser(@Param("page") int page,
				@Param("rows") int rows,
				SUser user,HttpServletResponse response) throws Exception{
			PageBean pageBean = new PageBean(page,rows);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userName", StringUtil.formatLike(user.getUserName()));
			map.put("start", pageBean.getStart());
			map.put("size", pageBean.getPageSize());
			List<SUser> listUser = userService.findSUser(map);
			Long total = userService.getTotalSUser(map);
			JSONObject result = new JSONObject();
			JSONArray jsonArray = JSONArray.fromObject(listUser);
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
		public Result deleteSUser(@PathVariable(value = "ids") String ids){
			String[] userIds=ids.split(",");
			int resultTotal=0;
			for (int i = 0; i < userIds.length; i++) {
				resultTotal=userService.deleteSUser(Integer.parseInt(userIds[i]));
			}
			if (resultTotal > 0) {
				return ResultGenerator.genSuccessResult();
			} else {
				return ResultGenerator.genFailResult("FAIL");
			}
		}
	
	@RequestMapping(value="",method=RequestMethod.PUT)
	@ResponseBody
	public Result updateTeacher(@RequestBody SUser user){
		
		int resultTotal = 0;
		resultTotal = userService.updateSUser(user);
		if (resultTotal > 0) {
			return ResultGenerator.genSuccessResult();
		} else {
			return ResultGenerator.genFailResult("FAIL");
		}
	}
	
}
