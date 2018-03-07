package com.refeng.mapper;

import com.refeng.model.CarouselPic;
import com.refeng.model.OperationLog;
import com.refeng.model.Recharge;
import com.refeng.pojo.Query;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface FinanceMapper {
	//彩票用户的列表的查询
//	分页
//	条件查询
	List<Recharge> fList(Query query);
	//	页数
	Integer lotterycount(Query query);


	//	id 查询
	@Select(" Select * from act.TB_ORDER_RECHARGE WHERE ORDER_ID=#{id} ")
	@Results({
			@Result(property = "userId", column = "USER_ID"),
			@Result(property = "orderAmout", column = "ORDER_AMOUNT"),
			@Result(property = "orderId", column = "ORDER_ID")
	})
	Recharge fById(String id);

	//	充值的的修改
	@Update("update act.TB_ORDER_RECHARGE SET ORDER_STATUS= 2 " +
			" WHERE ORDER_ID=#{id} ")
	Integer upodatef ( String  id);
	//	充值账户的的修改
	@Update("update act.TB_USER_ACT act SET act.BALANCE= (BALANCE+#{balance}) " +
			" WHERE act.USER_ID=#{id} and  act.ACT_TYPE=2000")
	Integer upodateAct ( @Param("id")Integer id ,@Param("balance")float   balance);



	//	日志的新增
	@Insert("INSERT INTO  act.F_OPERATION_LOG (ID , CREATION_TIME ,TYPE, CONTENT ,OPERATOR , REASON ,ORDER_ID) " +
			" VALUES (LOGID.nextval ,#{creationTime},#{type},#{content},#{operator},#{reason},#{orderId}) ")
	Integer newsLog (OperationLog log);
}