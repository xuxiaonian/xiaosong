package com.refeng.mapper;

import java.util.Date;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

import com.refeng.pojo.Query;

public class OrderProvider {
    private final String TBL_ORDER = "act.TB_USER_INFO t";
    public String queryOrderByParam(Query query) {
    	
        SQL sql = new SQL().SELECT(" t.USER_NAME as userName, t.PHONE as phone, t.PERSONAL_ID as identity ").FROM(TBL_ORDER);
        String name = query.getName();
        if (StringUtils.hasText(name)) {
            sql.WHERE("t.USER_NAME LIKE #{name}");
        }
       /* Date myDate = query.getMyDate();
        if (myDate != null) {
            sql.WHERE("mydate LIKE #{mydate}");
        }*/
        return sql.toString();
    }
}