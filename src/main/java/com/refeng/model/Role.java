package com.refeng.model;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Role {
//	主键ID
    private Integer id;
//  角色名称
    private String name;
//    创建时间
    private Date time;

	//  是否启用
    private Integer  state;
//  权限
    private String  powerUrl;
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getPowerUrl() {
		return powerUrl;
	}
	public void setPowerUrl(String powerUrl) {
		this.powerUrl = powerUrl;
	}


}