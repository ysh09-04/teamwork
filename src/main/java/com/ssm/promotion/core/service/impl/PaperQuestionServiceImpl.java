package com.ssm.promotion.core.service.impl;
/**
 * @author 刘家霖
 * @project_name perfect-ssm
 * @date 2018-7-8
 */
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.promotion.core.dao.OrderDao;
import com.ssm.promotion.core.dao.PaperQuestionDao;
import com.ssm.promotion.core.dto.PaperQuestionDto;
import com.ssm.promotion.core.entity.PaperQuestion;
import com.ssm.promotion.core.service.PaperQuestionService;
@Service("paperQuestionService")
public class PaperQuestionServiceImpl implements PaperQuestionService {
	@Resource
	private PaperQuestionDao paperQuestionDao ;
	@Override
	public List<PaperQuestionDto> findAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return paperQuestionDao.findAll(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return paperQuestionDao.getTotal(map);
	}

	@Override
	public int add(PaperQuestion paperQuestion) {
		// TODO Auto-generated method stub
		return paperQuestionDao.add(paperQuestion);
	}

	@Override
	public int update(PaperQuestion paperQuestion) {
		// TODO Auto-generated method stub
		return paperQuestionDao.update(paperQuestion);
	}

	@Override
	public int delete2(PaperQuestion paperQuestion) {
		// TODO Auto-generated method stub
		return paperQuestionDao.delete2(paperQuestion);
	}

}
