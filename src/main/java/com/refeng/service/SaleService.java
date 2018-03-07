package com.refeng.service;
import com.refeng.mapper.SaleMapper;
import com.refeng.model.SaleUser;
import com.refeng.util.StringTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class SaleService {
    @Autowired
    private SaleMapper saleMapper;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());



    public List<SaleUser> dayList(String sort) {

        return saleMapper.dayList(sort);
    }
    public List<SaleUser> saleList() {

        return saleMapper.saleList();
    }
    public Integer newsAdd(SaleUser saleUser) {

        List<SaleUser>  saleUsers= saleMapper.userId();
        saleUser.setUserId(saleUsers.get(0).getUserId()+1);
        String pass=  StringTools.MD5EncodeToHex(saleUser.getPassword());
        saleUser.setPassword(pass);
        saleUser.setTime( new Date());



        return saleMapper.newsAdd(saleUser);
    }

    public List<SaleUser> roleList(String userName) {
        return saleMapper.roleList(userName);
    }

    public SaleUser userId(Integer rId) {
        return saleMapper.useId(rId);
    }

    public Integer updateSale(SaleUser sale) {
        List<SaleUser>  saleUsers= saleMapper.userId();


        sale.setTime( new Date());

        return   saleMapper.newsUpdate(sale);
    }
}