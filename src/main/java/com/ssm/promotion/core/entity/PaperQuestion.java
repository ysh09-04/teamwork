package com.ssm.promotion.core.entity;

/**
 * 考卷题目
 * @author 尤少辉
 * @日期 2018年7月1日
 */
public class PaperQuestion {
	private int paperQuestionId;
	private String questionType;
	private String questionContent;
	private String chooseContent;
	private String answer;
	private String answerAnalysis;
	private int questionSelectionToal;
	private int questionValue;
	private int paperId;
	public int getPaperQuestionId() {
		return paperQuestionId;
	}
	public void setPaperQuestionId(int paperQuestionId) {
		this.paperQuestionId = paperQuestionId;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public String getQuestionContent() {
		return questionContent;
	}
	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}
	public String getChooseContent() {
		return chooseContent;
	}
	public void setChooseContent(String chooseContent) {
		this.chooseContent = chooseContent;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getAnswerAnalysis() {
		return answerAnalysis;
	}
	public void setAnswerAnalysis(String answerAnalysis) {
		this.answerAnalysis = answerAnalysis;
	}
	public int getQuestionSelectionToal() {
		return questionSelectionToal;
	}
	public void setQuestionSelectionToal(int questionSelectionToal) {
		this.questionSelectionToal = questionSelectionToal;
	}
	public int getQuestionValue() {
		return questionValue;
	}
	public void setQuestionValue(int questionValue) {
		this.questionValue = questionValue;
	}
	public int getpaperId() {
		return paperId;
	}
	public void setpaperId(int paperId) {
		this.paperId = paperId;
	}
	public PaperQuestion(int paperQuestionId, String questionType, String questionContent, String chooseContent,
			String answer, String answerAnalysis, int questionSelectionToal, int questionValue, int paperId) {
		super();
		this.paperQuestionId = paperQuestionId;
		this.questionType = questionType;
		this.questionContent = questionContent;
		this.chooseContent = chooseContent;
		this.answer = answer;
		this.answerAnalysis = answerAnalysis;
		this.questionSelectionToal = questionSelectionToal;
		this.questionValue = questionValue;
		this.paperId = paperId;
	}
	public PaperQuestion() {
		super();
	}
	
}
