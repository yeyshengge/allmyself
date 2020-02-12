package com.zps.service;

import com.zps.entity.PageResult;
import com.zps.entity.QueryPageBean;
import com.zps.entity.Result;
import com.zps.pojo.CheckGroup;
import com.zps.pojo.CheckItem;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CheckGroupService {

    //查询新建表单项
    public List<CheckItem> findCheckItemAll();

    public void add(Integer[] checkitemIds, @RequestBody CheckGroup checkGroup);

    //页面 数据加载
    public PageResult findPage(QueryPageBean queryPageBean);

    public List<Integer> findCheckItemId(Integer id);

    public void edit(Integer[] checkitemIds, CheckGroup checkGroup);

    public void delete(Integer id);
}
