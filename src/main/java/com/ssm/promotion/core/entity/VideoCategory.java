package com.ssm.promotion.core.entity;

/**
 * 视频类目
 * @author 尤少辉
 * @日期 2018年7月1日
 */
public class VideoCategory {
	private int videoCategoryId;
	private String videoCategoryName;
	private String videoCategoryDescribe;
	private int courseId;
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
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public VideoCategory(int videoCategoryId, String videoCategoryName, String videoCategoryDescribe, int courseId) {
		super();
		this.videoCategoryId = videoCategoryId;
		this.videoCategoryName = videoCategoryName;
		this.videoCategoryDescribe = videoCategoryDescribe;
		this.courseId = courseId;
	}
	public VideoCategory() {
		super();
	}
	
}
