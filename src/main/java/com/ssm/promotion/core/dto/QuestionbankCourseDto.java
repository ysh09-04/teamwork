package com.ssm.promotion.core.dto;

import com.ssm.promotion.core.entity.Course;

public class QuestionbankCourseDto {
	private int questionBankId;
	private String questionBankName;
	private String questionBankDescribe;
	private int visitTimes;
	private int purchaseTimes;
	private Course course = new Course();
	public int getQuestionBankId() {
		return questionBankId;
	}
	public void setQuestionBankId(int questionBankId) {
		this.questionBankId = questionBankId;
	}
	public String getQuestionBankName() {
		return questionBankName;
	}
	public void setQuestionBankName(String questionBankName) {
		this.questionBankName = questionBankName;
	}
	public String getQuestionBankDescribe() {
		return questionBankDescribe;
	}
	public void setQuestionBankDescribe(String questionBankDescribe) {
		this.questionBankDescribe = questionBankDescribe;
	}
	public int getVisitTimes() {
		return visitTimes;
	}
	public void setVisitTimes(int visitTimes) {
		this.visitTimes = visitTimes;
	}
	public int getPurchaseTimes() {
		return purchaseTimes;
	}
	public void setPurchaseTimes(int purchaseTimes) {
		this.purchaseTimes = purchaseTimes;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public QuestionbankCourseDto(int questionBankId, String questionBankName, String questionBankDescribe, int visitTimes,
			int purchaseTimes, Course course) {
		super();
		this.questionBankId = questionBankId;
		this.questionBankName = questionBankName;
		this.questionBankDescribe = questionBankDescribe;
		this.visitTimes = visitTimes;
		this.purchaseTimes = purchaseTimes;
		this.course = course;
	}
	public QuestionbankCourseDto() {
		super();
	}
	
}
