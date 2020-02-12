package com.zps.service.serviceImpl;

import com.zps.dao.DaoInter;
import com.zps.dao.daoImpl.DaoImpl;
import com.zps.domain.Province;
import com.zps.service.SericeInter;

import java.util.List;

public class ServinceImpl implements SericeInter {
    public List<Province> findAll() {
        DaoInter d = new DaoImpl();
        List list = d.findAll();
        return list;
    }
}
