package com.refeng.model;

import java.util.Date;

public class Recharce {
    //    ORDER_ID   订单 ID
    private String orderId;

//    USER_ID   用户ID
     private Integer userId;
//    PAY_TYPE  支付方式
      private Integer paytype;
//    ORDER_AMOUNT  订单金额
     private float amout;
//    FEE_AMOUNT   手续费
     private float fee;
//    REAL_AMOUNT  实际到账金额
      private float real;
//    ORDER_STATUS  订单状态（1-待支付 2-已支付 3-支付失败）
     private Integer status;
//    OVER_FLAG   完结标识（0-未完成 1-已完成）
      private Integer flag;
//    CREATE_TIMESTAMP  订单创建时间
      private Date create;
//    TRANSACT_TIMESTAMP  交易完成时间
         private Date transact;
//    ORDER_DESC 订单描述
private String desc;
//    REMARK   系统备注（系统内部用，不对用户开放）
private String remark;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPaytype() {
        return paytype;
    }

    public void setPaytype(Integer paytype) {
        this.paytype = paytype;
    }

    public float getAmout() {
        return amout;
    }

    public void setAmout(float amout) {
        this.amout = amout;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }

    public float getReal() {
        return real;
    }

    public void setReal(float real) {
        this.real = real;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public Date getTransact() {
        return transact;
    }

    public void setTransact(Date transact) {
        this.transact = transact;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
