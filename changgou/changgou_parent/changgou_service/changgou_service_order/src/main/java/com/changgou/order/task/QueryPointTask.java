package com.changgou.order.task;

import com.alibaba.fastjson.JSON;
import com.changgou.order.config.RabbitMQConfig;
import com.changgou.order.dao.TaskMapper;
import com.changgou.order.pojo.Task;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by zps on 2020/2/6 17:42
 */
@Component
public class QueryPointTask {

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Scheduled(cron = "0/5 * * * * ?")
    public void queryTask() {
        //获取更新时间小于当前时间的数据
        List<Task> taskList = taskMapper.findTaskLessThanCurrentTime(new Date());
        System.out.println("定时任务执行 查询到的task : " + taskList);
        //发送到rabbitMQ
        if (taskList != null && taskList.size() > 0) {
            for (Task task : taskList) {
                rabbitTemplate.convertAndSend(RabbitMQConfig.EX_BUYING_ADDPOINTUSER, RabbitMQConfig.CG_BUYING_ADDPOINT_KEY, JSON.toJSONString(task));
                System.out.println("-- 1 --向增加积分队列添加了一条数据 ： " + JSON.toJSONString(task));
            }
        }
    }
}
