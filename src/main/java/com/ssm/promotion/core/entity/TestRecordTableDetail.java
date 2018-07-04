package com.ssm.promotion.core.entity;

/**
 * 测试记录表详情表
 * @author 尤少辉
 * @日期 2018年7月4日
 */
public class TestRecordTableDetail {
	private int testRecordTableId;
	private String answer;
	private String isRight;
	private int userQuestionBankId;
	public int getTestRecordTableId() {
		return testRecordTableId;
	}
	public void setTestRecordTableId(int testRecordTableId) {
		this.testRecordTableId = testRecordTableId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getIsRight() {
		return isRight;
	}
	public void setIsRight(String isRight) {
		this.isRight = isRight;
	}
	public int getUserQuestionBankId() {
		return userQuestionBankId;
	}
	public void setUserQuestionBankId(int userQuestionBankId) {
		this.userQuestionBankId = userQuestionBankId;
	}
	public TestRecordTableDetail(int testRecordTableId, String answer, String isRight, int userQuestionBankId) {
		super();
		this.testRecordTableId = testRecordTableId;
		this.answer = answer;
		this.isRight = isRight;
		this.userQuestionBankId = userQuestionBankId;
	}
	public TestRecordTableDetail() {
		super();
	}
}
