package com.refeng.service;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import com.refeng.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.refeng.mapper.LotteryUserMapper;
import com.refeng.pojo.Query;
import com.refeng.util.StringTools;



@Service
public class LotteryUserService  {
    @Autowired
    private LotteryUserMapper lotteryUserMapper;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 查询用户列表信息;
     * @return
     */
    public List<LotteryUser> lotteryUserList(Query query){
    
    	List<LotteryUser> lotteryUserList = lotteryUserMapper.lotteryUserList(query);
    	logger.error(lotteryUserList.toString());
        return lotteryUserList;
        
        
    }
    /**
     * 查询用户列表信息;
     * @return
     */
    public Integer lotterycount(Query query){
    	Integer count=lotteryUserMapper.lotterycount(query);
        return count;
        
        
    }
    /**
     * 查询用户基本信息;
     * @return
     */
	public LotteryInformation byUserId(Integer userId) {
		// TODO Auto-generated method stub
		LotteryInformation lotteryInformation=lotteryUserMapper.byUserId(userId);
		List <LotteryInformation> lotList=lotteryUserMapper.lotList(userId);
		for(LotteryInformation lot:lotList) {
			if(lot.getActType().equals("1000")) {
//				可用账户余额
//				private String balanceMoney;
//				//	奖金账户余额
//				private String bonusMoney;
////				可使用红包余额
//				private String redMoney;
//				账户类型（1000-奖金账户 2000-投注账户 3000-赠款账户）
				lotteryInformation.setBonusMoney(lot.getBalanceMoney());	
			}
			if(lot.getActType().equals("2000")) {
//				账户类型（1000-奖金账户 2000-投注账户 3000-赠款账户）
				lotteryInformation.setBalanceMoney(lot.getBalanceMoney());	
			}
			if(lot.getActType().equals("3000")) {
//				账户类型（1000-奖金账户 2000-投注账户 3000-赠款账户）
				lotteryInformation.setRedMoney(lot.getBalanceMoney());	
			}
		}
		Date dNow = new Date();   //当前时间
		Date dBefore = new Date();
		Calendar calendar = Calendar.getInstance(); //得到日历
		calendar.setTime(dNow);//把当前时间赋给日历
		calendar.add(calendar.MONTH, -3);  //设置为前3月
		dBefore = calendar.getTime();   //得到前3月的时间
		Integer s1=lotteryUserMapper.successMoney(userId);
//		成功购彩总金额
		if(s1!=null){
			lotteryInformation.setSuccessMoney(s1.toString());
		}

//		自购总金额
		Integer s2=lotteryUserMapper.ownBuyMoney(userId);
		if(s2!=null) {
			lotteryInformation.setOwnBuyMoney(s2.toString());
		}
//		抄单总金额
		Integer s3=lotteryUserMapper.followMoney(userId);
		if (s3!=null){
			lotteryInformation.setFollowMoney(s3.toString());
		}

//		三个月成功购彩总金额
		Integer s4=lotteryUserMapper.successMoney3(userId,dBefore);
		if (s4!=null){
		lotteryInformation.setSuccessMoney3(s4.toString());
		}
		//		三个月自购总金额
			Integer s5=lotteryUserMapper.ownBuyMoney3(userId,dBefore);
			if (s5!=null){
		lotteryInformation.setOwnBuyMoney3(s5.toString());
			}
//		三个月抄单总金额
			Integer s6=lotteryUserMapper.followMoney3(userId,dBefore);
			if (s6!=null){
		lotteryInformation.setFollowMoney3(s6.toString());
			}
//		充值总金额
			Integer s7=lotteryUserMapper.wholeMoney(userId);
			if (s7!=null){
		lotteryInformation.setWholeMoney(s7.toString());
			}
//		近三个月充值金额
			Integer s8=lotteryUserMapper.wholeMoney3(userId,dBefore);
			if (s8!=null){
		lotteryInformation.setWholeMoney3(s8.toString());
			}
//		获得总奖金
			Integer s9=lotteryUserMapper.bonus(userId);
			if (s9!=null){
		lotteryInformation.setBonus(s9.toString());
			}
//		近三个月的奖金
			Integer s10=lotteryUserMapper.bonus3(userId,dBefore);
			if (s10!=null){
		lotteryInformation.setBonus3(s10.toString());
			}
		
		return lotteryInformation;
	}
	
