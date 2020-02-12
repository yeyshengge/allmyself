package com.zps.service;

import com.zps.entity.PageResult;
import com.zps.entity.QueryPageBean;

/**
 * Created by zps on 2019/12/25 9:11
 */
public interface PermissionService {
    PageResult findPage(QueryPageBean queryPageBean);

}
