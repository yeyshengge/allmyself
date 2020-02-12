package com.zps.dao;

import com.github.pagehelper.Page;
import com.zps.pojo.CheckGroup;
import com.zps.pojo.Setmeal;

import java.util.List;
import java.util.Map;

public interface SetMealDao {

    public List<CheckGroup> findCheckGroupAll();

    public void add(Setmeal setmeal);

    public void addSetmealCheckgroup(Map map);

    public Page findPage(String search_name);

    public List<Setmeal> getSetmeal();

    public Setmeal findById(Integer id);

    public List<Map> getReport();

}