	   /**
     * 修改密码;
     * @return
     */
	public Integer updatePssword(String userId,String password) {
		String psaa=StringTools.MD5EncodeToHex(password);
		Integer stas=lotteryUserMapper.updatePssword(Integer.parseInt(userId),psaa);
		return stas;
		
	}
	
	  /**
     * 账户明细
     * @return
     */
	public List<Account> accountList(Integer userId,Query query) {
		// TODO Auto-generated method stub
//		DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
		List <Account> accountList=null;
		if (query.getMode()==null){
			 accountList=lotteryUserMapper.accountList(userId);
		}else if (query.getMode()==1){
			 accountList=lotteryUserMapper.accountList1(userId ,query.getStartTime() ,query.getEndTime() );
		}else if (query.getMode()==2){
			 accountList=lotteryUserMapper.accountList2(userId ,query.getStartTime() ,query.getEndTime());
		}else if (query.getMode()==3){
			 accountList=lotteryUserMapper.accountList(userId);
		}else {
			 accountList=lotteryUserMapper.accountList4(userId ,query.getStartTime() ,query.getEndTime());
		}

		return accountList;
	}
	/**
	 * 投注记录
	 * @return
	 */
	public List<Betting>  bettingId(Integer userId, Query query) {
		return lotteryUserMapper.bettingList(userId,query.getStartTime() ,query.getEndTime());
	}

	/**
	 * 查询用户基本信息;
	 * @return
	 */
	public LotteryInformation money(Integer userId) {
		return lotteryUserMapper.byUserId(userId);
	}
	/**
	 * 查询用户基本信息;
	 * @return
	 */
	public Integer updateMoney(String suserId,String type,String account, String mold,String reason,String money) {
		Integer state=0;
		Integer	accoun=0;
		Float fee=Float.parseFloat("0.00");
		Float moneys=Float.parseFloat(money);
		Integer user=	Integer.parseInt(suserId);
		Recharce recharce=new Recharce();
		java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyyMMdd ");
		String date = formatter.format(new Date());//格式化数据
		recharce.setOrderId(date);
		recharce.setAmout(moneys);
		recharce.setUserId(user);
		recharce.setPaytype(Integer.parseInt(type));
		recharce.setFee(fee);
		recharce.setReal(moneys);
		recharce.setStatus(2);
		recharce.setFlag(1);
		recharce.setCreate(new Date());
		recharce.setTransact(new Date());
		recharce.setDesc(mold);
		recharce.setRemark(reason);
		lotteryUserMapper.initRecharce(recharce);
		if (type.equals("0")){
//减款
			if (account.equals("0")){
//				现金账户 0  奖金账户 1  红包账户 2
//				ACT_TYPE 账户类型（1000-奖金账户 2000-投注账户 3000-赠款账户
				accoun=2000;
				lotteryUserMapper.reduce(accoun,user,moneys);


			}else if (account.equals("1")){
				accoun=1000;
				lotteryUserMapper.reduce(accoun,Integer.parseInt(suserId),moneys);
			}else if (account.equals("2")){
				accoun=3000;
				lotteryUserMapper.reduce(accoun,Integer.parseInt(suserId),moneys);
			}
		}else{
			if (account.equals("0")){
//				现金账户 0  奖金账户 1  红包账户 2
//				ACT_TYPE 账户类型（1000-奖金账户 2000-投注账户 3000-赠款账户
				accoun=2000;
				lotteryUserMapper.add(accoun,user,moneys);


			}else if (account.equals("1")){
				accoun=1000;
				lotteryUserMapper.add(accoun,Integer.parseInt(suserId),moneys);
			}else if (account.equals("2")){
				accoun=3000;
				lotteryUserMapper.add(accoun,Integer.parseInt(suserId),moneys);
			}
		}

		return state;
	}

	public Details details(String id) {
		Details details=lotteryUserMapper.details(id);
		String list=details.getList();
		List <Match> matchList=new ArrayList<Match>();
		String dd="|0^";
		String[] lists=details.getList().split("\\^");
		System.out.println(lists.length);
		for (String ls:lists){
			String[] a=ls.split("\\|");
			String sId=a[0];
			String[] b=a[1].split("#");
			String wan=b[0];
			String fen=b[1];
			Match match=lotteryUserMapper.match(sId);
			match.setzId(sId);
			match.setWanfen(wan);
			match.setTouzhu(fen);
			matchList.add(match);
		}
		details.setdList(matchList);
		return details;
	}

    public List<Account> programId(String id) {
		return	lotteryUserMapper.programId(id);
    }
}