package com.ssm.promotion.core.entity;

/**
 * 子菜单
 * @author 尤少辉
 * @日期 2018年6月30日
 */
public class SonMenu {
	private int sonMenuId;
	private String menuName;
	private String muneUrl;
	private String muneDescribe;
    private int fatherMenuId;
    private String icon;
	
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public int getSonMenuId() {
		return sonMenuId;
	}
	public void setSonMenuId(int sonMenuId) {
		this.sonMenuId = sonMenuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMuneUrl() {
		return muneUrl;
	}
	public void setMuneUrl(String muneUrl) {
		this.muneUrl = muneUrl;
	}
	public String getMuneDescribe() {
		return muneDescribe;
	}
	public void setMuneDescribe(String muneDescribe) {
		this.muneDescribe = muneDescribe;
	}
	public int getFatherMenuId() {
		return fatherMenuId;
	}
	public void setFatherMenuId(int fatherMenuId) {
		this.fatherMenuId = fatherMenuId;
	}
	
	public SonMenu(int sonMenuId, String menuName, String muneUrl, String muneDescribe, int fatherMenuId, String icon) {
		super();
		this.sonMenuId = sonMenuId;
		this.menuName = menuName;
		this.muneUrl = muneUrl;
		this.muneDescribe = muneDescribe;
		this.fatherMenuId = fatherMenuId;
		this.icon = icon;
	}
	public SonMenu() {
		super();
	}
    
}
