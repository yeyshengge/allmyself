package com.zps.service;

import com.zps.entity.PageResult;
import com.zps.entity.QueryPageBean;
import com.zps.pojo.CheckGroup;
import com.zps.pojo.Setmeal;

import java.util.List;

/**
 * Created by zps on 2019/12/17 11:17
 */
public interface SetMealService {
    List<CheckGroup> findCheckGroup();

    PageResult findAll(QueryPageBean queryPageBean);


    void add(Setmeal setmeal, Integer[] checkgroupIds);


    List<Setmeal> findSetMealAll();


   Setmeal findById(Integer id);

}
