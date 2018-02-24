
package com.refeng.controller;


import com.refeng.model.Recharge;
import com.refeng.model.Withdrawals;
import com.refeng.pojo.Query;

import com.refeng.service.WithdrawalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class WithdrawalsController {

    @Autowired
    private WithdrawalsService withdrawalsService;

    /**
     * 提现的展示
     * @return
     */
    @RequestMapping("/admin/withdrawals/list")
    public String roleList(@Valid Query query, Model model, HttpServletRequest request)   {
        query= query(query);
        List<Withdrawals>  wList =withdrawalsService.fList(query);
        model.addAttribute("wList",wList);
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
        if(wList.size()>0) {
            lotteryUserSize=withdrawalsService.lotterycount(query);
        }
        Integer max=(int)Math.ceil((double)lotteryUserSize/(double)10);

            model.addAttribute("start", 1);
            model.addAttribute("totalPages", max);

        //是否是最后一页
        model.addAttribute("isLastPage",false);
        return "withdrawals/list";
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
