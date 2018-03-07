package com.refeng.model;



import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SaleUser {


    //	主键ID
    private Integer userId;

    //	主键ID
    private String password;
    private String userName;
    //    姓名
    private String name;

    //	手机号
    private String phone;
    //	销售级别
    private Integer role;
    private String srole;
    // 所属上级
    private Integer pname;
    private String spname;
    // 所属级别
    private Integer levels;
    private String level;
    // 入职日期
    private Date time;
    // 总金额
    private Float amount;
    // 自购
    private Float ownAmount;
    // 跟单
    private Float followAmount;
    // 被跟单
    private Float beFollowedAmount;
    // 总用户数


    private Integer count;
    private String counts;
    private String qq;
    private String weixin;
    private String email;
    private Integer  userIdCreate;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getPname() {
        return pname;
    }

    public void setPname(Integer pname) {
        this.pname = pname;
    }



    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Float getOwnAmount() {
        return ownAmount;
    }

    public void setOwnAmount(Float ownAmount) {
        this.ownAmount = ownAmount;
    }

    public Float getFollowAmount() {
        return followAmount;
    }

    public void setFollowAmount(Float followAmount) {
        this.followAmount = followAmount;
    }

    public Float getBeFollowedAmount() {
        return beFollowedAmount;
    }

    public void setBeFollowedAmount(Float beFollowedAmount) {
        this.beFollowedAmount = beFollowedAmount;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
     if(count==0){
         counts="禁用";
     }
        if(count==1){
            counts="启用";
        }
        this.count = count;
    }

    public String getSrole() {
        return srole;
    }

    public void setSrole(String srole) {
        this.srole = srole;
    }

    public String getSpname() {
        return spname;
    }

    public void setSpname(String spname) {
        this.spname = spname;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Integer getLevels() {
        return levels;
    }

    public void setLevels(Integer levels) {
        if (levels==0){
            level="总监";
        }
        if (levels==1){
            level="经理";
        }
        if (levels==2){
            level="主管";
        }
        if (levels==3){
            level="销售人员";
        }
        this.levels = levels;
    }

    public Integer getUserIdCreate() {
        return userIdCreate;
    }

    public void setUserIdCreate(Integer userIdCreate) {
        this.userIdCreate = userIdCreate;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCounts() {
        return counts;
    }

    public void setCounts(String counts) {
        this.counts = counts;
    }
}
