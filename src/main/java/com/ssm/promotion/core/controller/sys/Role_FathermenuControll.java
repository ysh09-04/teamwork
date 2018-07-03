package com.ssm.promotion.core.controller.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssm.promotion.core.dto.QuestionbankCourseDto;
import com.ssm.promotion.core.dto.RoleFathermenuDto;
import com.ssm.promotion.core.entity.PageBean;
import com.ssm.promotion.core.entity.QuestionBank;
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
					RoleFathermenuDto roleFathermenuDto, HttpServletResponse response) throws Exception {
				PageBean pageBean = new PageBean(Integer.parseInt(page),
						Integer.parseInt(rows));
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("roleName", StringUtil.formatLike(roleFathermenuDto.getRoleName()));
				map.put("start", pageBean.getStart());
				map.put("size", pageBean.getPageSize());
				List<RoleFathermenuDto> roleFathermenuDtos = role_FathermenuService.findAll(map);
				Long total = role_FathermenuService.getTotalRole_Fathermenu(map);
				JSONObject result = new JSONObject();
				JSONArray jsonArray = JSONArray.fromObject(roleFathermenuDtos);
				result.put("rows", jsonArray);
				result.put("total", total);
				
				ResponseUtil.write(response, result);
				return null;
			}
}
