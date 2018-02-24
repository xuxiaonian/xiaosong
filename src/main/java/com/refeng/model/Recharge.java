package com.refeng.model;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Recharge {

    //  角色Id
    private Integer userId;
    // 昵称
    private String nickname;
    // 真实姓名
    private String realName;
    // 交易充值类型  PAY_TYPE
    private Integer  payType;
//    ORDER_DESC
    private String orderDesc;
    // 充值金额 ORDER_AMOUNT
    private Float  orderAmout;
    // 手续费
    private Float  feeAmout;
    // 订单号
    private String orderId;
    // 充值时间 CREATE_TIMESTAMP
    private Date createTime;
    // 充值状态 ORDER_STATUS   OVER_FLAG(完结)
    private Integer  orderStatus;
    private String   status;
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Float getOrderAmout() {
        return orderAmout;
    }

    public void setOrderAmout(Float orderAmout) {
        this.orderAmout = orderAmout;
    }

    public Float getFeeAmout() {
        return feeAmout;
    }

    public void setFeeAmout(Float feeAmout) {
        this.feeAmout = feeAmout;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
       if(orderStatus==1){
            status="待支付";
        }
        if(orderStatus==2){
            status="已支付";
        }   if(orderStatus==3){
            status="支付失败";
        }

        this.orderStatus = orderStatus;
    }


    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}