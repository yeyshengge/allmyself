package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.FavoriteDaoInter;
import cn.itcast.travel.dao.RouteDaoInter;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.MyFavorite;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FavoriteDaoImpl implements FavoriteDaoInter {
    JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 查询该用户是否收藏
     *
     * @param rid
     * @param uid
     * @return
     */
    @Override
    public Favorite findByRidAndUid(int rid, int uid) {
        String sql = "select * from tab_favorite where rid = ? and uid = ?";
        Favorite favorite = null;
        try {
            favorite = jt.queryForObject(sql, new BeanPropertyRowMapper<Favorite>(Favorite.class), rid, uid);
        } catch (Exception e) {
        }
        //System.out.println(favorite);
        return favorite;
    }

    /**
     * 查询该路线被收藏的次数
     *
     * @param rid
     * @return
     */
    @Override
    public int findFavoriteCount(int rid) {
        String sql = "select count(*) from tab_favorite where rid=?";
        Integer count = jt.queryForObject(sql, Integer.class, rid);
        return count;
    }

    /**
     * 添加收藏
     *
     * @param rid
     * @param uid
     */
    @Override
    public void addFavrite(int rid, int uid) {
        try {
            String sql = "insert into tab_favorite values (?,?,?)";
            jt.update(sql, rid, new Date(), uid);
            String sql2 = "select * from tab_route where rid = ?";
            Route route = jt.queryForObject(sql2, new BeanPropertyRowMapper<>(Route.class), rid);
            int count = route.getCount();
            String sql3 = "update tab_route set count = ? where rid =? ";
            jt.update(sql3, ++count, rid);
        } catch (Exception e) {
        }
    }

    /**
     * 通过uid查询该用户的收藏rid集合
     *
     * @param uid
     * @param start
     * @return
     */
    @Override
    public List<Favorite> queryFavoriteByUid(int uid, int start) {
        String sql = "select * from tab_favorite where uid  = ? limit ?,?";


        List<MyFavorite> list = jt.query(sql, new BeanPropertyRowMapper<MyFavorite>(MyFavorite.class), uid, start, 8);

        //System.out.println("集合" + list);
        //通过uid查该用户
        String sql2 = "select * from tab_user where uid =?";
        User user = jt.queryForObject(sql2, new BeanPropertyRowMapper<>(User.class), uid);
        List<Favorite> relist = new ArrayList<>();
        RouteDaoInter rd = new RouteDaoImpl();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (MyFavorite myFavorite : list) {
            Route one = rd.findOne(myFavorite.getRid());
            Favorite f = new Favorite(one, sdf.format(new Date()), user);
            relist.add(f);
        }
        //System.out.println("最后的长度" + relist.size());
        return relist;


    }

    @Override
    public int favoriteByUid(int uid) {

        String sql = "select count(*) from tab_favorite where uid =?";
        Integer count = jt.queryForObject(sql, Integer.class, uid);
        //System.out.println("查询到了" + count);
        return count;
    }

    @Override
    public List<Route> findByNUD(String routeName, int moneyDown, int moneyUp, int start, int pageSize) {
    /*数据库标准模板
    select * from tab_route where 1=1 and rname like'%西安%' and price> 2900 and  price< 4000 ORDER BY count desc limit 0,5
     */
        String sql = "select * from tab_route where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        List list = new ArrayList();
        //要排除空字符串跟字符串“null”;
        if (routeName != null && routeName.length() > 0 && !"null".equals(routeName)) {
            sb.append(" and rname like ?");
            list.add("%" + routeName + "%");
        }
        sb.append(" and price> ? and  price< ? ORDER BY count desc limit ?,? ");
        list.add(moneyUp);
        list.add(moneyDown);
        list.add(start);
        list.add(pageSize);
        sql = sb.toString();
        List<Route> newlist = jt.query(sql, new BeanPropertyRowMapper<>(Route.class), list.toArray());

        return newlist;


    }

    @Override
    public int findCount(String routeName, int moneyDown, int moneyUp) {
        String sql = "select count(*) from tab_route where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        List list = new ArrayList();
        //要排除空字符串跟字符串“null”;
        if (routeName != null && routeName.length() > 0 && !"null".equals(routeName)) {
            sb.append(" and rname like ?");
            list.add("%" + routeName + "%");
        }
        sb.append(" and price> ? and  price< ? ");
        list.add(moneyUp);
        list.add(moneyDown);
        sql = sb.toString();
        //System.out.println("后的sql语句" + sql);
        //System.out.println("后的list集合" + list);
        Integer count = jt.queryForObject(sql, Integer.class, list.toArray());
        //System.out.println("总数" + count);
        return count;
    }
}
