package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.FavoriteDaoInter;
import cn.itcast.travel.dao.impl.FavoriteDaoImpl;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.FavoriteServiceInter;

import java.util.List;

public class FavoriteServiceImpl implements FavoriteServiceInter {
    private FavoriteDaoInter fd = new FavoriteDaoImpl();


    @Override
    public boolean findByRidAndUid(int rid, int uid) {

        Favorite favorite = fd.findByRidAndUid(rid, uid);
        if (favorite != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 增加收藏
     *
     * @param rid
     * @param uid
     */
    @Override
    public void addFavrite(String rid, String uid) {
        fd.addFavrite(Integer.parseInt(rid), Integer.parseInt(uid));
    }

    /**
     * 收藏分页
     *
     * @param uid
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageBean<Favorite> queryFavoriteByUid(int uid, int currentPage, int pageSize) {

        PageBean<Favorite> pf = new PageBean<>();

        int start = (currentPage - 1) * pageSize;

        //System.out.println("开始" + start);

        int totalCount = fd.favoriteByUid(uid);
        int totalPage = totalCount % pageSize == 0 ? (totalCount / pageSize) : (totalCount / pageSize) + 1;
        //System.out.println("总条数" + totalCount + "总页面数" + totalPage);
        List<Favorite> list = fd.queryFavoriteByUid(uid, start);
        pf.setTotalCount(totalCount);
        pf.setTotalPage(totalPage);
        pf.setPageSize(pageSize);
        pf.setCurrentPage(currentPage);
        pf.setList(list);
        return pf;
    }

    @Override
    public PageBean<Route> findByNUD(String routeName, int moneyUp, int moneyDown, int currentPage, int pageSize) {
        PageBean<Route> pb = new PageBean<>();

        //计算条目总数;
        int totalCount = fd.findCount(routeName, moneyDown, moneyUp);
        //计算页面总数
        int totalPage = totalCount % pageSize == 0 ? (totalCount / pageSize) : (totalCount / pageSize) + 1;
        //计算开始的索引
        int start = (currentPage - 1) * pageSize;


        List<Route> list = fd.findByNUD(routeName, moneyDown, moneyUp, start, pageSize);

        pb.setTotalPage(totalPage);
        pb.setTotalCount(totalCount);
        pb.setList(list);
        pb.setPageSize(pageSize);
        pb.setCurrentPage(currentPage);

        return pb;
    }
}
