package com.ssm.promotion.core.entity;

/**
 * 错题本
 * @author 尤少辉
 * @日期 2018年7月4日
 */
public class WrongTopicBook {
	private int wrongTopicBookId;
	private int errorNumber;
	private String lastErrorTime;
	private int tUserId;
	private int questionId;
	public int getWrongTopicBookId() {
		return wrongTopicBookId;
	}
	public void setWrongTopicBookId(int wrongTopicBookId) {
		this.wrongTopicBookId = wrongTopicBookId;
	}
	public int getErrorNumber() {
		return errorNumber;
	}
	public void setErrorNumber(int errorNumber) {
		this.errorNumber = errorNumber;
	}
	public String getLastErrorTime() {
		return lastErrorTime;
	}
	public void setLastErrorTime(String lastErrorTime) {
		this.lastErrorTime = lastErrorTime;
	}
	public int gettUserId() {
		return tUserId;
	}
	public void settUserId(int tUserId) {
		this.tUserId = tUserId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public WrongTopicBook(int wrongTopicBookId, int errorNumber, String lastErrorTime, int tUserId, int questionId) {
		super();
		this.wrongTopicBookId = wrongTopicBookId;
		this.errorNumber = errorNumber;
		this.lastErrorTime = lastErrorTime;
		this.tUserId = tUserId;
		this.questionId = questionId;
	}
	public WrongTopicBook() {
		super();
	}
	
}
