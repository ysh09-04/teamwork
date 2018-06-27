package com.ssm.promotion.core.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @description
 * @author chj
 * @date 创建时间：2018-6-21 上午11:45:12
 * @version 1.0
 * @since
 */
public class RoleAuthParentMenuDTO implements Serializable {
	private Integer id;
	private String title;
	private boolean selected;// 是否选中
	private List<RoleAuthChildMenuDTO> menuChildList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public List<RoleAuthChildMenuDTO> getMenuChildList() {
		return menuChildList;
	}

	public void setMenuChildList(List<RoleAuthChildMenuDTO> menuChildList) {
		this.menuChildList = menuChildList;
	}

}
