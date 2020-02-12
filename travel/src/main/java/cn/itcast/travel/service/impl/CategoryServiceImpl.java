package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.CategoryDaoInter;
import cn.itcast.travel.dao.impl.CategoryDaoImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryServiceInter;
import cn.itcast.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryServiceImpl implements CategoryServiceInter {

    private CategoryDaoInter c = new CategoryDaoImpl();

    @Override
    public List<Category> findAll() {
        Jedis jedis = JedisUtil.getJedis();
        //Set<String> categorys = jedis.zrange("category", 0, -1);
        Set<Tuple> category = jedis.zrangeWithScores("category", 0, -1);
        List<Category> list = null;
        if (category == null || category.size() == 0) {
            System.out.println("缓存没有");
            //如果缓存中没有
            list = c.findAll();
            for (Category c : list) {
                jedis.zadd("category", c.getCid(), c.getCname());
            }
        } else {
            //如果缓存中有
            System.out.println("缓存有");
            list = new ArrayList<>();
            for (Tuple s : category) {
                Category cc = new Category();
                cc.setCname(s.getElement());
                cc.setCid((int) s.getScore());
                list.add(cc);
            }
        }
        return list;
    }
}
