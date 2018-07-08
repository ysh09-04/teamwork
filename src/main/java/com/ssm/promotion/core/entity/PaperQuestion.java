package com.ssm.promotion.core.entity;

/**
 * 考卷题目
 * @author 尤少辉
 * @日期 2018年7月1日
 */
public class PaperQuestion {
	private int paperQuestionId;
	private int questionId;
	private int paperId;
	public int getPaperQuestionId() {
		return paperQuestionId;
	}
	public void setPaperQuestionId(int paperQuestionId) {
		this.paperQuestionId = paperQuestionId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getPaperId() {
		return paperId;
	}
	public void setPaperId(int paperId) {
		this.paperId = paperId;
	}
	public PaperQuestion(int paperQuestionId, int questionId, int paperId) {
		super();
		this.paperQuestionId = paperQuestionId;
		this.questionId = questionId;
		this.paperId = paperId;
	}
	public PaperQuestion() {
		super();
	}
	
}
