package com.zps.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zps.entity.PageResult;
import com.zps.entity.QueryPageBean;
import com.zps.entity.Result;
import com.zps.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by zps on 2019/12/25 9:07
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Reference
    private PermissionService permissionService;

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {

        return permissionService.findPage(queryPageBean);

    }
}
