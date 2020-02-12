package com.zps.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zps.dao.CheckGroupDao;
import com.zps.entity.PageResult;
import com.zps.entity.QueryPageBean;
import com.zps.pojo.CheckGroup;
import com.zps.pojo.CheckItem;
import com.zps.service.CheckGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(interfaceClass = CheckGroupService.class)
@Transactional
public class CheckGroupServiceImpl implements CheckGroupService {

    @Autowired
    private CheckGroupDao checkGroupDao;

    @Override
    public List<CheckItem> findCheckItemAll() {
        List<CheckItem> checkItemAll = checkGroupDao.findCheckItemAll();
        return checkItemAll;
    }

    @Override
    public void add(Integer[] checkitemIds, CheckGroup checkGroup) {
        //给t_checkgroup添加数据
        checkGroupDao.addGroup(checkGroup);
        //拿到刚刚存储的id
        Integer id = checkGroup.getId();
        //给t_checkgroup_checkitem添加数据
        if (checkitemIds != null && checkitemIds.length >= 0) {
            for (Integer checkitemId : checkitemIds) {
                Map<String, Integer> map = new HashMap<>();
                map.put("checkgroup_id", id);
                map.put("checkitem_id", checkitemId);
                checkGroupDao.addGroupItem(map);
            }
        }
    }

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        //获取数据
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();

        //设置分页信息
        PageHelper.startPage(currentPage, pageSize);
        //返回值必须用Page对象封装
        Page page = checkGroupDao.findPage(queryString);

        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public List<Integer> findCheckItemId(Integer id) {
        List<Integer> list = checkGroupDao.findCheckItemId(id);
        return list;
    }

    @Override
    public void edit(Integer[] checkitemIds, CheckGroup checkGroup) {
        //第一件事:根据id删除多表中的数据
        checkGroupDao.deleteById(checkGroup.getId());
        //第二件事:更新数据
        checkGroupDao.edit(checkGroup);
        //第三件事：给第三张表添加数据(t_checkitem_checkgroup);
        if (checkitemIds != null && checkitemIds.length >= 0) {
            for (Integer checkitemId : checkitemIds) {
                Map<String, Integer> map = new HashMap<>();
                map.put("checkgroup_id", checkGroup.getId());
                map.put("checkitem_id", checkitemId);
                checkGroupDao.addGroupItem(map);
            }
        }
    }

    @Override
    public void delete(Integer id) {
        //1,通过id删除对应的t_checkitem_checkgroup记录
        checkGroupDao.deleteById(id);
        //2,根据id删除t_checkgroup中的记录
        checkGroupDao.deleteGroupById(id);
    }
}
