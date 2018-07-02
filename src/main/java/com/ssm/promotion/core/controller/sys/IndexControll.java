package com.ssm.promotion.core.controller.sys;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.promotion.core.common.Constants;
import com.ssm.promotion.core.dto.FatherMenuSonMenuDto;
import com.ssm.promotion.core.entity.SUser;
import com.ssm.promotion.core.service.FatherMenuService;

@Controller
public class IndexControll {
	/**
	 * 跳转到登录界面
	 * @return
	 */
	@RequestMapping("login")
	public String index() {
		return "login";
	}
	
	@Autowired
	private FatherMenuService fatherMenuService;
	/**
	 * 显示菜单
	 * @return
	 */
	@RequestMapping("/main")
	public String findByUserName(HttpServletRequest request){
		SUser user = (SUser)request.getSession().getAttribute(Constants.SESSION_USER);
		List<FatherMenuSonMenuDto> fatherMenuSonMenuDtos= fatherMenuService.findByUserName(user.getUserName());
		request.setAttribute("userName", user.getUserName());
		request.setAttribute("fatherMenuSonMenuDtos", fatherMenuSonMenuDtos);
		return "home/main";
	}
}
