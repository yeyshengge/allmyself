package com.zps.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zps.dao.SetMealDao;
import com.zps.entity.PageResult;
import com.zps.entity.QueryPageBean;
import com.zps.pojo.CheckGroup;
import com.zps.pojo.Setmeal;
import com.zps.service.SetMealService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zps on 2019/12/17 11:20
 */
@Service(interfaceClass = SetMealService.class)
@Transactional
public class SetMealServiceImpl implements SetMealService {

    @Autowired
    private SetMealDao setMealDao;

    @Override
    public List<CheckGroup> findCheckGroup() {
        return setMealDao.findCheckGroup();
    }

    @Override
    public PageResult findAll(QueryPageBean queryPageBean) {
        String queryString = queryPageBean.getQueryString();
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        PageHelper.startPage(currentPage, pageSize);
        Page<Setmeal> page = setMealDao.findAll(queryString);
        long total = page.getTotal();
        List<Setmeal> result = page.getResult();
        return new PageResult(total, result);
    }

    @Override
    public void add(Setmeal setmeal, Integer[] checkgroupIds) {
        setMealDao.add(setmeal);
        System.out.println(setmeal.getId());
        setMealDao.addSetMealAndGroup(setmeal.getId(), checkgroupIds);

    }

    @Override
    public List<Setmeal> findSetMealAll() {
       return setMealDao.findSetMealAll();
    }

    @Override
    public Setmeal findById(Integer id) {
        return setMealDao.findById(id);
    }
}
