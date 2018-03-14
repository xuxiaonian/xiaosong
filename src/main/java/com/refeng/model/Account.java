package com.refeng.model;


import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class  Account{
	//交易时间 
	private Date dealTime;
//	订单ID
    private String orderId;

//	购彩id
    private String lotteryId;

//	类型
    private String type;
//	收入
    private Float income;
//	支出
    private Float expenditure;
//	手续费
    private Float procedures;
//    支付说明
    private String payment;
    
//    现金账户余额Cash account balance
    private String cbalance;
    
//    非现金账户余额  Non cash account balance
    private String nbalance;
//    管理员说明
    private String adminExplain;
//    管理员名字
    private String admin;
	public Date getDealTime() {
		return dealTime;
	}
	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getLotteryId() {
		return lotteryId;
	}
	public void setLotteryId(String lotteryId) {
		this.lotteryId = lotteryId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
//		认购类型（0-用户自选 1-合买发起认购 2-参与合买认购 3-系统补单）
		if(type.equals("0")){
			type	="用户自选";
		}
		if(type.equals("1")){
			type	="合买发起认购";
		}if(type.equals("2")){
			type	="参与合买认购";
		}if(type.equals("3")){
			type	="系统补单";
		}


		this.type = type;
	}
	public Float getIncome() {
		return income;
	}
	public void setIncome(Float income) {
		this.income = income;
	}
	public Float getExpenditure() {
		return expenditure;
	}
	public void setExpenditure(Float expenditure) {
		this.expenditure = expenditure;
	}
	public Float getProcedures() {
		return procedures;
	}
	public void setProcedures(Float procedures) {
		this.procedures = procedures;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getCbalance() {
		return cbalance;
	}
	public void setCbalance(String cbalance) {
		this.cbalance = cbalance;
	}
	public String getNbalance() {
		return nbalance;
	}
	public void setNbalance(String nbalance) {
		this.nbalance = nbalance;
	}
	public String getAdminExplain() {
		return adminExplain;
	}
	public void setAdminExplain(String adminExplain) {
		this.adminExplain = adminExplain;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
    
    
}
