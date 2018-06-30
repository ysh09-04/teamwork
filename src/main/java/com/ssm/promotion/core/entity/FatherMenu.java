package com.ssm.promotion.core.entity;

/**
 * 父菜单
 * @author 尤少辉
 * @日期 2018年6月30日
 */
public class FatherMenu {
	private int fatherMenuId;
	private String menuName;
	private String muneDescribe;
	private String icon;
	
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public int getFatherMenuId() {
		return fatherMenuId;
	}
	public void setFatherMenuId(int fatherMenuId) {
		this.fatherMenuId = fatherMenuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMuneDescribe() {
		return muneDescribe;
	}
	public void setMuneDescribe(String muneDescribe) {
		this.muneDescribe = muneDescribe;
	}
	
	public FatherMenu(int fatherMenuId, String menuName, String muneDescribe, String icon) {
		super();
		this.fatherMenuId = fatherMenuId;
		this.menuName = menuName;
		this.muneDescribe = muneDescribe;
		this.icon = icon;
	}
	public FatherMenu() {
		super();
	}
	
}
