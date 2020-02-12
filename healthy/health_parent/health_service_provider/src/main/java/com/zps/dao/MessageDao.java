package com.zps.dao;

import com.zps.pojo.Message;

import java.util.List;
import java.util.Map;

/**
 * Created by zps on 2019/12/26 14:22
 */
public interface MessageDao {
    List<Message> receive(Map<String, String> map);

    void hsend(Message message);

}
