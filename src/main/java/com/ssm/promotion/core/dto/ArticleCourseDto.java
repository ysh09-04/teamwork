package com.ssm.promotion.core.dto;

import com.ssm.promotion.core.entity.Course;


public class ArticleCourseDto {
	private int articleId;
	private String articleType;
	private String articleTitle;
	private String articleWriter;
	private String articleContent;
	private int readNumber;
	private Course course =new Course();
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getArticleType() {
		return articleType;
	}
	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public String getArticleWriter() {
		return articleWriter;
	}
	public void setArticleWriter(String articleWriter) {
		this.articleWriter = articleWriter;
	}
	public String getArticleContent() {
		return articleContent;
	}
	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
	public int getReadNumber() {
		return readNumber;
	}
	public void setReadNumber(int readNumber) {
		this.readNumber = readNumber;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public ArticleCourseDto(int articleId, String articleType, String articleTitle, String articleWriter,
			String articleContent, int readNumber, Course course) {
		super();
		this.articleId = articleId;
		this.articleType = articleType;
		this.articleTitle = articleTitle;
		this.articleWriter = articleWriter;
		this.articleContent = articleContent;
		this.readNumber = readNumber;
		this.course = course;
	}
	public ArticleCourseDto(String articleType, String articleTitle, String articleWriter, String articleContent,
			int readNumber, Course course) {
		super();
		this.articleType = articleType;
		this.articleTitle = articleTitle;
		this.articleWriter = articleWriter;
		this.articleContent = articleContent;
		this.readNumber = readNumber;
		this.course = course;
	}
	public ArticleCourseDto() {
		super();
	}
	@Override
	public String toString() {
		return "ArticleCourseDto [articleId=" + articleId + ", articleType=" + articleType + ", articleTitle="
				+ articleTitle + ", articleWriter=" + articleWriter + ", articleContent=" + articleContent
				+ ", readNumber=" + readNumber + ", course=" + course + "]";
	}
	
	
	
	
}
