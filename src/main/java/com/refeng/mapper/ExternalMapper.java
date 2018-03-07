package com.refeng.mapper;

import com.refeng.model.OperationLog;
import com.refeng.model.Recharge;
import com.refeng.model.Record;
import com.refeng.model.SaleUser;
import com.refeng.pojo.Query;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;


@Mapper
public interface ExternalMapper {
	@Select(" select  USER_ID as userId, NAME as name ,LEVELS from c_sys_user where USER_ID=#{userId}")
	List<SaleUser> role(String userId);
	@Insert(" INSERT INTO C_SALE_RECORD (SALEID ,PHONE,TIME) VALUES (#{userId},#{phone},#{time})")
	Integer roleAppend(Record dto);
}