package com.ssm.promotion.core.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.promotion.core.dao.QuestionDao;
import com.ssm.promotion.core.dto.QuestionAndbankDto;
import com.ssm.promotion.core.entity.Paper;
import com.ssm.promotion.core.entity.Question;
import com.ssm.promotion.core.service.QuestionService;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionDao questionDao;
	
	@Override
	public List<Integer> findByQuestionBankId(int questionBankId) {
		// TODO Auto-generated method stub
		return questionDao.findByQuestionBankId(questionBankId);
	}

	@Override
	public int delete(int questionId) {
		// TODO Auto-generated method stub
		return questionDao.delete(questionId);
	}

	@Override
	public List<QuestionAndbankDto> findQuestion(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return questionDao.findQuestion(map);
	}

	@Override
	public Long getTotalQuestion(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return questionDao.getTotalQuestion(map);
	}

	@Override
	public int addQuestion(Question question) {
		// TODO Auto-generated method stub
		return questionDao.addQuestion(question);
	}

	

	@Override
	public int updateQuestion(Question question) {
		// TODO Auto-generated method stub
		return questionDao.updateQuestion(question);
	}

	@Override
	public Paper getQuestionByName(String questionType) {
		// TODO Auto-generated method stub
		return questionDao.getQuestionByName(questionType);
	}

}
