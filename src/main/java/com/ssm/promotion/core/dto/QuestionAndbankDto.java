package com.ssm.promotion.core.dto;

import com.ssm.promotion.core.entity.QuestionBank;

public class QuestionAndbankDto {
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
	private QuestionBank questionBank =new QuestionBank();
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
	public QuestionBank getquestionBank() {
		return questionBank;
	}
	public void setquestionBank(QuestionBank questionBank) {
		this.questionBank = questionBank;
	}
	
	
	public QuestionAndbankDto(int questionId, String questionType, String questionContent, String chooseContent,
			String answer, String answerAnalysis, String questionSource, String examinationPointDescription,
			String titleAccuracy, int questionSelectionToal, double questionValue, QuestionBank questionBank) {
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
		this.questionBank = questionBank;
	}
	public QuestionAndbankDto(String questionType, String questionContent, String chooseContent, String answer,
			String answerAnalysis, String questionSource, String examinationPointDescription, String titleAccuracy,
			int questionSelectionToal, double questionValue, QuestionBank questionBank) {
		super();
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
		this.questionBank = questionBank;
	}
	public QuestionAndbankDto() {
		super();
	}
	
	
}
