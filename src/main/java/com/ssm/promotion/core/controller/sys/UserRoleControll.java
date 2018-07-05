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

import com.ssm.promotion.core.dto.UserRoleDto;
import com.ssm.promotion.core.entity.PageBean;
import com.ssm.promotion.core.entity.UserRole;
import com.ssm.promotion.core.service.UserRoleService;
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
@RequestMapping("/UserRole")
public class UserRoleControll {
	@Resource
	private UserRoleService userRoleService;
	
	//跳转
			@RequestMapping("/UserRole")
			public String UserRole(){
				return "userrole/userroleManage";
				
			}
			//查找所有角色
			@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
			public String list(
					@RequestParam(value = "page", required = false) String page,
					@RequestParam(value = "rows", required = false) String rows,
					UserRoleDto userRoleDto, HttpServletResponse response,HttpServletRequest request) throws Exception {
				PageBean pageBean = new PageBean(Integer.parseInt(page),
						Integer.parseInt(rows));
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("userName", StringUtil.formatLike(userRoleDto.getUserName()));
				map.put("start", pageBean.getStart());
				map.put("size", pageBean.getPageSize());
				List<UserRoleDto> userRoleDtos = userRoleService.findAll(map);
				request.getSession().setAttribute("userRoleDtos", userRoleDtos);
				Long total = userRoleService.getTotalUserRole(map);
				JSONObject result = new JSONObject();
				JSONArray jsonArray = JSONArray.fromObject(userRoleDtos);
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
			public Result save(@RequestBody UserRole userRole) throws Exception {
				int resultTotal = 0;
				resultTotal = userRoleService.add(userRole);
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
			public Result update(@RequestBody UserRoleDto userRole,HttpServletRequest request) throws Exception {
				Map<String, Integer> map=new HashMap<String, Integer>();
				List<UserRoleDto> userRoleDtos= (List<UserRoleDto>) request.getSession().getAttribute("userRoleDtos");
				for (UserRoleDto userRoleDto : userRoleDtos) {
					if(userRoleDto.getUser_roleId()==userRole.getUser_roleId()){
						map.put("olduserId", userRoleDto.getUserId());
						map.put("oldroleId", userRoleDto.getRoleId());
					}
				}
				map.put("userId", userRole.getUserId());
				map.put("roleId", userRole.getRoleId());
				int resultTotal = userRoleService.update(map);
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
			public Result delete(UserRole userRole)
					throws Exception {		
				userRoleService.delete(userRole);			
				return ResultGenerator.genSuccessResult();
			}
}
