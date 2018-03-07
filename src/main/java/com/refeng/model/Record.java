package com.refeng.model;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class Record {
    @NotNull(message = "销售ID不能为空")
    private  Integer userId;
    @NotNull(message = "手机号不能为空")
    private  String phone;
    private Date time;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
