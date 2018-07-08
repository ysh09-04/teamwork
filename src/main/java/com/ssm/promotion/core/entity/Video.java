package com.ssm.promotion.core.entity;

/**
 * 视频
 * @author 尤少辉
 * @日期 2018年7月1日
 */
public class Video {
	private int videoId;
	private String videoType;
	private String videoName;
	private String videoUrl;
	private String videoSynopsis;
	private String enabled;
	private int sortId;
	private int playNumber;
	private int videoCategoryId;
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
	public int getvideoCategoryId() {
		return videoCategoryId;
	}
	public void setvideoCategoryId(int videoCategoryId) {
		this.videoCategoryId = videoCategoryId;
	}
	public Video(int videoId, String videoType, String videoName, String videoUrl, String videoSynopsis, String enabled,
			int sortId, int playNumber, int videoCategoryId) {
		super();
		this.videoId = videoId;
		this.videoType = videoType;
		this.videoName = videoName;
		this.videoUrl = videoUrl;
		this.videoSynopsis = videoSynopsis;
		this.enabled = enabled;
		this.sortId = sortId;
		this.playNumber = playNumber;
		this.videoCategoryId = videoCategoryId;
	}
	public Video(String videoType, String videoName, String videoUrl, String videoSynopsis, String enabled, int sortId,
			int playNumber, int videoCategoryId) {
		super();
		this.videoType = videoType;
		this.videoName = videoName;
		this.videoUrl = videoUrl;
		this.videoSynopsis = videoSynopsis;
		this.enabled = enabled;
		this.sortId = sortId;
		this.playNumber = playNumber;
		this.videoCategoryId = videoCategoryId;
	}
	public Video() {
		super();
	}
	
}
