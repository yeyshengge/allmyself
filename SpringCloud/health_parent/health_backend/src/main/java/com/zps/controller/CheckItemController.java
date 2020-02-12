package com.zps.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zps.constant.MessageConstant;
import com.zps.entity.PageResult;
import com.zps.entity.QueryPageBean;
import com.zps.entity.Result;
import com.zps.pojo.CheckGroup;
import com.zps.pojo.CheckItem;
import com.zps.service.CheckItemService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zps on 2019/12/14 18:27
 */
@RestController()
@RequestMapping("/checkItem")
public class CheckItemController {

    @Reference
    private CheckItemService checkItemService;

    @RequestMapping("/test/{id}")
    public void test(@PathVariable("id") Long id) {
        System.out.println(id);
    }


    @RequestMapping("/findAll")
    public PageResult findAll(@RequestBody QueryPageBean queryPageBean) {
        return checkItemService.findAll(queryPageBean);

    }


    @RequestMapping("/add")
    public Result add(@RequestBody CheckItem checkItem) {
        try {
            checkItemService.add(checkItem);
            return new Result(true, MessageConstant.ADD_CHECKITEM_SUCCESS);
        } catch (Exception e) {
            return new Result(false, MessageConstant.ADD_CHECKITEM_FAIL);
        }
    }

    @RequestMapping("/findItem")
    public Result findItem() {
        try {
            List<CheckGroup> list = checkItemService.findItem();
            return new Result(true, null, list);
        } catch (Exception e) {
            return new Result(false, null);
        }

    }

}
