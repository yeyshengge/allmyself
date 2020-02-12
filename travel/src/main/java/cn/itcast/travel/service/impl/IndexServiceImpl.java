package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.IndexDaoInter;
import cn.itcast.travel.dao.impl.IndexDaoImpl;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.IndexServiceInter;

import java.util.List;

public class IndexServiceImpl implements IndexServiceInter {
    private IndexDaoInter id = new IndexDaoImpl();

    @Override
    public List<Route> queryThemeByName(String str) {
        List<Route> list = id.queryThemeByName(str);
        return list;
    }

    @Override
    public List<Route> queryNew() {
        List<Route> list = id.queryNew();
        return list;
    }
}
