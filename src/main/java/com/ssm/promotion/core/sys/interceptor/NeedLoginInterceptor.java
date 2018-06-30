package com.ssm.promotion.core.sys.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ssm.promotion.core.common.Constants;
import com.ssm.promotion.core.common.annotation.NeedLogin;
import com.ssm.promotion.core.entity.SUser;

/**
 * @description
 * @author chj
 * @date 创建时间：2018-4-25 上午10:13:57
 * @version 1.0
 * @since
 */
public class NeedLoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		return true;
	}

}
