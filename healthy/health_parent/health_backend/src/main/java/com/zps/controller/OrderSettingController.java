package com.zps.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zps.constant.MessageConstant;
import com.zps.entity.Result;
import com.zps.pojo.OrderSetting;
import com.zps.service.OrderSettingService;
import com.zps.utils.POIUtils;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ordersetting")
public class OrderSettingController {

    @Reference
    private OrderSettingService orderSettingService;


    @RequestMapping("/set")
    public Result set(@RequestBody OrderSetting orderSetting) {
        try {
            orderSettingService.set(orderSetting);
            return new Result(true, MessageConstant.ORDERSETTING_SUCCESS);
        } catch (Exception e) {
            return new Result(false, MessageConstant.ORDERSETTING_FAIL);
        }
    }

    @RequestMapping("/findPageByDate")
    public Result findPageByDate(String date) {
        try {
            List<Map> list = orderSettingService.findPageByDate(date);
            return new Result(true, MessageConstant.GET_ORDERSETTING_SUCCESS, list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.GET_ORDERSETTING_FAIL);

        }
    }

    @RequestMapping("/upload")
    public Result upload(@RequestParam("excelFile") MultipartFile multipartFile) {
        try {
            //检测文件的合法性
            POIUtils.checkFile(multipartFile);
            //解析数据
            List<String[]> list = POIUtils.readExcel(multipartFile);
            //判断集合是否有数据
            List<OrderSetting> data = new ArrayList<>();
            if (list != null && list.size() > 0) {
                for (String[] li : list) {
                    data.add(new OrderSetting(new Date(li[0]), Integer.parseInt(li[1])));
                }
            }
            System.out.println(data);
            orderSettingService.add(data);
        } catch (IOException e) {
            return new Result(false, MessageConstant.IMPORT_ORDERSETTING_FAIL);
        }
        return new Result(true, MessageConstant.IMPORT_ORDERSETTING_SUCCESS);
    }
}
