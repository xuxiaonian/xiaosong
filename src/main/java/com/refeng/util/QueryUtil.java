package com.refeng.util;

import com.refeng.pojo.Query;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * query 的初始化
 *
 * @return
 */
public class QueryUtil {
    public static Query query(Query query) {
        if (query.getPageNum() == null) {
            query.setPageNum(1);
        }
        if (query.getSize() == null) {
            query.setSize(10);
        }
        if (query.getRetrieval() == null) {
            query.setRetrieval(0);
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        if (query.getStartTime1() != null) {
            Date date;
            try {
                if (!query.getStartTime1().isEmpty()) {
                    date = format.parse(query.getStartTime1());
                    query.setStartTime(date);
                }
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        if (query.getEndTime1() != null) {
            Date date;
            try {
                if (!query.getEndTime1().isEmpty()) {
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