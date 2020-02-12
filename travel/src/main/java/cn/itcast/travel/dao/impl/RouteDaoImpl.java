package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.RouteDaoInter;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.RouteImg;
import cn.itcast.travel.domain.Seller;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class RouteDaoImpl implements RouteDaoInter {
    private JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 查询总条数
     *
     * @param cid
     * @param rname
     * @return
     */
    @Override
    public int findTotalCount(int cid, String rname) {

        //System.out.println("前" + rname);

        /*String sql = "select count(*) from tab_route where 1=1 and ";*/
        String sql = "select count(*) from tab_route where 1=1 ";

        StringBuilder sb = new StringBuilder(sql);
        List list = new ArrayList();
        if (cid != 0) {
            sb.append(" and cid = ? ");
            list.add(cid);
        }
        //要排除空字符串跟字符串“null”;
        if (rname != null && rname.length() > 0 && !"null".equals(rname)) {
            sb.append(" and rname like ? ");
            list.add("%" + rname + "%");
        }

        sql = sb.toString();

        //System.out.println("前" + sql);

        /*for (Object o : list) {
            System.out.println("qian" + o);
        }*/
        Integer count = jt.queryForObject(sql, Integer.class, list.toArray());
        //System.out.println("查询到条数" + count);
        return count;


    }

    /**
     * 查询显示页码内容
     *
     * @param cid
     * @param start
     * @param pageSize
     * @param rname
     * @return
     */
    @Override
    public List<Route> findByPage(int cid, int start, int pageSize, String rname) {
        System.out.println("后" + rname);
        //String sql = "select * from tab_route where i = 1 and cid = ? and rname like ? limit ?,?";
        String sql = "select * from tab_route where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        List list = new ArrayList();
        if (cid != 0) {
            sb.append(" and cid = ? ");
            list.add(cid);
        }
        //要排除空字符串跟字符串“null”;
        if (rname != null && rname.length() > 0 && !"null".equals(rname)) {
            sb.append(" and rname like ?");
            list.add("%" + rname + "%");
        }

        list.add(start);
        list.add(pageSize);
        sb.append(" limit ? , ? ");
        sql = sb.toString();
        //System.out.println("后**  " + sql);
        /*for (Object o : list) {
            System.out.println("huo---  " + o);
        }*/
        List<Route> newlist = jt.query(sql, new BeanPropertyRowMapper<Route>(Route.class), list.toArray());
        for (Route route : newlist) {
            //System.out.println(route.getRname());
        }
        return newlist;
    }

    /**
     * 通过rid查询路线详情
     *
     * @param rid
     * @return
     */
    @Override
    public Route findOne(int rid) {
        String sql = "select * from tab_route where rid =? ";
        Route route = jt.queryForObject(sql, new BeanPropertyRowMapper<Route>(Route.class), rid);
        return route;
    }

    /**
     * 通过cid查询该路线下的图片
     *
     * @param rid
     * @return
     */
    @Override
    public List<RouteImg> findImage(int rid) {
        String sql = "select * from tab_route_img where rid = ?";
        List<RouteImg> list = jt.query(sql, new BeanPropertyRowMapper<RouteImg>(RouteImg.class), rid);
        return list;
    }

    /**
     * 查询卖家信息
     *
     * @param sid
     * @return
     */
    @Override
    public Seller findSeller(int sid) {
        String sql = "select * from tab_seller where sid =? ";
        Seller seller = jt.queryForObject(sql, new BeanPropertyRowMapper<Seller>(Seller.class), sid);
        return seller;
    }
}
