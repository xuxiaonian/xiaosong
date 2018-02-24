package com.refeng.model;


import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class  LotteryUser{
	

//	主键ID
    private Integer userId;
//   用户昵称
    private String userName;
//    真实姓名 REAL_NAME
    private String realName;
//    用户类型    USER_TYPE
    private String userType;
	//  用户状态  USER_STATUS
	private String userStatus;
	//所属销售  RECOMMENDER
	private String recommender;
	//账户余额  TB_USER_ACT
	private String   balabce;
	//注册时间 CREATE_TIMESTAMP
	private Date createTime;

public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		if(userType.equals("0")){
			userType="渠道用户";
		}else {
			userType="销售用户";
		}
		this.userType = userType;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		if(userStatus.equals("0")) {
			userStatus="注销";
		}else if(userStatus.equals("1")) {
			userStatus="活动";
		}else if(userStatus.equals("2")) {
			userStatus="锁定";
		}
		this.userStatus = userStatus;
	}
	public String getRecommender() {
		return recommender;
	}
	public void setRecommender(String recommender) {
		this.recommender = recommender;
	}
	public String getBalabce() {
		return balabce;
	}
	public void setBalabce(String balabce) {
		this.balabce = balabce;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}



}
