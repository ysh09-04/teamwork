package com.ssm.promotion.core.entity;

/**
 * 测试记录表
 * @author 尤少辉
 * @日期 2018年7月4日
 */
public class TestRecordTable {
	private int testRecordTableId;
	private String testTime;
	private String isComplete;
	private int userQuestionBankId;
	public int getTestRecordTableId() {
		return testRecordTableId;
	}
	public void setTestRecordTableId(int testRecordTableId) {
		this.testRecordTableId = testRecordTableId;
	}
	public String getTestTime() {
		return testTime;
	}
	public void setTestTime(String testTime) {
		this.testTime = testTime;
	}
	public String getIsComplete() {
		return isComplete;
	}
	public void setIsComplete(String isComplete) {
		this.isComplete = isComplete;
	}
	public int getUserQuestionBankId() {
		return userQuestionBankId;
	}
	public void setUserQuestionBankId(int userQuestionBankId) {
		this.userQuestionBankId = userQuestionBankId;
	}
	public TestRecordTable(int testRecordTableId, String testTime, String isComplete, int userQuestionBankId) {
		super();
		this.testRecordTableId = testRecordTableId;
		this.testTime = testTime;
		this.isComplete = isComplete;
		this.userQuestionBankId = userQuestionBankId;
	}
	public TestRecordTable() {
		super();
	}
	
}
