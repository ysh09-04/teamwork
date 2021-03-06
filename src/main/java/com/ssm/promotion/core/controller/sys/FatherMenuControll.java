package com.ssm.promotion.core.controller.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.promotion.core.common.Constants;
import com.ssm.promotion.core.common.Result;
import com.ssm.promotion.core.common.ResultGenerator;
import com.ssm.promotion.core.entity.FatherMenu;
import com.ssm.promotion.core.entity.PageBean;
import com.ssm.promotion.core.entity.SUser;
import com.ssm.promotion.core.service.FatherMenuService;
import com.ssm.promotion.core.util.ResponseUtil;
import com.ssm.promotion.core.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 父菜单
 * @author 尤少辉
 * @日期 2018年6月30日
 */
@Controller
@RequestMapping("/fatherMenu")
public class FatherMenuControll {
	@Autowired
	private FatherMenuService fatherMenuService;
	private static final Logger log = Logger.getLogger(UserController.class);// 日志文件
	
	/**
	 * 跳转到菜单
	 * @return
	 */
	@RequestMapping("toFatherMenu")
	public String toFatherMenu(){
		return "menu/fatherMenuManage";
	}
	/**
	 * 查询全部的id和父菜单名
	 * @return
	 */
	@RequestMapping("linkbutton")
	@ResponseBody
	public List<FatherMenu> linkbutton(){
		List<FatherMenu> fatherMenus= fatherMenuService.findAllIdAndName();
		return fatherMenus;
	}
	/**
	 * 模糊查询和查询全部
	 * @param page
	 * @param rows
	 * @param searchMenu
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("datagrid")
	@ResponseBody
	public String datagrid(
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows,
			FatherMenu searchMenu,HttpServletResponse response) throws Exception{
		PageBean pageBean = new PageBean(Integer.parseInt(page),
				Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("menuName", StringUtil.formatLike(searchMenu.getMenuName()));
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<FatherMenu> fatherMenus = fatherMenuService.findByFatherMenuOrAll(map);
		Long total = (long) fatherMenuService.findByFatherMenuOrAllCount((String)(map.get("menuName")));
		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(fatherMenus);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 添加或修改父菜单
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Result save(@RequestBody FatherMenu fatherMenu,HttpServletRequest request) throws Exception {
		SUser user =(SUser) request.getSession().getAttribute(Constants.SESSION_USER);
		int resultTotal = 0;
		resultTotal = fatherMenuService.save(fatherMenu,user);
		if (resultTotal > 0) {
			return ResultGenerator.genSuccessResult();
		} else {
			return ResultGenerator.genFailResult("FAIL");
		}
	}

	/**
	 * 修改
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@ResponseBody
	public Result update(@RequestBody FatherMenu fatherMenu) throws Exception {
		int resultTotal = fatherMenuService.update(fatherMenu);
		if (resultTotal > 0) {
			return ResultGenerator.genSuccessResult();
		} else {
			return ResultGenerator.genFailResult("FAIL");
		}
	}

	/**
	 * 删除父菜单
	 * 
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@ResponseBody
	public Result delete(@PathVariable(value = "ids") String ids)
			throws Exception {
		if (ids.length() > 20) {
			return ResultGenerator.genFailResult("ERROR");
		}
		String[] idsStr = ids.split(",");
		for (int i = 0; i < idsStr.length; i++) {
			fatherMenuService.delete(Integer.valueOf(idsStr[i]));
		}
		log.info("request: article/delete , ids: " + ids);
		return ResultGenerator.genSuccessResult();
	}
}
