package com.ssm.promotion.core.dto;

import com.ssm.promotion.core.entity.Question;

public class PaperQuestionDto {
	private int paperQuestionId;
	private int paperId;
	private String paperName;
	private String paperDescription;
	private String paperType;
	private int paperTotalScore;
	private int courseId;
	private Question question = new Question();
	public int getPaperQuestionId() {
		return paperQuestionId;
	}
	public void setPaperQuestionId(int paperQuestionId) {
		this.paperQuestionId = paperQuestionId;
	}
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
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public PaperQuestionDto(int paperQuestionId, int paperId, String paperName, String paperDescription, String paperType,
			int paperTotalScore, int courseId, Question question) {
		super();
		this.paperQuestionId = paperQuestionId;
		this.paperId = paperId;
		this.paperName = paperName;
		this.paperDescription = paperDescription;
		this.paperType = paperType;
		this.paperTotalScore = paperTotalScore;
		this.courseId = courseId;
		this.question = question;
	}
	public PaperQuestionDto() {
		super();
	}
	
}
