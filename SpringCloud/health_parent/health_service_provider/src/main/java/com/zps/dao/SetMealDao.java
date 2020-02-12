package com.zps.dao;

import com.github.pagehelper.Page;
import com.zps.pojo.CheckGroup;
import com.zps.pojo.Setmeal;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zps on 2019/12/17 11:21
 */
public interface SetMealDao {

    List<CheckGroup> findCheckGroup();

    Page<Setmeal> findAll(String queryString);

    void add(Setmeal setmeal);

    void addSetMealAndGroup(@Param("setmeal_id") Integer setmeal_id, @Param("ids") Integer[] checkgroupIds);

    List<Setmeal> findSetMealAll();

    Setmeal findById(Integer id);

}
