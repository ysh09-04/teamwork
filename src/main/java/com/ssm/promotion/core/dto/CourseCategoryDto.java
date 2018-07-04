package com.ssm.promotion.core.dto;

import com.ssm.promotion.core.entity.Category;

/**
 * 课程和类目
 * @author 尤少辉
 * @日期 2018年7月4日
 */
public class CourseCategoryDto {
	private int courseId;
	private String courseName;
	private String courseDescribe;
	private String enabledCourse;
	private String enabledPaper;
	private Category category=new Category();
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public CourseCategoryDto(int courseId, String courseName, String courseDescribe, String enabledCourse,
			String enabledPaper, Category category) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDescribe = courseDescribe;
		this.enabledCourse = enabledCourse;
		this.enabledPaper = enabledPaper;
		this.category = category;
	}
	public CourseCategoryDto() {
		super();
	}
	
}
