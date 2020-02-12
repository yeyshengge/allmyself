package com.zps.dao;

import com.github.pagehelper.Page;
import com.zps.pojo.CheckGroup;
import com.zps.pojo.CheckItem;

import java.util.List;

/**
 * Created by zps on 2019/12/14 18:45
 */
public interface CheckItemDao {
    void add(CheckItem checkItem);


    Page<CheckItem> findAll(String queryString);

    List<CheckGroup> findItem();

}
