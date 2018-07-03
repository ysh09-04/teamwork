package com.ssm.promotion.core.dto;

import com.ssm.promotion.core.entity.VideoCategory;

/**
 * 视频管理视频类目
 * @author 尤少辉
 * @日期 2018年7月3日
 */
public class VideoVideoCategoryDto {
	private int videoId;
	private String videoType;
	private String videoName;
	private String videoUrl;
	private String videoSynopsis;
	private String enabled;
	private int sortId;
	private int playNumber;
	private VideoCategory videoCategory=new VideoCategory();
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public String getVideoType() {
		return videoType;
	}
	public void setVideoType(String videoType) {
		this.videoType = videoType;
	}
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public String getVideoSynopsis() {
		return videoSynopsis;
	}
	public void setVideoSynopsis(String videoSynopsis) {
		this.videoSynopsis = videoSynopsis;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public int getSortId() {
		return sortId;
	}
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}
	public int getPlayNumber() {
		return playNumber;
	}
	public void setPlayNumber(int playNumber) {
		this.playNumber = playNumber;
	}
	public VideoCategory getVideoCategory() {
		return videoCategory;
	}
	public void setVideoCategory(VideoCategory videoCategory) {
		this.videoCategory = videoCategory;
	}
	public VideoVideoCategoryDto(int videoId, String videoType, String videoName, String videoUrl, String videoSynopsis,
			String enabled, int sortId, int playNumber, VideoCategory videoCategory) {
		super();
		this.videoId = videoId;
		this.videoType = videoType;
		this.videoName = videoName;
		this.videoUrl = videoUrl;
		this.videoSynopsis = videoSynopsis;
		this.enabled = enabled;
		this.sortId = sortId;
		this.playNumber = playNumber;
		this.videoCategory = videoCategory;
	}
	public VideoVideoCategoryDto() {
		super();
	}
	
}
