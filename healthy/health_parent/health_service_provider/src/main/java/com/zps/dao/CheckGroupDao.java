package com.zps.dao;

import com.github.pagehelper.Page;
import com.zps.pojo.CheckGroup;
import com.zps.pojo.CheckItem;

import java.util.List;
import java.util.Map;

public interface CheckGroupDao {
    public List<CheckItem> findCheckItemAll();

    public void addGroup(CheckGroup checkGroup);

    public void addGroupItem(Map map);

    public Page findPage(String search_name);

    public List<Integer> findCheckItemId(Integer id);

    public void deleteById(Integer id);

    public void edit(CheckGroup checkGroup);

    public void addByIds(Integer id, Integer[] checkitemIds);

    public void deleteGroupById(Integer id);
}
