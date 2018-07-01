package com.ssm.promotion.core.entity;

/**
 * 课程
 * @author 尤少辉
 * @日期 2018年7月1日
 */
public class Course {
	private int courseId;
	private String courseName;
	private String courseDescribe;
	private String enabledCourse;
	private String enabledPaper;
	private int categoryId;
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDescribe() {
		return courseDescribe;
	}
	public void setCourseDescribe(String courseDescribe) {
		this.courseDescribe = courseDescribe;
	}
	public String getEnabledCourse() {
		return enabledCourse;
	}
	public void setEnabledCourse(String enabledCourse) {
		this.enabledCourse = enabledCourse;
	}
	public String getEnabledPaper() {
		return enabledPaper;
	}
	public void setEnabledPaper(String enabledPaper) {
		this.enabledPaper = enabledPaper;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public Course(int courseId, String courseName, String courseDescribe, String enabledCourse, String enabledPaper,
			int categoryId) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDescribe = courseDescribe;
		this.enabledCourse = enabledCourse;
		this.enabledPaper = enabledPaper;
		this.categoryId = categoryId;
	}
	public Course() {
		super();
	}
	
}
