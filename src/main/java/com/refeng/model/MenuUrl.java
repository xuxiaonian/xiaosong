package com.refeng.model;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class MenuUrl {
//	主键ID
    private Integer id;
//    菜单的名称
    private String menuName;
//    菜单的url
    private String menuUrl;
//    权重
    private Integer  weight;

	//    创建时间
    private Date  creationTime;
//    是否启用
    private Integer  state;
//    父id
    private Integer  parentId;
	
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
}