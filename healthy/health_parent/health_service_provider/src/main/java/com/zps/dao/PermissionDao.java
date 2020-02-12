package com.zps.dao;

import com.github.pagehelper.Page;

/**
 * Created by zps on 2019/12/25 9:16
 */
public interface PermissionDao {

    Page findPage(String queryString);

}
