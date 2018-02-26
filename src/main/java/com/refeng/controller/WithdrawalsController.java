
package com.refeng.controller;


import com.refeng.model.Withdrawals;
import com.refeng.pojo.Query;
import com.refeng.service.WithdrawalsService;
import com.refeng.util.QueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
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
    public String withdrawalsList(@Valid Query query, Model model, HttpServletRequest request)   {
        query= QueryUtil.query(query);
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
            model.addAttribute("totalPages", max);

        //是否是最后一页
        model.addAttribute("isLastPage",false);
        return "withdrawals/list";
    }

    /**
     * 提现订单的展示
     * @param model
     * @return
     */
    @GetMapping("/admin/withdrawals/byId")
    public String withdrawalsId(Model model,String rId, HttpServletRequest request) {

        Withdrawals withdrawalsId =withdrawalsService.withdrawalsId(rId);
        model.addAttribute("withdrawal",withdrawalsId);
        return "withdrawals/examine";
    }

    /**
     * 提现订单的审核

     * @return
     */
    @PostMapping("/admin/withdrawals/updatState")
    public void updatState(String orderId, String reason, String state,HttpServletRequest request,HttpServletResponse response) {
        String user=request.getSession().getAttribute("admin").toString();
        withdrawalsService.updatState(orderId,reason,state,user);
        try {
            response.sendRedirect("/admin/withdrawals/list");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @GetMapping("/admin/withdrawals/updatStates")
    public void updatState(String orderId,HttpServletRequest request,HttpServletResponse response) {
        String user=request.getSession().getAttribute("admin").toString();
       String state="1";
        String reason="修改为审核通过";
       Integer ss= withdrawalsService.updatState(orderId,reason,state,user);
        try {
            response.sendRedirect("/admin/withdrawals/list");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @GetMapping("/admin/withdrawals/updatSt")
    public void updatSt(String orderId,HttpServletRequest request,HttpServletResponse response) {
        String user=request.getSession().getAttribute("admin").toString();
        String state="3";
        String reason="取消提现";
        withdrawalsService.updatState(orderId,reason,state,user);
        try {
            response.sendRedirect("/admin/withdrawals/list");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }










}
