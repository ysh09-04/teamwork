package com.ssm.promotion.core.dto;

import com.ssm.promotion.core.entity.Course;

public class PaperCourseDto {
	
	private int paperId;
	private String paperName;
	private String paperDescription;
	private String paperType;
	private int paperTotalScore;
	private Course course=new Course();
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
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public PaperCourseDto(int paperId, String paperName, String paperDescription, String paperType, int paperTotalScore,
			Course course) {
		super();
		this.paperId = paperId;
		this.paperName = paperName;
		this.paperDescription = paperDescription;
		this.paperType = paperType;
		this.paperTotalScore = paperTotalScore;
		this.course = course;
	}
	public PaperCourseDto() {
		super();
	}
	public PaperCourseDto(String paperName, String paperDescription, String paperType, int paperTotalScore,
			Course course) {
		super();
		this.paperName = paperName;
		this.paperDescription = paperDescription;
		this.paperType = paperType;
		this.paperTotalScore = paperTotalScore;
		this.course = course;
	}
	
}
