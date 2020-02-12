package com.zps.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zps.constant.MessageConstant;
import com.zps.constant.RedisConstant;
import com.zps.entity.PageResult;
import com.zps.entity.QueryPageBean;
import com.zps.entity.Result;
import com.zps.pojo.CheckGroup;
import com.zps.pojo.Setmeal;
import com.zps.service.SetMealService;
import com.zps.utils.ALiFileUtils;
import com.zps.utils.QiniuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/setMeal")
public class SetMealController {

    @Reference
    private SetMealService setMealService;

    @Autowired
    private JedisPool jedisPool;

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        PageResult pageResult = setMealService.findPage(queryPageBean);
        System.out.println(pageResult);
        return pageResult;
    }

    @RequestMapping("/add")
    public Result add(Integer[] checkgroupIds, @RequestBody Setmeal setmeal) {
        try {
            setMealService.add(checkgroupIds, setmeal);
        } catch (Exception e) {
            return new Result(false, MessageConstant.ADD_SETMEAL_FAIL);
        }
        return new Result(true, MessageConstant.ADD_SETMEAL_SUCCESS);

    }


    @RequestMapping("/upload")
    public Result upload(@RequestParam("imgFile") MultipartFile imgFile) {
        //获取全球唯一的id
        String uuid = UUID.randomUUID().toString();
        //获取上传文件的类型.jsp
        int index = imgFile.getOriginalFilename().lastIndexOf(".");
        String exetion = imgFile.getOriginalFilename().substring(index, imgFile.getOriginalFilename().length());
        String fileName = uuid + exetion;
        System.out.println(fileName);
        try {
            /*  QiniuUtils.upload2Qiniu(imgFile.getBytes(), fileName);*/
            ALiFileUtils.upload(imgFile.getBytes(), fileName);
            //图片上传成功之后，继续在jedis中存储
            jedisPool.getResource().sadd(RedisConstant.SETMEAL_PIC_RESOURCES, fileName);
        } catch (IOException e) {
            return new Result(false, MessageConstant.PIC_UPLOAD_FAIL);
        }
        return new Result(true, MessageConstant.PIC_UPLOAD_SUCCESS, fileName);

    }

    /**
     * 查询新建的检查组
     *
     * @return
     */
    @RequestMapping("/findCheckGroupAll")
    public Result findCheckGroupAll() {
        List<CheckGroup> list = setMealService.findCheckGroupAll();
        return new Result(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS, list);
    }
}
