package com.changgou.order.service.impl;

import com.alibaba.fastjson.JSON;
import com.changgou.order.dao.TaskHisMapper;
import com.changgou.order.dao.TaskMapper;
import com.changgou.order.pojo.Task;
import com.changgou.order.pojo.TaskHis;
import com.changgou.order.service.TaskService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by zps on 2020/2/6 20:13
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private TaskHisMapper taskHisMapper;
    @Override
    public void delTask(Task task) {


        //设置删除时间
        task.setDeleteTime(new Date());

        Long id = task.getId();
        task.setId(null);

        TaskHis taskHis = new TaskHis();
        //bean复制
        BeanUtils.copyProperties(task, taskHis);


        task.setId(id);
        //向历史任务记录表中添加数据
        taskHisMapper.insertSelective(taskHis);
        //删除任务
        taskMapper.deleteByPrimaryKey(task);

        System.out.println("-- 5 -- 成功删除任务并且添加到历史任务表 ： "+ JSON.toJSONString(task));

    }
}
