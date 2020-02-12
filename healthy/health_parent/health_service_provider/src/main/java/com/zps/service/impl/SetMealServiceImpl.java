package com.zps.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zps.constant.RedisConstant;
import com.zps.dao.SetMealDao;
import com.zps.entity.PageResult;
import com.zps.entity.QueryPageBean;
import com.zps.pojo.CheckGroup;
import com.zps.pojo.Setmeal;
import com.zps.service.SetMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(interfaceClass = SetMealService.class)
@Transactional
public class SetMealServiceImpl implements SetMealService {

    @Autowired
    private SetMealDao setMealDao;

    @Autowired
    private JedisPool jedisPool;

    @Override
    public List<CheckGroup> findCheckGroupAll() {
        return setMealDao.findCheckGroupAll();
    }

    @Override
    public void add(Integer[] checkgroupIds, Setmeal setmeal) {
        //调用方法存储setmeal
        setMealDao.add(setmeal);
        //该id为上一步插入语句封装的值
        Integer id = setmeal.getId();
        //往redis中存入缓存
        jedisPool.getResource().sadd(RedisConstant.SETMEAL_PIC_DB_RESOURCES, setmeal.getImg());
        //根据id给t_setmeal_checkgroup插入信息，调用方法
        this.addSetmealCheckgroup(checkgroupIds, id);

    }

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        //获得参数
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();
        //设置分页
        PageHelper.startPage(currentPage, pageSize);
        Page page = setMealDao.findPage(queryString);

        //封装参数，设置返回值
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public List<Setmeal> getSetmeal() {
        return setMealDao.getSetmeal();
    }

    @Override
    public Setmeal findById(Integer id) {
        return setMealDao.findById(id);
    }

    /**
     * 套餐报表
     *
     * @return
     */
    @Override
    public List<Map> getSetmealReport() {
        return setMealDao.getReport();
    }

    public void addSetmealCheckgroup(Integer[] checkgroupIds, Integer id) {

        if (checkgroupIds != null && checkgroupIds.length > 0) {
            for (Integer checkgroupId : checkgroupIds) {
                Map<String, Integer> map = new HashMap<>();
                map.put("setmeal_id", id);
                map.put("checkgroup_id", checkgroupId);
                setMealDao.addSetmealCheckgroup(map);
            }
        }
    }
}
