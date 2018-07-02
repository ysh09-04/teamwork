package com.ssm.promotion.core.dto;

import com.ssm.promotion.core.entity.Course;

/**
 * 视频类管理课程
 * @author 尤少辉
 * @日期 2018年7月2日
 */
public class VideoCategoryCourseDto {
	private int videoCategoryId;
	private String videoCategoryName;
	private String videoCategoryDescribe;
	private Course course=new Course();
	public int getVideoCategoryId() {
		return videoCategoryId;
	}
	public void setVideoCategoryId(int videoCategoryId) {
		this.videoCategoryId = videoCategoryId;
	}
	public String getVideoCategoryName() {
		return videoCategoryName;
	}
	public void setVideoCategoryName(String videoCategoryName) {
		this.videoCategoryName = videoCategoryName;
	}
	public String getVideoCategoryDescribe() {
		return videoCategoryDescribe;
	}
	public void setVideoCategoryDescribe(String videoCategoryDescribe) {
		this.videoCategoryDescribe = videoCategoryDescribe;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public VideoCategoryCourseDto(int videoCategoryId, String videoCategoryName, String videoCategoryDescribe,
			Course course) {
		super();
		this.videoCategoryId = videoCategoryId;
		this.videoCategoryName = videoCategoryName;
		this.videoCategoryDescribe = videoCategoryDescribe;
		this.course = course;
	}
	public VideoCategoryCourseDto() {
		super();
	}
	
}
