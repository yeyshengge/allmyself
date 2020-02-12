package com.zps.dao;

import com.github.pagehelper.Page;
import com.zps.entity.PageResult;
import com.zps.entity.QueryPageBean;
import com.zps.entity.Result;
import com.zps.pojo.CheckItem;
import org.springframework.web.bind.annotation.RequestBody;


public interface CheckItemDao {

    /**
     * 增加记录
     * @param checkItem
     */
    public void add(CheckItem checkItem);

    /**
     * 因为用了分页助手，所以返回值为Page
     *
     * @param search_name
     * @return
     */
    public Page findPage(String search_name);

    /**
     * 判断删除检测项时是否跟检查组有关联
     *
     * @param id
     * @return
     */
    public long findCountByCheckQI(Integer id);

    /**
     * 根据id删除
     * @param id
     */
    public void deleteById(Integer id);

    /**
     * 编辑修改
     * @param checkItem
     */
    public void edit(CheckItem checkItem);

}
