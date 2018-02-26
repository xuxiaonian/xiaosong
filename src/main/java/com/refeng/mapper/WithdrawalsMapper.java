package com.refeng.mapper;


import com.refeng.model.Withdrawals;
import com.refeng.pojo.Query;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface WithdrawalsMapper {

//	条件查询
	List<Withdrawals> fList(Query query);
	//	页数
	Integer lotterycount(Query query);

	Withdrawals WithdrawalsId(String id);

	//修改
	@Update(" update act.TB_ORDER_WITHDRAW  set  ERROR_DESC=#{reason} ,ORDER_STATUS=#{state}  where ORDER_ID =#{orderId} ")
	Integer updatState(@Param("orderId")String  orderId,@Param("reason")String reason,@Param("state")Integer state);
}