package com.ssm.promotion.core.entity;

/**
 * 用户课程表
 * @author 尤少辉
 * @日期 2018年7月4日
 */
public class UserCourse {
	private int userCourseId;
	private String acquisitionMode;
	private String isUserCourse;
	private String courseExpiryTime;
	private int lastSystemOperatorId;
	private String obtainingVoucher;
	private String isUserPaper;
	private String isUserQuestionBank;
	private String courseState;
	private int tUserId;
	private int countId;
	public int getUserCourseId() {
		return userCourseId;
	}
	public void setUserCourseId(int userCourseId) {
		this.userCourseId = userCourseId;
	}
	public String getAcquisitionMode() {
		return acquisitionMode;
	}
	public void setAcquisitionMode(String acquisitionMode) {
		this.acquisitionMode = acquisitionMode;
	}
	public String getIsUserCourse() {
		return isUserCourse;
	}
	public void setIsUserCourse(String isUserCourse) {
		this.isUserCourse = isUserCourse;
	}
	public String getCourseExpiryTime() {
		return courseExpiryTime;
	}
	public void setCourseExpiryTime(String courseExpiryTime) {
		this.courseExpiryTime = courseExpiryTime;
	}
	public int getLastSystemOperatorId() {
		return lastSystemOperatorId;
	}
	public void setLastSystemOperatorId(int lastSystemOperatorId) {
		this.lastSystemOperatorId = lastSystemOperatorId;
	}
	public String getObtainingVoucher() {
		return obtainingVoucher;
	}
	public void setObtainingVoucher(String obtainingVoucher) {
		this.obtainingVoucher = obtainingVoucher;
	}
	public String getIsUserPaper() {
		return isUserPaper;
	}
	public void setIsUserPaper(String isUserPaper) {
		this.isUserPaper = isUserPaper;
	}
	public String getIsUserQuestionBank() {
		return isUserQuestionBank;
	}
	public void setIsUserQuestionBank(String isUserQuestionBank) {
		this.isUserQuestionBank = isUserQuestionBank;
	}
	public String getCourseState() {
		return courseState;
	}
	public void setCourseState(String courseState) {
		this.courseState = courseState;
	}
	public int gettUserId() {
		return tUserId;
	}
	public void settUserId(int tUserId) {
		this.tUserId = tUserId;
	}
	public int getCountId() {
		return countId;
	}
	public void setCountId(int countId) {
		this.countId = countId;
	}
	public UserCourse(int userCourseId, String acquisitionMode, String isUserCourse, String courseExpiryTime,
			int lastSystemOperatorId, String obtainingVoucher, String isUserPaper, String isUserQuestionBank,
			String courseState, int tUserId, int countId) {
		super();
		this.userCourseId = userCourseId;
		this.acquisitionMode = acquisitionMode;
		this.isUserCourse = isUserCourse;
		this.courseExpiryTime = courseExpiryTime;
		this.lastSystemOperatorId = lastSystemOperatorId;
		this.obtainingVoucher = obtainingVoucher;
		this.isUserPaper = isUserPaper;
		this.isUserQuestionBank = isUserQuestionBank;
		this.courseState = courseState;
		this.tUserId = tUserId;
		this.countId = countId;
	}
	public UserCourse() {
		super();
	}
	
}
