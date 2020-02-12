package com.zps.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zps.dao.CheckItemDao;
import com.zps.entity.PageResult;
import com.zps.entity.QueryPageBean;
import com.zps.pojo.CheckGroup;
import com.zps.pojo.CheckItem;
import com.zps.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zps on 2019/12/14 18:43
 */
@Service(interfaceClass = CheckItemService.class)
public class CheckItemServiceImpl implements CheckItemService {

    @Autowired
    private CheckItemDao checkItemDao;

    @Override
    public void add(CheckItem checkItem) {
        checkItemDao.add(checkItem);
    }

    @Override
    public PageResult findAll(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();

        if (queryString != null && queryString.length() > 0 && !"".equals(queryString)) {
            currentPage = 1;
        }
        PageHelper.startPage(currentPage, pageSize);
        Page<CheckItem> page = checkItemDao.findAll(queryString);
        List<CheckItem> result = page.getResult();
        long total = page.getTotal();
        return new PageResult(total, result);

    }

    @Override
    public List<CheckGroup> findItem() {
        return checkItemDao.findItem();
    }
}
