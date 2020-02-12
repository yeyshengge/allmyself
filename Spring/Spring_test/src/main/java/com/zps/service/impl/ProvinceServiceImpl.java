package com.zps.service.impl;

import com.zps.dao.ProvinceDao;
import com.zps.dao.impl.ProvinceDaoImpl;
import com.zps.domain.City;
import com.zps.domain.Part;
import com.zps.service.ProvinceService;
import com.zps.utils.JDBCUtils;
import com.zps.utils.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProvinceServiceImpl implements ProvinceService {
    private ProvinceDao provinceDao = new ProvinceDaoImpl();


    @Override
    public List<City> chang(String value) {
        Jedis jedis = JedisUtil.getJedis();
        //定义一个待处理的要返回的集合
        List<City> list = null;
        //查询缓存中是否有
        Set<Tuple> cities = jedis.zrangeWithScores(value, 0, -1);
        //判断cities是否为空
        if (cities.size() < 1 || cities == null) {
            System.out.println("从数据库中拿取");
            //为空代表缓存中没有，要到数据库中去拿
            list = provinceDao.chang(value);
            System.out.println("从数据库中拿到的city" + list);
            //将查询到的数据存入缓存中
            for (int i = 0; i < list.size(); i++) {
                jedis.zadd(value, list.get(i).getId(), list.get(i).getName());
            }
        } else {
            System.out.println("从缓存中拿取");
            //不为空代表缓存中有，直接读取缓存
            list = new ArrayList<City>();
            for (Tuple t : cities) {
                City city = new City();
                city.setName(t.getElement());
                city.setId((int) t.getScore());
                list.add(city);
            }
        }
        System.out.println("输出的city" + list);
        return list;
    }

    @Override
    public List<Part> city(String city) {
        List<Part> list = null;
        Jedis jedis = JedisUtil.getJedis();
        Set<Tuple> tuples = jedis.zrangeWithScores(city, 0, -1);
        if (tuples.size() < 1 || tuples == null) {
            //缓存中没有
            list = provinceDao.city(city);
            System.out.println("从数据库中拿到的part" + list);
            for (int i = 0; i < list.size(); i++) {
                jedis.zadd(city, list.get(i).getId(), list.get(i).getName());
            }
        } else {
            //缓存中有
            list = new ArrayList<Part>();
            for (Tuple t : tuples) {
                Part p = new Part();
                p.setName(t.getElement());
                p.setId((int) t.getScore());
                list.add(p);
            }
        }
        System.out.println("输出的part" + list);
        return list;
    }
}
