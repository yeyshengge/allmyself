package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Route;

import java.util.List;

public interface IndexDaoInter {
    List<Route> queryThemeByName(String str);

    List<Route> queryNew();

}
