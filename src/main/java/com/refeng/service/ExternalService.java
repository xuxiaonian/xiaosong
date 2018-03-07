package com.refeng.service;
import com.refeng.mapper.ExternalMapper;
import com.refeng.mapper.SaleMapper;
import com.refeng.model.Record;
import com.refeng.model.SaleUser;
import com.refeng.util.StringTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class ExternalService {
    @Autowired
    private ExternalMapper externalMapper;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    public List<SaleUser> role(String userId) {
        return externalMapper.role(userId);
    }

    public Integer roleAppend(Record dto) {
        dto.setTime(new Date());
        return externalMapper.roleAppend(dto);
    }
}