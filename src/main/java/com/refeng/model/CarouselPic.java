package com.refeng.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
/*
* 轮播图的实体类
* */
@Component
public class CarouselPic {
    //	主键ID
    private Integer id;
    //    推广平台 1 ：ios  2：android 3：h5
    private Integer platform;
    private String platform1;
    //    活动标题
    private String  title;
    //    图片的上传地址
    private String  picUrl;
    //    活动时间
    @DateTimeFormat(style = "MM")
    private Date  startActivityTime;

    @DateTimeFormat(style = "MM")
    private Date  endActivityTime;

    //    显示时间
    @DateTimeFormat(style = "MM")
    private Date  startExhibitionTime;

    @DateTimeFormat(style = "MM")
    private Date  endExhibitionTime;

    //显示位置
    private Integer exhibitionPosition;
    private String exhibitionPosition1;
    //    显示位置权重
    private Integer exhibitionPositionWeight;
    //    图片的活动类型
    private Integer type;
    //    活动url
    private String  exhibitionUrl;
    //    渠道号
    private String  channel;
    //    活动状态
    private Integer state;
    private String state1;
    //    活动详情
    private String  details;
    //     创建时间
    private Date  establishTime;
    //    创始人
    private String  founder;

    public CarouselPic() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        //        1 ：ios  2：android 3：h5


        this.id = id;
    }

    public Integer  getPlatform() {


        return platform;
    }

    public void setPlatform(Integer platform) {

            if(platform==1){
                platform1="ios";
            }
            if(platform==2){
                platform1="android";
            } if(platform==3){
                platform1="h5";
            }

        this.platform = platform;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Date getStartActivityTime() {

        return startActivityTime;
    }
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    public void setStartActivityTime(String startActivityTime) {
        if(startActivityTime!=null){
            try {
            this.startActivityTime=format.parse(startActivityTime);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }else{
            this.startActivityTime = null;
        }

    }

    public Date getEndActivityTime() {
        return endActivityTime;
    }

    public void setEndActivityTime(String endActivityTime) {
        if(endActivityTime!=null){
            try {
                this.endActivityTime=format.parse(endActivityTime);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }else{
            this.endActivityTime = null;
        }
    }

    public Date getStartExhibitionTime() {
        return startExhibitionTime;
    }

    public void setStartExhibitionTime(String startExhibitionTime) {
        if(startExhibitionTime!=null){
            try {
                this.startExhibitionTime=format.parse(startExhibitionTime);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }else{
            this.startExhibitionTime = null;
        }
    }

    public Date getEndExhibitionTime() {
        return endExhibitionTime;
    }

    public void setEndExhibitionTime(String endExhibitionTime) {
        if(endExhibitionTime!=null){
            try {
                this.endExhibitionTime=format.parse(endExhibitionTime);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }else{
            this.endExhibitionTime = null;
        }
    }

    public Integer getExhibitionPosition() {


        return exhibitionPosition;
    }

    public void setExhibitionPosition(Integer exhibitionPosition) {
        if(exhibitionPosition==1){
            exhibitionPosition1="首页轮播图";
        }
        this.exhibitionPosition = exhibitionPosition;
    }

    public Integer getExhibitionPositionWeight() {
        return exhibitionPositionWeight;
    }

    public void setExhibitionPositionWeight(Integer exhibitionPositionWeight) {
        this.exhibitionPositionWeight = exhibitionPositionWeight;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getExhibitionUrl() {
        return exhibitionUrl;
    }

    public void setExhibitionUrl(String exhibitionUrl) {
        this.exhibitionUrl = exhibitionUrl;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Integer getState() {


        return state;
    }

    public void setState(Integer state) {
if(state!=null){
    if(state==0){
        state1="未开始";
    }
    if(state==1){
        state1="进行中";
    }
    if(state==2){
        state1="已结束";
    }

}
        this.state = state;
    }

    public String getDetails() {

        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


    public Date getEstablishTime() {
        return establishTime;
    }

    public void setEstablishTime(Date establishTime) {
        this.establishTime = establishTime;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String getPlatform1() {
        return platform1;
    }

    public void setPlatform1(String platform1) {
        this.platform1 = platform1;
    }

    public String getExhibitionPosition1() {
        return exhibitionPosition1;
    }

    public void setExhibitionPosition1(String exhibitionPosition1) {
        this.exhibitionPosition1 = exhibitionPosition1;
    }

    public String getState1() {
        return state1;
    }

    public void setState1(String state1) {
        this.state1 = state1;
    }

}