package com.ssm.promotion.core.entity;

/**
 * 文章
 * @author 尤少辉
 * @日期 2018年7月1日
 */
public class Article {
	private int articleId;
	private String articleType;
	private String articleTitle;
	private String articleWriter;
	private String articleContent;
	private int readNumber;
	private int courseId;
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
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public Article(int articleId, String articleType, String articleTitle, String articleWriter, String articleContent,
			int readNumber, int courseId) {
		super();
		this.articleId = articleId;
		this.articleType = articleType;
		this.articleTitle = articleTitle;
		this.articleWriter = articleWriter;
		this.articleContent = articleContent;
		this.readNumber = readNumber;
		this.courseId = courseId;
	}
	public Article() {
		super();
	}
	
}
