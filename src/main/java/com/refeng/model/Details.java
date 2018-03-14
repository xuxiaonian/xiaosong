package com.refeng.model;


import com.refeng.model.Match;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class  Details{
    //   方案Id
    private String pId;
//    玩法
private String  lotteryType;
// 注数
private String  itemsCount;
    // 过关方式
    private String  type;
// 倍数
private String  timesCount;
//  出票状态
private String  orderStatus;
// 中奖情况
private String  bonusFlag;
    //    金额
    private Float money;
    //  过关方式
    private String subName;
    // 赛事
    private String list;
    private List<Match> dList;


    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public List<Match> getdList() {
        return dList;
    }

    public void setdList(List<Match> dList) {
        this.dList = dList;
    }

    public String getLotteryType() {
        return lotteryType;
    }

    public void setLotteryType(String lotteryType) {
        this.lotteryType = lotteryType;
    }

    public String getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(String itemsCount) {
        this.itemsCount = itemsCount;
    }

    public String getTimesCount() {
        return timesCount;
    }

    public void setTimesCount(String timesCount) {
        this.timesCount = timesCount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
//        订单状态（0-未出票 1-出票中 2-出票失败 3-出票成功 4-部分成功）
        if(orderStatus.equals("0")){
            orderStatus="未出票";
        }
        if(orderStatus.equals("1")){
            orderStatus="出票中";
        }
        if(orderStatus.equals("2")){
            orderStatus="出票失败";
        }
        if(orderStatus.equals("3")){
            orderStatus="出票成功";
        }
        if(orderStatus.equals("4")){
            orderStatus="部分成功";
        }
        this.orderStatus = orderStatus;
    }

    public String getBonusFlag() {
        return bonusFlag;
    }

    public void setBonusFlag(String bonusFlag) {
//        中奖标识（0-待开奖 1-未中奖 2-已中奖）
        if(bonusFlag.equals("0")){
            bonusFlag="待开奖";
        }
        if(bonusFlag.equals("1")){
            bonusFlag="未中奖";
        }
        if(bonusFlag.equals("2")){
            bonusFlag="已中奖";
        }
        this.bonusFlag = bonusFlag;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
