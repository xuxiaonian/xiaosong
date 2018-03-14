package com.refeng.service;


//import com.refeng.config.DatabaseContextHolder;
//import com.refeng.config.DatabaseType;
import com.refeng.mapper.FinanceMapper;
import com.refeng.mapper.WithdrawalsMapper;
import com.refeng.model.OperationLog;
import com.refeng.model.Recharge;
import com.refeng.model.Withdrawals;
import com.refeng.pojo.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

;


@Service
public class WithdrawalsService {
    @Autowired
    private WithdrawalsMapper withdrawalsMapper;
    @Autowired
    private FinanceMapper financeMapper;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * List;
     * @return
     */
    public List<Withdrawals> fList(Query query){
        if(query.getMode()==null || query.getMode()==0){
            query.setMode(null);
        }
        List<Withdrawals> picList=withdrawalsMapper.fList(query);
        return picList;
    }


    public Integer lotterycount(Query query) {
        return withdrawalsMapper.lotterycount(query);
    }

    public Withdrawals withdrawalsId(String id) {
//        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
        return withdrawalsMapper.WithdrawalsId(id);
    }

    public Integer updatState(String orderId, String reason, String state, String user) {
//        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
        Integer aad=0;
        aad = withdrawalsMapper.updatState(orderId,reason,Integer.parseInt(state));
        OperationLog log=new OperationLog();
        log.setOperator(user);
        log.setReason(reason);
        log.setContent("提款的审核");
        log.setOrderId(orderId);
        log.setType(0);
        log.setCreationTime(new Date());
//        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
        aad=financeMapper.newsLog(log);

        return aad;
    }
}