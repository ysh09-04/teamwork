package com.ssm.promotion.core.entity;

/**
 * 用户
 * @author 尤少辉
 * @日期 2018年7月4日
 */
public class UserQuestionBank {
	private int userQuestionBankId;
	private int tUserId;
	private int questionBankId;
	public int getUserQuestionBankId() {
		return userQuestionBankId;
	}
	public void setUserQuestionBankId(int userQuestionBankId) {
		this.userQuestionBankId = userQuestionBankId;
	}
	public int gettUserId() {
		return tUserId;
	}
	public void settUserId(int tUserId) {
		this.tUserId = tUserId;
	}
	public int getQuestionBankId() {
		return questionBankId;
	}
	public void setQuestionBankId(int questionBankId) {
		this.questionBankId = questionBankId;
	}
	public UserQuestionBank(int userQuestionBankId, int tUserId, int questionBankId) {
		super();
		this.userQuestionBankId = userQuestionBankId;
		this.tUserId = tUserId;
		this.questionBankId = questionBankId;
	}
	public UserQuestionBank() {
		super();
	}
	
}
