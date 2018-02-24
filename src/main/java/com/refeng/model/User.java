package com.refeng.model;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class User {
//	主键ID
    private Integer id;
//    登入名
    private String loginName;
//    真实姓名
    private String realName;
//    密码
    private String  password;
//    角色
    private Integer  role;
    private String  rname;
//    是否启用
    private Integer  state;
    private String  tate;
//    登入的时间
    private Date  loginTime;
//  创建的时间
  private Date  establishTime;
//    手机号
    private String  phone;
//    电子邮箱
    private String  email;
//    描述
    private String  describe;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		if(state==0) {
			tate="不可用";
		}else {
			tate="可用";
		}
		this.state = state;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public Date getEstablishTime() {
		return establishTime;
	}
	public void setEstablishTime(Date establishTime) {
		this.establishTime = establishTime;
	}
	public String getTate() {
		return tate;
	}
	public void setTate(String tate) {
		this.tate = tate;
	}


}