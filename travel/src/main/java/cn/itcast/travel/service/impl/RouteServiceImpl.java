package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.FavoriteDaoInter;
import cn.itcast.travel.dao.RouteDaoInter;
import cn.itcast.travel.dao.impl.FavoriteDaoImpl;
import cn.itcast.travel.dao.impl.RouteDaoImpl;
import cn.itcast.travel.domain.*;
import cn.itcast.travel.service.RouteServiceInter;

import java.util.List;

public class RouteServiceImpl implements RouteServiceInter {
    private RouteDaoInter rd = new RouteDaoImpl();

    private FavoriteDaoInter fd = new FavoriteDaoImpl();

    /**
     * 查询页面内容
     *
     * @param cid
     * @param currentPage
     * @param pageSize
     * @param rname
     * @return
     */
    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname) {
        PageBean<Route> pb = new PageBean<Route>();
        pb.setCurrentPage(currentPage);
        pb.setPageSize(pageSize);
        int totalCount = rd.findTotalCount(cid, rname);
        pb.setTotalCount(totalCount);
        int start = (currentPage - 1) * pageSize;
        int totalPage = totalCount % pageSize == 0 ? (totalCount / pageSize) : (totalCount / pageSize) + 1;
        pb.setTotalPage(totalPage);
        List<Route> list = rd.findByPage(cid, start, pageSize, rname);
        pb.setList(list);
        return pb;
    }

    /**
     * 通过rid查询该路线的信息
     *
     * @param rid
     * @return
     */
    @Override
    public Route findOne(int rid) {
        //根据rid查询该路线的信息
        Route one = rd.findOne(rid);
        //根据sid查询卖家信息
        Seller seller = rd.findSeller(one.getSid());
        //根据rid查询图片详情集合
        List<RouteImg> image = rd.findImage(one.getRid());
        one.setSeller(seller);
        one.setRouteImgList(image);

        int count = fd.findFavoriteCount(rid);
        one.setCount(count);
        return one;

    }


}
