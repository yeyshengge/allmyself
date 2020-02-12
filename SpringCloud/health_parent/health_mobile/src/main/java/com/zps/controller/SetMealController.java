package com.zps.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zps.entity.Result;
import com.zps.pojo.Setmeal;
import com.zps.service.SetMealService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zps on 2019/12/21 14:44
 */
@RestController
@RequestMapping("/setMeal")
public class SetMealController {


    @Reference
    private SetMealService setMealService;

    @RequestMapping("/findSetMealAll")
    public Result findSetMealAll() {
        try {
            List<Setmeal> list = setMealService.findSetMealAll();
            return new Result(true, null, list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, null);
        }
    }

    @RequestMapping("/findById")
    public Result findById(Integer id) {
        try {
           Setmeal setmeal = setMealService.findById(id);
            return new Result(true, null, setmeal);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, null);
        }
    }
}
