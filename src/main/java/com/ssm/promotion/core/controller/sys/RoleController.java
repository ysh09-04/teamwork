package com.ssm.promotion.core.controller.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.ssm.promotion.core.entity.SRole;
import com.ssm.promotion.core.service.RoleService;
import com.ssm.promotion.core.util.ResponseUtil;
import com.ssm.promotion.core.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Resource
	private RoleService roleService;

	
	
 //跳转
	@RequestMapping("/role")
	public String role(){
		return "role/roleManage";
		
	}
	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	public String list(
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows,
			SRole sRole, HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page),
				Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName", StringUtil.formatLike(sRole.getRoleName()));
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<SRole> roleList = roleService.findRole(map);
		Long total = roleService.getTotalRole(map);
		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(roleList);
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
	public Result save(@RequestBody SRole sRole) throws Exception {
		int resultTotal = 0;
		resultTotal = roleService.addSRole(sRole);
		if (resultTotal > 0) {
			return ResultGenerator.genSuccessResult();
		} else {
			return ResultGenerator.genFailResult("FAIL");
		}
	}
	/**
	 * 修改
	 * 
	 * @param srole
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Result update(@RequestBody SRole sRole) throws Exception {
		
		
		int resultTotal = roleService.updateSRole(sRole);		
		if (resultTotal > 0) {
			return ResultGenerator.genSuccessResult();
		} else {
			return ResultGenerator.genFailResult("FAIL");
		}
	}
	/**
	 * 删除管理员
	 * 
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Result delete(Integer roleId)
			throws Exception {		
		roleService.deleteSRole(roleId);			
		return ResultGenerator.genSuccessResult();
	}
}
