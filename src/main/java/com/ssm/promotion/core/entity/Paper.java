package com.ssm.promotion.core.entity;

/**
 * 考卷
 * @author 尤少辉
 * @日期 2018年7月1日
 */
public class Paper {
	private int paperId;
	private String paperName;
	private String paperDescription;
	private String paperType;
	private int paperTotalScore;
	private int courseId;
	public int getPaperId() {
		return paperId;
	}
	public void setPaperId(int paperId) {
		this.paperId = paperId;
	}
	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	public String getPaperDescription() {
		return paperDescription;
	}
	public void setPaperDescription(String paperDescription) {
		this.paperDescription = paperDescription;
	}
	public String getPaperType() {
		return paperType;
	}
	public void setPaperType(String paperType) {
		this.paperType = paperType;
	}
	public int getPaperTotalScore() {
		return paperTotalScore;
	}
	public void setPaperTotalScore(int paperTotalScore) {
		this.paperTotalScore = paperTotalScore;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public Paper(int paperId, String paperName, String paperDescription, String paperType, int paperTotalScore,
			int courseId) {
		super();
		this.paperId = paperId;
		this.paperName = paperName;
		this.paperDescription = paperDescription;
		this.paperType = paperType;
		this.paperTotalScore = paperTotalScore;
		this.courseId = courseId;
	}
	public Paper() {
		super();
	}
	
}
