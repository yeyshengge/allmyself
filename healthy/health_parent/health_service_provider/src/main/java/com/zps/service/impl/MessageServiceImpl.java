package com.zps.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zps.dao.MessageDao;
import com.zps.entity.Result;
import com.zps.pojo.Message;
import com.zps.pojo.MessageInfo;
import com.zps.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by zps on 2019/12/26 14:22
 */
@Transactional
@Service(interfaceClass = MessageService.class)
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    @Override
    public Result receive(String send, String receive) {
        List<MessageInfo> dataList = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("send", send);
        map.put("receive", receive);
        List<Message> list = messageDao.receive(map);
        Collections.reverse(list);
        for (Message message : list) {
            if (message.getSend().equals("admin")) {
                dataList.add(new MessageInfo(message.getMessage(), "", message.getDate()));
            } else {
                dataList.add(new MessageInfo("", message.getMessage(), message.getDate()));
            }
        }
        return new Result(true, null, dataList);
    }

    @Override
    public void hsend(Message message) {
        messageDao.hsend(message);
    }

    @Override
    public Result qeceive(String send, String receive) {
        List<MessageInfo> dataList = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("send", send);
        map.put("receive", receive);
        List<Message> list = messageDao.receive(map);
        Collections.reverse(list);
        for (Message message : list) {
            if (message.getSend().equals("admin")) {
                dataList.add(new MessageInfo("", message.getMessage(), message.getDate()));
            } else {
                dataList.add(new MessageInfo(message.getMessage(), "", message.getDate()));
            }
        }
        return new Result(true, null, dataList);
    }
}
