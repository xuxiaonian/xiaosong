package com.refeng.model;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Withdrawals {

    private String userId;
    //  订单ID ORDER_ID
    private String orderId;
    // 昵称
    private String nickname;
    // 真实姓名
    private String realName;
    // 我要付账号 ACCOUNT_NO
    private String  accountNo;
    // 提现的金额 ORDER_AMOUNT
    private Float  orderAmout;
    // 手续费
    private Float  feeAmout;
    /*账户余额暂时不写*/
//   提款时间 CREATE_TIMESTAMP
    private Date createTimestamp;

    // 提现状态（1-进行中 2-已完成 3-已撤销 ）  ORDER_STATUS
    private Integer  orderStatus;
    private String   status;




    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
//        提现状态（1-进行中 2-已完成 3-已撤销 4-待审核 5-审核未通过）
        if(orderStatus==1){
            status="进行中";
        }
        if(orderStatus==2){
            status="已完成";
        }   if(orderStatus==3){
            status="已撤销";
        }
        if(orderStatus==4){
            status="待审核";
        }
        if(orderStatus==5){
            status="审核未通过";
        }
        this.orderStatus = orderStatus;
    }

    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public Float getFeeAmout() {
        return feeAmout;
    }

    public void setFeeAmout(Float feeAmout) {
        this.feeAmout = feeAmout;
    }

    public Float getOrderAmout() {
        return orderAmout;
    }

    public void setOrderAmout(Float orderAmout) {
        this.orderAmout = orderAmout;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}