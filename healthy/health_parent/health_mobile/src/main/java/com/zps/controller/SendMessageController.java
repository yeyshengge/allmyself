package com.zps.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zps.entity.Result;
import com.zps.pojo.Message;
import com.zps.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zps on 2019/12/26 19:05
 */
@RestController
@RequestMapping("/qmessage")
public class SendMessageController {

    @Reference
    private MessageService messageService;

    @RequestMapping("/qreceive")
    public Result QReceive(String name) {
        Result receive = messageService.qeceive(name, "admin");
        return receive;
    }

    @RequestMapping("/gsend")
    public Result gsend(@RequestBody Message message) {
        message.setReceive("admin");
        try {
            messageService.hsend(message);
            return new Result(true, "发送成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发送失败");
        }
    }
}
