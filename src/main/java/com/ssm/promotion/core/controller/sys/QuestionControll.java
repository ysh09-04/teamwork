package com.ssm.promotion.core.controller.sys;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import com.ssm.promotion.core.dto.QuestionAndbankDto;
import com.ssm.promotion.core.entity.PageBean;
import com.ssm.promotion.core.entity.Question;
import com.ssm.promotion.core.service.QuestionService;
import com.ssm.promotion.core.util.ResponseUtil;
import com.ssm.promotion.core.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/question")
public class QuestionControll {
	@Autowired
	private QuestionService questionService;
	private static final Logger log = Logger.getLogger(UserController.class);// 日志文件

	/**
	 * 跳转到菜单
	 * @return
	 */
	@RequestMapping("toQuestion")
	public String toQuestion(){
		return "question/questionManege";
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
			Question question,HttpServletResponse response) throws Exception{
		PageBean pageBean = new PageBean(Integer.parseInt(page),
				Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("questionType", StringUtil.formatLike(question.getQuestionType()));
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<QuestionAndbankDto> questionandbankDto = questionService.findQuestion(map);
		Long total = (long) questionService.getTotalQuestion(map);
		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(questionandbankDto);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	/**
	 * 添加或修改
	 * 
	 * @return
	 * @throws Exception
	 */
	//添加题目类型
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String save(@RequestParam MultipartFile image,HttpServletRequest request) throws Exception {
		MultipartHttpServletRequest multipartHttpServletRequest=(MultipartHttpServletRequest)request;
		String img=null;
		if(image.getSize()!=0){
			//设置文件路径
			String dir=request.getServletContext().getRealPath("/")+"img";
			File path=new File(dir);
			System.out.println(dir);
			if(!path.exists()){
				path.mkdirs();
			}
			//转存文件
			String uuid = UUID.randomUUID().toString();	

			image.transferTo(new File(path,uuid+image.getOriginalFilename()));
			img="./img"+"/"+uuid+image.getOriginalFilename();
		}
		int  questionSelectionToal=Integer.parseInt(multipartHttpServletRequest.getParameter("questionSelectionToal"));
		int  questionBankId=Integer.parseInt(multipartHttpServletRequest.getParameter("questionBankId"));
		String before=multipartHttpServletRequest.getParameter("before");
		String after=multipartHttpServletRequest.getParameter("after");
		String questionContent=null;
		if(image.getSize()!=0){
			questionContent=before+"<img src="+img+" />"+after;
		}else{
			questionContent=before+after;

		}
		String questionType=multipartHttpServletRequest.getParameter("questionType");
		String answer=multipartHttpServletRequest.getParameter("answer");
		String answerAnalysis=multipartHttpServletRequest.getParameter("answerAnalysis");
		String examinationPointDescription=multipartHttpServletRequest.getParameter("examinationPointDescription");
		String questionSource=multipartHttpServletRequest.getParameter("questionSource");
		String titleAccuracy=multipartHttpServletRequest.getParameter("titleAccuracy");	
		String chooseContent=multipartHttpServletRequest.getParameter("chooseContent");	
		Double questionValue=Double.parseDouble(multipartHttpServletRequest.getParameter("questionValue"));
		Question question = new Question(questionType, questionContent, chooseContent, answer, answerAnalysis, questionSource, examinationPointDescription, titleAccuracy, questionSelectionToal, questionValue, questionBankId);
		int resultTotal =questionService.addQuestion(question);

		if (resultTotal > 0) {
			return "question/questionManege";
		} else {
			return "error";
		}
	}

	/**
	 * 修改
	 * 
	 * @return
	 * @throws Exception
	 */
	//添加题目类型
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@RequestParam MultipartFile image,HttpServletRequest request) throws Exception {
		MultipartHttpServletRequest multipartHttpServletRequest=(MultipartHttpServletRequest)request;
		String img=null;
		if(image.getSize()!=0){
			//设置文件路径
			String dir=request.getServletContext().getRealPath("/")+"img";
			File path=new File(dir);
			System.out.println(dir);
			if(!path.exists()){
				path.mkdirs();
			}
			//转存文件
			String uuid = UUID.randomUUID().toString();	

			image.transferTo(new File(path,uuid+image.getOriginalFilename()));
			img="./img"+"/"+uuid+image.getOriginalFilename();
		}
		int  questionSelectionToal=Integer.parseInt(multipartHttpServletRequest.getParameter("questionSelectionToal"));
		int  questionBankId=Integer.parseInt(multipartHttpServletRequest.getParameter("questionBankId"));
		String before=multipartHttpServletRequest.getParameter("before");
		String after=multipartHttpServletRequest.getParameter("after");

		String questionId=multipartHttpServletRequest.getParameter("questionId");
		String questionType=multipartHttpServletRequest.getParameter("questionType");
		String answer=multipartHttpServletRequest.getParameter("answer");
		String answerAnalysis=multipartHttpServletRequest.getParameter("answerAnalysis");
		String examinationPointDescription=multipartHttpServletRequest.getParameter("examinationPointDescription");
		String questionSource=multipartHttpServletRequest.getParameter("questionSource");
		String titleAccuracy=multipartHttpServletRequest.getParameter("titleAccuracy");	
		String chooseContent=multipartHttpServletRequest.getParameter("chooseContent");	
		Double questionValue=Double.parseDouble(multipartHttpServletRequest.getParameter("questionValue"));
		String questionContent=null;
		Question question2= questionService.findById(Integer.parseInt(questionId));
		if(img==null){
			String[] str2=question2.getQuestionContent().split("<");
			if(str2.length==2){
				str2[1]="<"+str2[1];
				String[] str3=str2[1].split(">");
				String questionImg=str3[0]+">";
				questionContent=before+questionImg+after;
			}else{
				questionContent=before+after;
			}
		}else{
			questionContent=before+"<img src="+img+" />"+after;
		}
		Question question = new Question(questionType, questionContent, chooseContent, answer, answerAnalysis, questionSource, examinationPointDescription, titleAccuracy, questionSelectionToal, questionValue, questionBankId);
		question.setQuestionId(Integer.parseInt(questionId));
		int resultTotal =questionService.updateQuestion(question);

		if (resultTotal > 0) {
			return "question/questionManege";
		} else {
			return "error";
		}
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
			questionService.delete(Integer.valueOf(idsStr[i]));
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
	public List<Question> findAll(){
		List<Question> listQuestions= questionService.findAll();
		return listQuestions;
	}
}



