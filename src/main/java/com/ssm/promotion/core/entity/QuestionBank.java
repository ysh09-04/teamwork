package com.ssm.promotion.core.entity;

/**
 * 题库
 * @author 尤少辉
 * @日期 2018年7月1日
 */
public class QuestionBank {
	private int questionBankId;
	private String questionBankName;
	private String questionBankDescribe;
	private int visitTimes;
	private int purchaseTimes;
	private int courseId;
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
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public QuestionBank(int questionBankId, String questionBankName, String questionBankDescribe, int visitTimes,
			int purchaseTimes, int courseId) {
		super();
		this.questionBankId = questionBankId;
		this.questionBankName = questionBankName;
		this.questionBankDescribe = questionBankDescribe;
		this.visitTimes = visitTimes;
		this.purchaseTimes = purchaseTimes;
		this.courseId = courseId;
	}
	public QuestionBank() {
		super();
	}
	
}
