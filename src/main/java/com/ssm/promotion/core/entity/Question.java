package com.ssm.promotion.core.entity;

/**
 * 题目
 * @author 尤少辉
 * @日期 2018年7月1日
 */
public class Question {
	private int questionId;
	private String questionType;
	private String questionContent;
	private String chooseContent;
	private String answer;
	private String answerAnalysis;
	private String questionSource;
	private String examinationPointDescription;
	private String titleAccuracy;
	private int questionSelectionToal;
	private double questionValue;
	private int questionBankId;
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
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
	public String getQuestionSource() {
		return questionSource;
	}
	public void setQuestionSource(String questionSource) {
		this.questionSource = questionSource;
	}
	public String getExaminationPointDescription() {
		return examinationPointDescription;
	}
	public void setExaminationPointDescription(String examinationPointDescription) {
		this.examinationPointDescription = examinationPointDescription;
	}
	public String getTitleAccuracy() {
		return titleAccuracy;
	}
	public void setTitleAccuracy(String titleAccuracy) {
		this.titleAccuracy = titleAccuracy;
	}
	public int getQuestionSelectionToal() {
		return questionSelectionToal;
	}
	public void setQuestionSelectionToal(int questionSelectionToal) {
		this.questionSelectionToal = questionSelectionToal;
	}
	public double getQuestionValue() {
		return questionValue;
	}
	public void setQuestionValue(double questionValue) {
		this.questionValue = questionValue;
	}
	public int getQuestionBankId() {
		return questionBankId;
	}
	public void setQuestionBankId(int questionBankId) {
		this.questionBankId = questionBankId;
	}
	public Question(int questionId, String questionType, String questionContent, String chooseContent, String answer,
			String answerAnalysis, String questionSource, String examinationPointDescription, String titleAccuracy,
			int questionSelectionToal, double questionValue, int questionBankId) {
		super();
		this.questionId = questionId;
		this.questionType = questionType;
		this.questionContent = questionContent;
		this.chooseContent = chooseContent;
		this.answer = answer;
		this.answerAnalysis = answerAnalysis;
		this.questionSource = questionSource;
		this.examinationPointDescription = examinationPointDescription;
		this.titleAccuracy = titleAccuracy;
		this.questionSelectionToal = questionSelectionToal;
		this.questionValue = questionValue;
		this.questionBankId = questionBankId;
	}
	public Question() {
		super();
	}
	
}
