package com.refeng.mapper;

import java.util.Date;
import java.util.List;

import com.refeng.model.*;
import org.apache.ibatis.annotations.*;

import com.refeng.pojo.Query;





@Mapper
public interface LotteryUserMapper {
//彩票用户的列表的查询
//	分页
//	条件查询
	List <LotteryUser> lotteryUserList(Query query);
//	页数
	Integer lotterycount(Query query);
	
//彩民的基本信息  
	LotteryInformation byUserId(Integer id);
	
	     
	//彩民的基本信息  (账户的信息)
	  @Select(" select act.ACT_TYPE as actType ,act.BALANCE as balanceMoney  from act.TB_USER_ACT act where act .USER_ID= #{userId}")
		List<LotteryInformation> lotList(Integer userId);
	  
	 /* --总金额
      select SUM(INFO.ORDER_AMOUNT) as jine  from    
     gpc.TB_ORDER_INFO INFO  where INFO.USER_ID=20089275 AND INFO.ORDER_STATUS=1;*/
	  @Select("select SUM(INFO.ORDER_AMOUNT) as successMoney  from  gpc.TB_ORDER_INFO INFO  where INFO.USER_ID=#{userId} AND INFO.ORDER_STATUS=1")
	  Integer successMoney(Integer userId);
	  /*  --跟单
     select SUM(INFO.ORDER_AMOUNT) as jine  from    
     gpc.TB_ORDER_INFO INFO  where INFO.USER_ID=20089275 AND INFO.ORDER_STATUS=1 AND INFO.ISFOLLOW=1;*/
       @Select(" select SUM(INFO.ORDER_AMOUNT) as followMoney  from gpc.TB_ORDER_INFO INFO  where INFO.USER_ID=#{userId} AND INFO.ORDER_STATUS=1 AND INFO.ISFOLLOW=1")
 	  Integer followMoney(Integer userId);
    /*    --自购
      select SUM(INFO.ORDER_AMOUNT) as jine  from    
     gpc.TB_ORDER_INFO INFO  where INFO.USER_ID=20089275 AND INFO.ORDER_STATUS=1 AND INFO.ISFOLLOW=0;*/
       @Select(" select SUM(INFO.ORDER_AMOUNT) as ownBuyMoney  from  gpc.TB_ORDER_INFO INFO  where INFO.USER_ID=#{userId} AND INFO.ORDER_STATUS=1 AND INFO.ISFOLLOW=0")
  	  Integer ownBuyMoney(Integer userId);
       
       
       
       /* --总金额 三个月*/
 	  @Select("select SUM(INFO.ORDER_AMOUNT) as successMoney3  from  gpc.TB_ORDER_INFO INFO  where INFO.USER_ID=#{userId} AND INFO.ORDER_STATUS=1 AND INFO.BUY_TIMESTAMP>#{data}")
 	  Integer successMoney3(@Param("userId")Integer userId,@Param("data")Date dBefore);
 	  /*  --跟单三个月*/
        @Select(" select SUM(INFO.ORDER_AMOUNT) as followMoney3  from gpc.TB_ORDER_INFO INFO  where INFO.USER_ID=#{userId} AND INFO.ORDER_STATUS=1 AND INFO.ISFOLLOW=1 AND INFO.BUY_TIMESTAMP>#{data}")
  	  Integer followMoney3(@Param("userId")Integer userId,@Param("data")Date data);
     /*    --自购三个月*/
        @Select(" select SUM(INFO.ORDER_AMOUNT) as ownBuyMoney3  from  gpc.TB_ORDER_INFO INFO  where INFO.USER_ID=#{userId} AND INFO.ORDER_STATUS=1 AND INFO.ISFOLLOW=0 AND INFO.BUY_TIMESTAMP>#{data}")
   	  Integer ownBuyMoney3(@Param("userId")Integer userId,@Param("data")Date data);
    
     
       /*--总奖金
         select SUM(INFO.BONUS_AMOUNT) as jine  from    
     gpc.TB_ORDER_INFO INFO  where INFO.USER_ID=20089275 AND INFO.BONUS_FLAG=1 ;*/
     
       @Select(" select SUM(INFO.BONUS_AMOUNT) as bonus  from  gpc.TB_ORDER_INFO INFO  where INFO.USER_ID=20089275 AND INFO.BONUS_FLAG=1")
   	  Integer bonus(Integer userId );
       
