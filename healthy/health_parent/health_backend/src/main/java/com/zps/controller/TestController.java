package com.zps.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zps.entity.Result;
import com.zps.pojo.Member;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zps on 2019/12/28 9:44
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Reference
    private Member userController;

    @RequestMapping(value = "/{num}", produces = "text/plain;charset=utf-8")
    public Result method(@PathVariable Integer num) {

        int a = num / 0;
        return new Result(false, "算数错误 /by zero");
    }

}
