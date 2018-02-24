package com.refeng.model;


import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class  LotteryUser备份{
//	主键ID
    private Integer userId;
//   用户名  小写存储
    private String userName;
//    手机号
    private String phone;
//  身份证
  private String identity;
//  TB_CARD_WITHDRAW    银行卡  ACCOUNT_NO
  private String accountNo;
  //  累计消费
  
  //今日消费
  
//累计充值  TB_OSS_PAY_ORDER  PAY_MONEY
  private String  payMoney ;

  
  //账户余额  TB_USER_ACT
  private String   balabce;
  
//所属销售  RECOMMENDER
  private String recommender;
//注册时间 CREATE_TIMESTAMP
  private Date createTime;
//最后登录时间    TB_USER_EXT(act)  LAST_LOGIN_TIME 
  private Date  lastTime;
//来源
  private String client;
  //行数
private Integer count;

public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getIdentity() {
	return identity;
}
public void setIdentity(String identity) {
	this.identity = identity;
}

public Integer getCount() {
	return count;
}
public void setCount(Integer count) {
	this.count = count;
}
public Date getCreateTime() {
	return createTime;
}
public void setCreateTime(Date createTime) {
	this.createTime = createTime;
}
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}
public String getRecommender() {
	return recommender;
}
public void setRecommender(String recommender) {
	this.recommender = recommender;
}
public String getClient() {
	return client;
}
public void setClient(String client) {
	this.client = client;
}
public Date getLastTime() {
	return lastTime;
}
public void setLastTime(Date lastTime) {
	this.lastTime = lastTime;
}
public String getAccountNo() {
	return accountNo;
}
public void setAccountNo(String accountNo) {
	this.accountNo = accountNo;
}
public String getBalabce() {
	return balabce;
}
public void setBalabce(String balabce) {
	this.balabce = balabce;
}
public String getPayMoney() {
	return payMoney;
}
public void setPayMoney(String payMoney) {
	this.payMoney = payMoney;
}
}
