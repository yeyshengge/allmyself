package cn.itcast.travel.service;

import cn.itcast.travel.domain.Route;

import java.util.List;

public interface IndexServiceInter {
    List<Route> queryThemeByName(String str);

    List<Route> queryNew();

}
