package com.ssm.promotion.core.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.promotion.core.dao.QuestionBankDao;
import com.ssm.promotion.core.dao.QuestionDao;
import com.ssm.promotion.core.dao.RoleDao;
import com.ssm.promotion.core.dao.Shop_ContentDao;
import com.ssm.promotion.core.dto.QuestionbankCourseDto;
import com.ssm.promotion.core.entity.QuestionBank;
import com.ssm.promotion.core.service.QuestionBankService;
/**
 * @author 刘家霖
 * @project_name perfect-ssm
 * @date 2018-7-2
 */
@Service("questionBankService")
public class QuestionBankServiceImpl implements QuestionBankService {
	  @Resource
	  private QuestionBankDao questionBankDao ;
	  @Resource
	  private Shop_ContentDao shop_ContentDao;
	  @Resource
	  private QuestionDao questionDao ;
	  
	@Override
	public List<QuestionbankCourseDto> findAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return questionBankDao.findAll(map);
	}

	@Override
	public Long getTotalQuestionbank(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return questionBankDao.getTotalQuestionbank(map);
	}

	@Override
	public int add(QuestionBank questionBank) {
		// TODO Auto-generated method stub
		return questionBankDao.add(questionBank);
	}

	@Override
	public int update(QuestionBank questionBank) {
		// TODO Auto-generated method stub
		return questionBankDao.update(questionBank);
	}

	@Override
	public int delete(int questionBankId) {
		//先删除题目表
		questionDao.delete(questionBankId);
		//再删除商品表
		String type="题库";
		shop_ContentDao.delete(type, questionBankId);
		
		return questionBankDao.delete(questionBankId);
	}

}
