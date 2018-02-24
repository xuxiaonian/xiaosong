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
    private String income;
//	支出
    private String expenditure;
//	手续费
    private String procedures;
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
		this.type = type;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	public String getExpenditure() {
		return expenditure;
	}
	public void setExpenditure(String expenditure) {
		this.expenditure = expenditure;
	}
	public String getProcedures() {
		return procedures;
	}
	public void setProcedures(String procedures) {
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
