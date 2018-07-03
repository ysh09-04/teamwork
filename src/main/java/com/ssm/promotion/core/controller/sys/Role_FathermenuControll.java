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
import com.ssm.promotion.core.dto.QuestionbankCourseDto;
import com.ssm.promotion.core.dto.RoleFathermenuDto;
import com.ssm.promotion.core.entity.PageBean;
import com.ssm.promotion.core.entity.QuestionBank;
import com.ssm.promotion.core.entity.Role_Fathermenu;
import com.ssm.promotion.core.entity.SRole;
import com.ssm.promotion.core.service.Role_FathermenuService;
import com.ssm.promotion.core.util.ResponseUtil;
import com.ssm.promotion.core.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/Role_Fathermenu")
public class Role_FathermenuControll {
	@Resource
	private Role_FathermenuService role_FathermenuService;
	//跳转
			@RequestMapping("/Role_Fathermenu")
			public String Role_Fathermenu(){
				return "role_fathermenu/role_fathermenuManage";
				
			}
			//查找所有角色
			@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
			public String list(
					@RequestParam(value = "page", required = false) String page,
					@RequestParam(value = "rows", required = false) String rows,
					RoleFathermenuDto roleFathermenuDto, HttpServletResponse response,HttpServletRequest request) throws Exception {
				PageBean pageBean = new PageBean(Integer.parseInt(page),
						Integer.parseInt(rows));
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("roleName", StringUtil.formatLike(roleFathermenuDto.getRoleName()));
				map.put("start", pageBean.getStart());
				map.put("size", pageBean.getPageSize());
				List<RoleFathermenuDto> roleFathermenuDtos = role_FathermenuService.findAll(map);
				request.getSession().setAttribute("roleFathermenuDtos", roleFathermenuDtos);
				Long total = role_FathermenuService.getTotalRole_Fathermenu(map);
				JSONObject result = new JSONObject();
				JSONArray jsonArray = JSONArray.fromObject(roleFathermenuDtos);
				result.put("rows", jsonArray);
				result.put("total", total);
				
				ResponseUtil.write(response, result);
				return null;
			}
			/**
			 * 添加角色父菜单表
			 * 
			 * @return
			 * @throws Exception
			 */
			@RequestMapping(value = "/add", method = RequestMethod.POST)
			@ResponseBody
			public Result save(@RequestBody Role_Fathermenu role_Fathermenu) throws Exception {
				int resultTotal = 0;
				resultTotal = role_FathermenuService.add(role_Fathermenu);
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
			public Result update(@RequestBody RoleFathermenuDto role_Fathermenu,HttpServletRequest request) throws Exception {
				Map<String, Integer> map=new HashMap<String, Integer>();
				List<RoleFathermenuDto> roleFathermenuDtos= (List<RoleFathermenuDto>) request.getSession().getAttribute("roleFathermenuDtos");
				for (RoleFathermenuDto roleFathermenuDto : roleFathermenuDtos) {
					if(roleFathermenuDto.getRole_fatherMenuId()==role_Fathermenu.getRole_fatherMenuId()){
						map.put("oldroleId", roleFathermenuDto.getRoleId());
						map.put("oldFatherMenu", roleFathermenuDto.getFatherMenuId());
					}
				}
				map.put("roleId", role_Fathermenu.getRoleId());
				map.put("fatherMenuId", role_Fathermenu.getFatherMenuId());
				int resultTotal = role_FathermenuService.update(map);
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
			public Result delete(Role_Fathermenu role_Fathermenu)
					throws Exception {		
				role_FathermenuService.delete(role_Fathermenu);			
				return ResultGenerator.genSuccessResult();
			}
}
