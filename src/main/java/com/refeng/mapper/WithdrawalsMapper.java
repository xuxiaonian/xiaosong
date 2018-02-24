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

}