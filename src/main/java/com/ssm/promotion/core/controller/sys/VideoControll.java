package com.ssm.promotion.core.controller.sys;

import java.io.File;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ssm.promotion.core.common.Result;
import com.ssm.promotion.core.common.ResultGenerator;
import com.ssm.promotion.core.dto.VideoVideoCategoryDto;
import com.ssm.promotion.core.entity.PageBean;
import com.ssm.promotion.core.entity.Video;
import com.ssm.promotion.core.entity.VideoCategory;
import com.ssm.promotion.core.service.VideoService;
import com.ssm.promotion.core.util.ResponseUtil;
import com.ssm.promotion.core.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 视频
 * @author 尤少辉
 * @日期 2018年7月7日
 */
@Controller
@RequestMapping("video")
public class VideoControll {

	@Autowired
	private VideoService videoService;

	private static final Logger log = Logger.getLogger(UserController.class);// 日志文件

	/**
	 * 跳转到菜单
	 * @return
	 */
	@RequestMapping("toVideo")
	public String toVideo(){
		return "video/videoManage";
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
			Video video,HttpServletResponse response) throws Exception{
		PageBean pageBean = new PageBean(Integer.parseInt(page),
				Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("videoName", StringUtil.formatLike(video.getVideoName()));
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<VideoVideoCategoryDto> videoCategories= videoService.findByVideoNameOrAllpage(map);
		Long total = (long) videoService.findByVideoNameOrAllCount(map);
		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(videoCategories);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}

	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "save")
	public String save(@RequestParam("videoUrl")MultipartFile videoUrl,HttpServletRequest request) throws Exception {
		String filepath = request.getSession().getServletContext().getRealPath("/img");
		File file=new File(filepath);
		if(!file.exists()){
			file.mkdirs();
		}
		File videoUrlpath=new File(file,"\\"+videoUrl.getOriginalFilename());
		String videoUrlNeed=file+"\\"+videoUrl.getOriginalFilename();
		videoUrl.transferTo(videoUrlpath);
		MultipartHttpServletRequest multipartRequest =     (MultipartHttpServletRequest) request;
	    String videoName = multipartRequest.getParameter("videoName");
	    String videoType = multipartRequest.getParameter("videoType");
	    String videoSynopsis = multipartRequest.getParameter("videoSynopsis");
	    String enabled = multipartRequest.getParameter("enabled");
	    String sortId = multipartRequest.getParameter("sortId");
	    String playNumber = multipartRequest.getParameter("playNumber");
	    String videoCategoryId = multipartRequest.getParameter("videoCategoryId");
	    Video video=new Video(videoType, videoName, videoUrlNeed, videoSynopsis, enabled, 
	    		Integer.parseInt(sortId), Integer.parseInt(playNumber), Integer.parseInt(videoCategoryId));
		videoService.save(video,videoUrl.getOriginalFilename(),request);
		return "forward:toVideo";
	}
	/**
	 * 修改
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "update")
	public String update(@RequestParam("videoUrl2")MultipartFile videoUrl,HttpServletRequest request) throws Exception {
		String filepath = request.getSession().getServletContext().getRealPath("/img");
		File file=new File(filepath);
		if(!file.exists()){
			file.mkdirs();
		}
		File videoUrlpath=new File(file,"\\"+videoUrl.getOriginalFilename());
		String videoUrlNeed=file+"\\"+videoUrl.getOriginalFilename();
		videoUrl.transferTo(videoUrlpath);
		MultipartHttpServletRequest multipartRequest =(MultipartHttpServletRequest) request;
	    String videoId = multipartRequest.getParameter("videoId2");
	    String videoName = multipartRequest.getParameter("videoName2");
	    String videoType = multipartRequest.getParameter("videoType2");
	    String videoSynopsis = multipartRequest.getParameter("videoSynopsis2");
	    String enabled = multipartRequest.getParameter("enabled2");
	    String sortId = multipartRequest.getParameter("sortId2");
	    String playNumber = multipartRequest.getParameter("playNumber2");
	    String videoCategoryId = multipartRequest.getParameter("videoCategoryId2");
	    Video video=new Video(videoType, videoName, videoUrlNeed, videoSynopsis, enabled, 
	    		Integer.parseInt(sortId), Integer.parseInt(playNumber), Integer.parseInt(videoCategoryId));
	    video.setVideoId(Integer.parseInt(videoId));
		videoService.update(video,videoUrl.getOriginalFilename(),request);
		return "forward:toVideo";
	}
	/**
	 * 删除管理员
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
			videoService.delete(Integer.valueOf(idsStr[i]));
		}
		log.info("request: article/delete , ids: " + ids);
		return ResultGenerator.genSuccessResult();
	}
	
}
