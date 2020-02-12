package com.zps.service;

import com.zps.entity.PageResult;
import com.zps.entity.QueryPageBean;
import com.zps.pojo.CheckItem;


/**
 * 服务接口
 */
public interface CheckItemService {

    //增加检查项
    public void add(CheckItem checkItem);

    public PageResult findPage(QueryPageBean queryPageBean);

    //通过id删除检查项
    public void delete(Integer id);

    //编辑检查项
    public void edit(CheckItem checkItem);

}
