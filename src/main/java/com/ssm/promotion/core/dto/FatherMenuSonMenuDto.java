package com.ssm.promotion.core.dto;

import java.util.ArrayList;
import java.util.List;

import com.ssm.promotion.core.entity.SonMenu;

/**
 * 父子菜单
 * @author 尤少辉
 * @日期 2018年6月30日
 */
public class FatherMenuSonMenuDto {
	private int fatherMenuId;
	private String menuName;
	private String muneDescribe;
	private List<SonMenu> sonMenus=new ArrayList<SonMenu>();
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
	public List<SonMenu> getSonMenus() {
		return sonMenus;
	}
	public void setSonMenus(List<SonMenu> sonMenus) {
		this.sonMenus = sonMenus;
	}
	
	public FatherMenuSonMenuDto(int fatherMenuId, String menuName, String muneDescribe, List<SonMenu> sonMenus,
			String icon) {
		super();
		this.fatherMenuId = fatherMenuId;
		this.menuName = menuName;
		this.muneDescribe = muneDescribe;
		this.sonMenus = sonMenus;
		this.icon = icon;
	}
	public FatherMenuSonMenuDto() {
		super();
	}
	
}
