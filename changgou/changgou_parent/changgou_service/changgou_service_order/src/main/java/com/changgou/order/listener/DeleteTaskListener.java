package com.changgou.order.listener;

import com.alibaba.fastjson.JSON;
import com.changgou.order.config.RabbitMQConfig;
import com.changgou.order.pojo.Task;
import com.changgou.order.service.TaskService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zps on 2020/2/6 20:09
 */
@Component
public class DeleteTaskListener {


    @Autowired
    private TaskService taskService;

    @RabbitListener(queues = RabbitMQConfig.CG_BUYING_FINISHADDPOINT)
    public void deleteTask(String message){

        System.out.println("-- 4 -- 成功接收到已完成添加积分队列的信息 ： "+message);
        Task task = JSON.parseObject(message, Task.class);

        taskService.delTask(task);


    }

}
