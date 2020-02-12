package com.zps.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zps.constant.MessageConstant;
import com.zps.entity.Result;
import com.zps.pojo.OrderSetting;
import com.zps.service.OrderSettingService;
import com.zps.utils.POIUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

/**
 * Created by zps on 2019/12/19 9:12
 */
@RestController
@RequestMapping("/orderSetting")
public class OrderSettingController {

    @Reference
    private OrderSettingService orderSettingService;

    @RequestMapping("/upload")
    public Result upload(MultipartFile excelFile) throws Exception {
        try {
            List<String[]> strings = POIUtils.readExcel(excelFile);
            List<OrderSetting> list = new ArrayList<>();
            for (String[] string : strings) {
                list.add(new OrderSetting(new Date(string[0]), Integer.parseInt(string[1])));
            }
            orderSettingService.upload(list);
            return new Result(true, MessageConstant.UPLOAD_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "模板上传失败");
        }
    }

    @RequestMapping("/findAll")
    public Result findAll(String date) {
        try {
            List<Map> list = orderSettingService.findAll(date);
            return new Result(true, null, list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, null);
        }
    }

    @RequestMapping("/set")
    public Result set(@RequestBody OrderSetting orderSetting) {

        try {
            orderSettingService.set(orderSetting);
            return new Result(true, "设置预约人数成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "设置预约人数失败");
        }
    }
}
