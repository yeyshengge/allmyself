package com.zps.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zps on 2019/12/26 14:43
 */
public class MessageInfo  implements Serializable {
    private String send;
    private String receive;
    private Date date;

    public MessageInfo() {
    }

    public MessageInfo(String send, String receive, Date date) {
        this.send = send;
        this.receive = receive;
        this.date = date;
    }

    public String getSend() {
        return send;
    }

    public void setSend(String send) {
        this.send = send;
    }

    public String getReceive() {
        return receive;
    }

    public void setReceive(String receive) {
        this.receive = receive;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "MessageInfo{" +
                "send='" + send + '\'' +
                ", receive='" + receive + '\'' +
                ", date=" + date +
                '}';
    }
}
