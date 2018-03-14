package com.refeng.service;



import com.refeng.mapper.FinanceMapper;

import com.refeng.model.OperationLog;
import com.refeng.model.Recharge;
import com.refeng.pojo.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

;


@Service
public class FinanceService {
    @Autowired
    private FinanceMapper financeMapper;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * List;
     * @return
     */
    public List<Recharge> fList(Query query){
        if(query.getMode()==null || query.getMode()==0){
            query.setMode(null);
        }
        List<Recharge> picList=financeMapper.fList(query);
        return picList;
    }

//页数
    public Integer lotterycount(Query query) {
        Integer lotterycount=financeMapper.lotterycount(query);
        return lotterycount;
    }

    /**
     * List;
     * @return
     */
    public  Integer update(String id ,String user){
        Integer aad=1;
        Recharge fById=financeMapper.fById(id);
         financeMapper.upodatef(id);
         financeMapper.upodateAct(fById.getUserId(),fById.getOrderAmout());
        OperationLog log=new OperationLog();
        log.setOperator(user);
        log.setReason("原因暂无");
        log.setContent("支付状态又失败转换成成功");
        log.setOrderId(fById.getOrderId());
        log.setType(0);
        log.setCreationTime(new Date());
        aad=financeMapper.newsLog(log);
        return aad;
    }

}