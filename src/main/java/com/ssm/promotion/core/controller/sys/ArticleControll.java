package com.ssm.promotion.core.controller.sys;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ssm.promotion.core.common.Result;
import com.ssm.promotion.core.common.ResultGenerator;
import com.ssm.promotion.core.dto.ArticleCourseDto;

import com.ssm.promotion.core.entity.Article;
import com.ssm.promotion.core.entity.PageBean;

import com.ssm.promotion.core.service.ArticleService;

import com.ssm.promotion.core.util.ResponseUtil;
import com.ssm.promotion.core.util.StringUtil;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Controller
@RequestMapping("/article")
public class ArticleControll {
	
	
		@Resource
		private ArticleService articleService;
		private static final Logger log = Logger.getLogger(UserController.class);// 日志文件
		
		/**
		 * 跳转到菜单
		 * @return
		 */
		@RequestMapping("toArticle")
		public String toArticle(){
			return "article/articleManege";
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
				Article article,HttpServletResponse response) throws Exception{
			PageBean pageBean = new PageBean(Integer.parseInt(page),
					Integer.parseInt(rows));
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("articleTitle", StringUtil.formatLike(article.getArticleTitle()));
			map.put("start", pageBean.getStart());
			map.put("size", pageBean.getPageSize());
			List<ArticleCourseDto> ArticleCourseDtos = articleService.findArticle(map);
			Long total = (long) articleService.getTotalArticle(map);
			JSONObject result = new JSONObject();
			JSONArray jsonArray = JSONArray.fromObject(ArticleCourseDtos);
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
		@RequestMapping("addArticle")
		public String addArticle(HttpServletRequest request,@RequestParam("file") MultipartFile file,Article article){	
			//获取文件保存路径
					try {
						String dir=request.getServletContext().getRealPath("/")+"Word";
						System.out.println(dir);
						File path=new File(dir);
						if(!path.exists()){
							path.mkdirs();
						}					
						file.transferTo(new File(path, file.getOriginalFilename()));
						String articleUrl=dir+"/"+file.getOriginalFilename();
						article.setArticleContent(articleUrl);
						articleService.addArticle(article);
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return "forward:toArticle";	
		}

		/**
		 * 修改
		 * 
		 * @param user
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value = "update")
		public String update(HttpServletRequest request,@RequestParam("file") MultipartFile file,Article article){	
			//获取文件保存路径
					try {
						String dir=request.getServletContext().getRealPath("/")+"Word";
						System.out.println(dir);
						File path=new File(dir);
						if(!path.exists()){
							path.mkdirs();
						}					
						file.transferTo(new File(path, file.getOriginalFilename()));
						String articleUrl=dir+"/"+file.getOriginalFilename();
						article.setArticleContent(articleUrl);
						articleService.updateArticle(article);
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return "forward:toArticle";	
		}

		/**
		 * 删除
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
				articleService.delete(Integer.valueOf(idsStr[i]));
			}
			log.info("request: article/delete , ids: " + ids);
			return ResultGenerator.genSuccessResult();
		}
		/**
		 * 查询全部
		 * 
		 * @param 
		 * @return
		 * @throws 
		 */
		@RequestMapping("findAll")
		@ResponseBody
		public List<Article> findAll(){
			List<Article> listArticles= articleService.findAll();
			return listArticles;
		}
		
		
		
}
