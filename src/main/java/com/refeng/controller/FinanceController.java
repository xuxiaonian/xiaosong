
package com.refeng.controller;


        import java.io.IOException;
        import java.text.ParseException;
        import java.text.SimpleDateFormat;
        import java.util.Date;
        import java.util.List;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import javax.validation.Valid;


        import com.refeng.model.Recharge;
        import com.refeng.pojo.Query;
        import com.refeng.service.FinanceService;
        import com.refeng.util.QueryUtil;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;

        import org.springframework.web.bind.annotation.RequestMapping;

        import com.refeng.model.User;
        import com.refeng.pojo.MenuUrlList;

        import com.refeng.service.UserService;


@Controller
public class FinanceController {


    @Autowired
    private UserService userService;
    @Autowired
    private FinanceService financeService;

    /**
     * 充值的展示
     * @return
     */
    @RequestMapping("/admin/finance/list")
    public String roleList(@Valid Query query, Model model, HttpServletRequest request)   {
        query= QueryUtil.query(query);


        List<Recharge>  rechargeList =financeService.fList(query);
        model.addAttribute("rechargeList",rechargeList);
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
        if(rechargeList.size()>0) {
            lotteryUserSize=financeService.lotterycount(query);
        }
        Integer max=(int)Math.ceil((double)lotteryUserSize/(double)10);

            model.addAttribute("start", 1);
            model.addAttribute("totalPages", max);



        //是否是最后一页
        model.addAttribute("isLastPage",false);
        return "finance/rechargeList";
    }




/**
 * 充值状态的修改
 * @return
 */

    @RequestMapping("/admin/finance/updateId")
    public void update( String userId, Model model,HttpServletRequest request,HttpServletResponse response)   {

        String user=request.getSession().getAttribute("admin").toString();

       Integer update= financeService.update(userId ,user);
        try {
            response.sendRedirect("/admin/finance/list");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }












}
