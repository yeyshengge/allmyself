package com.zps.service;

import com.zps.entity.Result;
import com.zps.pojo.Message;

/**
 * Created by zps on 2019/12/26 14:21
 */
public interface MessageService {
    Result receive(String send,String receive);

    void hsend(Message message);

    Result qeceive(String send, String receive);

}
