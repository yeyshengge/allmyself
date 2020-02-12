package com.zps.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.remoting.transport.ExceedPayloadLimitException;
import com.zps.constant.MessageConstant;
import com.zps.entity.PageResult;
import com.zps.entity.QueryPageBean;
import com.zps.entity.Result;
import com.zps.pojo.CheckGroup;
import com.zps.pojo.Setmeal;
import com.zps.service.SetMealService;
import com.zps.utils.ALiFileUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by zps on 2019/12/17 9:12
 */
@RestController
@RequestMapping("/setMeal")
public class SetMealController {

    @Reference
    private SetMealService setMealService;

    @RequestMapping("/upload")
    public Result upload(@RequestParam("imgFile") MultipartFile multipartFile) throws Exception {
        try {
            String filename = multipartFile.getOriginalFilename();
            String contentType = multipartFile.getContentType();
            //文件名字处理
            String newFilename = UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."), filename.length());
            ALiFileUtils.uploadWithSpace(multipartFile.getBytes(), newFilename);
            return new Result(true, MessageConstant.UPLOAD_SUCCESS, newFilename);
        } catch (IOException e) {
            return new Result(false, MessageConstant.PIC_UPLOAD_FAIL);
        }
    }

    @RequestMapping("/findCheckGroup")
    public Result findCheckGroup() {
        try {
            List<CheckGroup> list = setMealService.findCheckGroup();
            return new Result(true, null, list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, null);
        }
    }

    @RequestMapping("/findAll")
    public PageResult findAll(@RequestBody QueryPageBean queryPageBean) {
        return setMealService.findAll(queryPageBean);
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Setmeal setmeal, Integer[] checkgroupIds) {
        try {
            setMealService.add(setmeal,checkgroupIds);
            return new Result(true,MessageConstant.ADD_SETMEAL_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.ADD_SETMEAL_FAIL);
        }
    }


}
