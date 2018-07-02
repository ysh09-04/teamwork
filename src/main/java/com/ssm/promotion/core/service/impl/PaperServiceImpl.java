package com.ssm.promotion.core.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.promotion.core.dao.PaperDao;
import com.ssm.promotion.core.dto.PaperCourseDto;
import com.ssm.promotion.core.entity.Paper;
import com.ssm.promotion.core.service.PaperService;
@Service("paperService")
public class PaperServiceImpl implements PaperService {
	
	@Autowired
	private PaperDao paperDao;
	
	@Override
	public List<Integer> findByCourseId(int courseId) {
		// TODO Auto-generated method stub
		return paperDao.findByCourseId(courseId);
	}

	@Override
	public int delete(int paperId) {
		// TODO Auto-generated method stub
		return paperDao.delete(paperId);
	}

	@Override
	public List<PaperCourseDto> findPaper(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return paperDao.findPaper(map);
	}

	@Override
	public Long getTotalPaper(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return paperDao.getTotalPaper(map);
	}

	@Override
	public int addPaper(Paper paper) {
		// TODO Auto-generated method stub
		return paperDao.addPaper(paper);
	}

	@Override
	public Paper getPaperByName(String paperName) {
		// TODO Auto-generated method stub
		return paperDao.getPaperByName(paperName);
	}

	@Override
	public int updatePaper(Paper paper) {
		// TODO Auto-generated method stub
		return paperDao.updatePaper(paper);
	}

}
