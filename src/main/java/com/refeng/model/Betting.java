package com.refeng.model;


import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Betting {
//	订单编号  ORDER_ID
private String orderId;
//	购买时间 BUY_TIMESTAMP
private Date buyTime;
// 期号  BATCH_ID
private String batchId;
// 彩种名称  LOTTERY_ID
private String lotteryId;
// 方案编号 PROGRAM_ID
private String programId;
// 发起人   TB_PROGRAM_INFO
private String infoUser;
// 方案金额
//  购买金额  REAL_AMOUNT
private Float realAmout;
// 购买类型  BUY_TYPE
private String  buyType;
//	出票状态    TB_ORDER_ISSUE   : ORDER_STATUS
private String  issueOrderStaus;
// 支付状态  ORDER_STATUS
private String  orderStatus;
// 方案奖金
// 获得奖金  BONUS_AMOUNT
private Float bonusAmout;

	public Float getBonusAmout() {
		return bonusAmout;
	}

	public void setBonusAmout(Float bonusAmout) {
		this.bonusAmout = bonusAmout;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
//		订单状态（0-未付款  1-已付款 2-过期关闭
		if (orderStatus.equals("0")){
			orderStatus="未付款";
		}
		if (orderStatus.equals("1")){
			orderStatus="已付款";
		}if (orderStatus.equals("2")){
			orderStatus="过期关闭";
		}

		this.orderStatus = orderStatus;
	}



	public Float getRealAmout() {
		return realAmout;
	}

	public void setRealAmout(Float realAmout) {
		this.realAmout = realAmout;
	}

	public String getInfoUser() {
		return infoUser;
	}

	public void setInfoUser(String infoUser) {
		this.infoUser = infoUser;
	}

	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	public String getLotteryId() {
		return lotteryId;
	}

	public void setLotteryId(String lotteryId) {
		this.lotteryId = lotteryId;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public Date getBuyTime() {
		return buyTime;
	}

	public void setBuyTime(Date buyTime) {
		this.buyTime = buyTime;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getIssueOrderStaus() {
		return issueOrderStaus;
	}

	public void setIssueOrderStaus(String issueOrderStaus) {
		this.issueOrderStaus = issueOrderStaus;
	}

	public String getBuyType() {
		return buyType;
	}

	public void setBuyType(String buyType) {
//	（0-用户自选 1-合买发起认购 2-参与合买认购 3-系统补单）
		if(buyType.equals("0")){
			buyType="用户自选";
		}
		if(buyType.equals("1")){
			buyType="合买发起认购";
		}if(buyType.equals("2")){
			buyType="参与合买认购";
		}if(buyType.equals("3")){
			buyType="系统补单";
		}


		this.buyType = buyType;
	}
}
