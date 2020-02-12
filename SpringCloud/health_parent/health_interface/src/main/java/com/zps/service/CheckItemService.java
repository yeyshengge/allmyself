package com.zps.service;

import com.zps.entity.PageResult;
import com.zps.entity.QueryPageBean;
import com.zps.pojo.CheckGroup;
import com.zps.pojo.CheckItem;

import java.util.List;

/**
 * Created by zps on 2019/12/14 18:33
 */
public interface CheckItemService {

    void add(CheckItem checkItem);

    PageResult findAll(QueryPageBean queryPageBean);

    List<CheckGroup> findItem();


}
