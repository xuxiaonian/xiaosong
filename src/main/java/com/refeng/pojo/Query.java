package com.refeng.pojo;


import java.util.Date;



public class Query {
 
//    模式
    private Integer mode;
//  检索
  private Integer retrieval;
    
 //关键字
 private String  name;
    
 //类型
 private Integer  type;
 //状态
 private Integer  state;

    
    //   开始时间
    private Date  startTime;
	//    结束时间
    private Date endTime;
    
//  开始时间1
   private String  startTime1;
	//    结束时间1
   private String endTime1;
// 页
 private Integer pageNum;
//数量
private Integer size;

	//关键字
	private String  order;



//passWord

//userId


public Integer getMode() {
	return mode;
}
public void setMode(Integer mode) {
	this.mode = mode;
}
public Integer getRetrieval() {
	return retrieval;
}
public void setRetrieval(Integer retrieval) {
	this.retrieval = retrieval;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getType() {
	return type;
}
public void setType(Integer type) {
	this.type = type;
}
public Integer getState() {
	return state;
}
public void setState(Integer state) {
	this.state = state;
}
public Date getStartTime() {
	return startTime;
}
public void setStartTime(Date startTime) {
	this.startTime = startTime;
}
public Date getEndTime() {
	return endTime;
}
public void setEndTime(Date endTime) {
	this.endTime = endTime;
}
public String getStartTime1() {
	return startTime1;
}
public void setStartTime1(String startTime1) {
	this.startTime1 = startTime1;
}
public String getEndTime1() {
	return endTime1;
}
public void setEndTime1(String endTime1) {
	this.endTime1 = endTime1;
}
public Integer getPageNum() {
	return pageNum;
}
public void setPageNum(Integer pageNum) {
	this.pageNum = pageNum;
}
public Integer getSize() {
	return size;
}
public void setSize(Integer size) {
	this.size = size;
}


	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
}