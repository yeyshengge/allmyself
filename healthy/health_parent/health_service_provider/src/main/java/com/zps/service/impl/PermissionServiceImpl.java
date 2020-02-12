package com.zps.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zps.dao.PermissionDao;
import com.zps.entity.PageResult;
import com.zps.entity.QueryPageBean;
import com.zps.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zps on 2019/12/25 9:13
 */
@Service(interfaceClass = PermissionService.class)
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;
    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {

        //获取参数
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();
        //分页助手
        PageHelper.startPage(currentPage, pageSize);
        //page中封装了很多的参数
        Page page = permissionDao.findPage(queryString);
        return new PageResult(page.getTotal(), page.getResult());


    }
}
