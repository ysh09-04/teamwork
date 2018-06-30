package com.ssm.promotion.core.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
 * 封装一个将数据在页面上显示的实现类
 * @author 1034683568@qq.com
 * @project_name perfect-ssm
 * @date 2017-3-1
 */
public class ResponseUtil {

	/**
	 * 数据在页面上显示
	 * @param response
	 * @param o
	 * @throws Exception
	 */
    public static void write(HttpServletResponse response, Object o) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        response.addHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out = response.getWriter();
        out.println(o.toString());
        out.flush();
        out.close();
    }
}
