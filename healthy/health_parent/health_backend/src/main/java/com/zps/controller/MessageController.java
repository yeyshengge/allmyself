package com.zps.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zps.entity.Result;
import com.zps.pojo.Message;
import com.zps.service.MessageService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zps on 2019/12/26 14:04
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    @Reference
    private MessageService messageService;

    @RequestMapping("/hreceive")
    public Result receive(String name) {
        return messageService.receive("admin",name);
    }

    @RequestMapping("/hsend")
    public Result hsend(@RequestBody Message message) {

        message.setSend("admin");
        try {
            messageService.hsend(message);
            return new Result(true, "发送成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发送失败");
        }
    }
}
