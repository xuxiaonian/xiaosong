package com.refeng.model;


import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class  LotteryInformation{
	

	//	主键ID
    private Integer userId;
    //  渠道ID
   
    //   用户昵称
    private String userName;
    //  用户类型    USER_TYPE
  private String userType;
  //    真实姓名 REAL_NAME
    private String realName;
    //    身份证号 PERSONAL_ID
    private String personalId;
	//  用户状态  USER_STATUS
	private String userStatus;
	//注册时间 CREATE_TIMESTAMP
	private Date createTime;
	
	//	注册渠道
	
	//最后登入时间
	private Date lastTime;
//	联系方式+++++++++++++++++++++++++++++++++
	
//	手机号
	private String phone;
//	qq号
	private String qq;
//	微信号
	private String weixin;
//	邮箱
	private String email;
//	银行相关++++++++++++++++++++++++++++++++
//	可用账户余额
	private String balanceMoney;
	//	奖金账户余额
	private String bonusMoney;
//	可使用红包余额
	private String redMoney;
//	成功购彩总金额
	private String successMoney;
//	自购总金额
	private String ownBuyMoney;
//	抄单总金额
	private String followMoney; 
//	三个月成功购彩总金额
	private String successMoney3;
//	三个月自购总金额
	private String ownBuyMoney3;
//	三个月抄单总金额
	private String followMoney3; 
//	充值总金额
	private String wholeMoney; 
//	近三个月充值金额
	private String wholeMoney3; 
//	获得总奖金
	private String  bonus;
//	近三个月的奖金
	private String  bonus3;
	
	
//	账户的类型 ACT_TYPE
	private String  actType;
	
	
	
	
	//所属销售  RECOMMENDER
	private String recommender;
	//账户余额  TB_USER_ACT
	private String   balabce;


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

	public String getPersonalId() {
		return personalId;
	}
	public void setPersonalId(String personalId) {
		this.personalId = personalId;
	}
	public Date getLastTime() {
		return lastTime;
	}
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getWeixin() {
		return weixin;
	}
	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBalanceMoney() {
		return balanceMoney;
	}
	public void setBalanceMoney(String balanceMoney) {
		this.balanceMoney = balanceMoney;
	}
	public String getBonusMoney() {
		return bonusMoney;
	}
	public void setBonusMoney(String bonusMoney) {
		this.bonusMoney = bonusMoney;
	}
	public String getRedMoney() {
		return redMoney;
	}
	public void setRedMoney(String redMoney) {
		this.redMoney = redMoney;
	}
	public String getSuccessMoney() {
		return successMoney;
	}
	public void setSuccessMoney(String successMoney) {
		this.successMoney = successMoney;
	}
	public String getOwnBuyMoney() {
		return ownBuyMoney;
	}
	public void setOwnBuyMoney(String ownBuyMoney) {
		this.ownBuyMoney = ownBuyMoney;
	}
	public String getFollowMoney() {
		return followMoney;
	}
	public void setFollowMoney(String followMoney) {
		this.followMoney = followMoney;
	}
	public String getSuccessMoney3() {
		return successMoney3;
	}
	public void setSuccessMoney3(String successMoney3) {
		this.successMoney3 = successMoney3;
	}
	public String getOwnBuyMoney3() {
		return ownBuyMoney3;
	}
	public void setOwnBuyMoney3(String ownBuyMoney3) {
		this.ownBuyMoney3 = ownBuyMoney3;
	}
	public String getFollowMoney3() {
		return followMoney3;
	}
	public void setFollowMoney3(String followMoney3) {
		this.followMoney3 = followMoney3;
	}
	public String getWholeMoney() {
		return wholeMoney;
	}
	public void setWholeMoney(String wholeMoney) {
		this.wholeMoney = wholeMoney;
	}
	public String getWholeMoney3() {
		return wholeMoney3;
	}
	public void setWholeMoney3(String wholeMoney3) {
		this.wholeMoney3 = wholeMoney3;
	}
	public String getBonus() {
		return bonus;
	}
	public void setBonus(String bonus) {
		this.bonus = bonus;
	}
	public String getBonus3() {
		return bonus3;
	}
	public void setBonus3(String bonus3) {
		this.bonus3 = bonus3;
	}
	public String getActType() {
		return actType;
	}
	public void setActType(String actType) {
		this.actType = actType;
	}

}
