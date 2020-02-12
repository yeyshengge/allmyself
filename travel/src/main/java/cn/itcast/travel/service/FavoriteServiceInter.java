package cn.itcast.travel.service;

import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

public interface FavoriteServiceInter {

    public boolean findByRidAndUid(int rid, int uid);


    public void addFavrite(String rid, String uid);

    public PageBean<Favorite> queryFavoriteByUid(int uid, int currentPage, int pageSize);

    PageBean<Route> findByNUD(String routeName, int moneyDown, int moneyUp, int currentPage, int pageSize);
}