       @Select(" select SUM(INFO.BONUS_AMOUNT) as bonus3  from  gpc.TB_ORDER_INFO INFO  where INFO.USER_ID=20089275 AND INFO.BONUS_FLAG=1 AND INFO.BUY_TIMESTAMP>#{data}")
     Integer bonus3(@Param("userId")Integer userId,@Param("data")Date data);
   /*  --充值金额
        select SUM(CHARGE.REAL_AMOUNT) as jine  from    
     act.TB_ORDER_RECHARGE CHARGE  where CHARGE.USER_ID=20089273 AND CHARGE.ORDER_STATUS=2 ;*/
       @Select(" select SUM(CHARGE.REAL_AMOUNT) as wholeMoney  from   act.TB_ORDER_RECHARGE CHARGE  where CHARGE.USER_ID=20089273 AND CHARGE.ORDER_STATUS=2 ")
    	  Integer wholeMoney(Integer userId );
       @Select(" select SUM(CHARGE.REAL_AMOUNT) as wholeMoney3  from   act.TB_ORDER_RECHARGE CHARGE  where CHARGE.USER_ID=20089273 AND CHARGE.ORDER_STATUS=2  AND CHARGE.CREATE_TIMESTAMP >#{data}")
 	  Integer wholeMoney3(@Param("userId")Integer userId,@Param("data")Date data);
	  
	  
	  
	//彩民的基本信息  (账户的信息)
	  @Update(" update act.TB_USER_INFO  info  set info.PASSWORD=#{password} where info.USER_ID =#{userId} ")
		Integer updatePssword(@Param("userId")Integer userId,@Param("password")String password);
	  
	  
	  
	  
	  
	  
	  
//		账户的明细表  充值
	     @Select("select  ERROR_DESC as feeAmout, CREATE_TIMESTAMP as dealTime, ORDER_ID as orderId ,ORDER_DESC as type , REAL_AMOUNT as  income,  FEE_AMOUNT as  procedures from  act.TB_ORDER_RECHARGE   where USER_ID=20089273 ")
		List <Account> accountList(Integer query);


	//投注记录
	@Select("SELECT a.ORDER_ID as orderId,  a.BUY_TIMESTAMP as buyTime,  a.BATCH_ID as batchId,  a.LOTTERY_ID as lotteryId,  a.PROGRAM_ID as programId, " +
	"a.REAL_AMOUNT as realAmout, a.ORDER_STATUS as orderStatus, a.BONUS_AMOUNT as bonusAmout, b.ORDER_STATUS as issueOrderStaus, c.USER_NAME as infoUser, "+
	"a.BUY_TYPE as buyType FROM gpc.TB_ORDER_INFO a "+
	"LEFT JOIN gpc.TB_ORDER_ISSUE b ON a.ORDER_ID=b.ORDER_ID " +
	"LEFT JOIN gpc.TB_PROGRAM_INFO c ON c.PROGRAM_ID=a.PROGRAM_ID Where a.USER_ID=#{userId}")
	List <Betting> bettingList(Integer userId);



	//加减款

	@Update(" update act.TB_USER_ACT  set BALANCE=(BALANCE-#{money}) where USER_ID =#{userId} and ACT_TYPE =#{accoun}")
	Integer reduce(@Param("accoun")Integer accoun,@Param("userId")Integer userId,@Param("money")Float money);

	@Update(" update act.TB_USER_ACT  set BALANCE=(#{money}+BALANCE) where USER_ID =#{userId} and ACT_TYPE =#{accoun}")
	Integer add(@Param("accoun")Integer accoun,@Param("userId")Integer userId,@Param("money")Float money);

	//	chongzhi的新增
	@Insert("INSERT INTO act.TB_ORDER_RECHARGE (ORDER_ID , USER_ID ,PAY_TYPE, ORDER_AMOUNT,FEE_AMOUNT,REAL_AMOUNT,ORDER_STATUS ," +
			" OVER_FLAG,CREATE_TIMESTAMP,TRANSACT_TIMESTAMP,ORDER_DESC,REMARK ) " +
			" VALUES ((#{orderId} || act.seq_id.nextval) ,#{userId},#{paytype},#{amout},#{fee},#{real},#{status},#{flag},#{create},#{transact},#{desc},#{remark}) ")
	Integer initRecharce (Recharce pic);
}