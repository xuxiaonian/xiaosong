package com.refeng.service;


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
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * List;
     * @return
     */
    public List<Withdrawals> fList(Query query){
        List<Withdrawals> picList=withdrawalsMapper.fList(query);
        return picList;
    }


    public Integer lotterycount(Query query) {
        return withdrawalsMapper.lotterycount(query);
    }
}