package cn.itcast.travel.dao;

import cn.itcast.travel.domain.*;

import java.util.List;

public interface RouteDaoInter {

    //通过cid查询总条数
    public int findTotalCount(int cid, String rname);

    //通过cid,start,pageSize
    public List<Route> findByPage(int cid, int start, int pageSize, String rname);

    //通过rid查该路线的信息
    public Route findOne(int rid);

    //通过rid查该路线的图片
    public List<RouteImg> findImage(int rid);

    //通过sid查询路线的卖家
    public Seller findSeller(int sid);
}
