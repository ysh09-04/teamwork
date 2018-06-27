package com.ssm.promotion.core.dto;

import java.io.Serializable;
import java.util.List;

import com.ssm.promotion.core.entity.Menu;

/**
 * @description 菜单管理
 * @author chj
 * @date 创建时间：2018-4-25 下午2:31:46
 * @version 1.0
 * @since
 */
public class MenuDTO implements Serializable {
	private int id;
	private String title;
	private String icon;
	private List<Menu> menuChildList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Menu> getMenuChildList() {
		return menuChildList;
	}

	public void setMenuChildList(List<Menu> menuChildList) {
		this.menuChildList = menuChildList;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
}
