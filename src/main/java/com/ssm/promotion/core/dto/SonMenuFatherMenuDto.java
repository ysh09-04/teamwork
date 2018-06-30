package com.ssm.promotion.core.dto;

import com.ssm.promotion.core.entity.FatherMenu;

/**
 * 子菜单关联父菜单
 * @author 尤少辉
 * @日期 2018年6月30日
 */
public class SonMenuFatherMenuDto {
	private int sonMenuId;
	private String menuName;
	private String muneUrl;
	private String muneDescribe;
    private String icon;
    private FatherMenu fatherMenu=new FatherMenu();
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
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public FatherMenu getFatherMenu() {
		return fatherMenu;
	}
	public void setFatherMenu(FatherMenu fatherMenu) {
		this.fatherMenu = fatherMenu;
	}
	public SonMenuFatherMenuDto(int sonMenuId, String menuName, String muneUrl, String muneDescribe, String icon,
			FatherMenu fatherMenu) {
		super();
		this.sonMenuId = sonMenuId;
		this.menuName = menuName;
		this.muneUrl = muneUrl;
		this.muneDescribe = muneDescribe;
		this.icon = icon;
		this.fatherMenu = fatherMenu;
	}
	public SonMenuFatherMenuDto() {
		super();
	}
    
}
