package com.ssm.promotion.core.entity;

/**
 * 教师表
 * @author 尤少辉
 * @日期 2018年6月27日
 */
public class Teacher {
	private int tid;
	private String tname;
	private String sex;
	private int age;
	private String hobbies;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	public Teacher(int tid, String tname, String sex, int age, String hobbies) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.sex = sex;
		this.age = age;
		this.hobbies = hobbies;
	}
	public Teacher() {
		super();
	}
	
}
