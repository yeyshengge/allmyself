package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.Route;

import java.util.List;

public interface FavoriteDaoInter {

    public Favorite findByRidAndUid(int rid, int uid);

    int findFavoriteCount(int rid);

    void addFavrite(int rid, int uid);

    List<Favorite> queryFavoriteByUid(int uid, int start);

    int favoriteByUid(int uid);

    List<Route> findByNUD(String routeName, int moneyDown, int moneyUp, int start, int pageSize);

    int findCount(String routeName, int moneyDown, int moneyUp);

}
