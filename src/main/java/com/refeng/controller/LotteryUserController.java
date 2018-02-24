package com.refeng.controller;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.refeng.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.refeng.pojo.MenuUrlList;
import com.refeng.pojo.Query;
import com.refeng.service.LotteryUserService;
import com.refeng.service.UserService;

@Controller
public class LotteryUserController {


	@Autowired
	private UserService userService;
	@Autowired
	private LotteryUserService lotteryUserService;

	
	@RequestMapping("/admin/lotteryUser/list")
public String lotteryUserList(@Valid Query query , Model model,HttpServletRequest request)   {
	     query= query(query);

		
		
		
		List<LotteryUser>  lotteryUserList =lotteryUserService.lotteryUserList(query);
		model.addAttribute("lotteryUserList",lotteryUserList);
		model.addAttribute("query",query);
		
		
		
		
		
		//获得当前页
		int page =query.getPageNum();
        model.addAttribute("pageNum", query.getPageNum());
        //获得一页显示的条数
        model.addAttribute("pageSize", 10);
        //是否是第一页
        model.addAttribute("isFirstPage", (query.getPageNum()==1)?true:false);
        //获得总页数
        Integer	lotteryUserSize=1;
        if(lotteryUserList.size()>0) {
        	lotteryUserSize=lotteryUserService.lotterycount(query);
        }
        Integer max=(int)Math.ceil((double)lotteryUserSize/(double)10);
        if(max<10) {
        	model.addAttribute("start", 1);
        	model.addAttribute("totalPages", max);
        }else {
        	if(page<10) {
        		
        	}else {
        		Integer ss=(int) Math.floor(page/10);
        		model.addAttribute("start",ss+1);
        		if(max>ss+10) {
        			
        		}else {
        			model.addAttribute("totalPages",max);
        		}
            
        	}
        }
        //是否是最后一页
        model.addAttribute("isLastPage",(max==page)?true:false);
		return "lottery/userList";
	}



	/**
	 * 用户的基本信息的展示
	 * @param model
	 * @return
	 */
	@GetMapping("/admin/lotteryUser/byUserId")
	public String byUserId(Model model,Integer userId, HttpServletRequest request) {

		LotteryInformation  byUserId =lotteryUserService.byUserId(userId);
		model.addAttribute("lottery",byUserId);
		return "lottery/byIdNews";
	}
	
	
	/**
	 * 修改密码
	 * @param sssuserId
	 * @param password
	 * @param model
	 * @param request
	 * @param response
	 */
	@RequestMapping("/admin/lotteryUser/update")
       public void updatePassword(String sssuserId , String password , Model model,HttpServletRequest request, HttpServletResponse response)   {	
	Integer  type =lotteryUserService.updatePssword(sssuserId,password);
	try {
		response.sendRedirect("/admin/lotteryUser/list");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
	}
	
	
	
	/**
	 * 用户账户明细
	 * @param model

	 * @return
	 */
	@GetMapping("/admin/lotteryUser/accountId")
	public String accountId(Model model,Integer userId, HttpServletRequest request) {

		List<Account>  accountList = lotteryUserService.accountList(userId);
		model.addAttribute("lottery",accountList);
		return "lottery/byIdNews";
	}
	
	
	/**
	 * 用户投注记录
	 * @param model

	 * @return
	 */
	@GetMapping("/admin/lotteryUser/bettingId")
	public String bettingId(@Valid Query query ,Model model,Integer userId, HttpServletRequest request) {
		List<Betting>  bettingList =lotteryUserService.bettingId(userId);
		model.addAttribute("bettingList",bettingList);
		model.addAttribute("query",query);
		return "lottery/bettingList";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/**
	 * query 的初始化
	 *
	 * @return
	 */
	public Query query(Query query) {
		if(query.getPageNum()==null) {
    	    	query.setPageNum(1);
    	}
    	if(query.getSize()==null) {
    		query.setSize(10);
    	}
    	if(query.getRetrieval()==null) {
    		query.setRetrieval(0);
    	}

    	  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	 if(query.getStartTime1()!=null) {
    		 Date date;
			try {
				 if(!query.getStartTime1().isEmpty()) {
				date = format.parse(query.getStartTime1());
				  query.setStartTime(date);
				 }
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

    	 }
    	 if(query.getEndTime1()!=null ) {
    		 Date date;
			try {
				 if(!query.getEndTime1().isEmpty()) {
				date = format.parse(query.getEndTime1());
				  query.setEndTime(date);
				 }
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

    	 }
		return query;

	}

	
}
