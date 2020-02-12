package com.zps.service;

import com.zps.entity.PageResult;
import com.zps.entity.QueryPageBean;
import com.zps.pojo.CheckGroup;
import com.zps.pojo.Setmeal;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/*
服务接口
 */
public interface SetMealService {

    public List<CheckGroup> findCheckGroupAll();

    public void add(Integer[] checkgroupIds, Setmeal setmeal);

    public PageResult findPage(QueryPageBean queryPageBean);

    public List<Setmeal> getSetmeal();

    public Setmeal findById(Integer id);

    List<Map> getSetmealReport();

}
