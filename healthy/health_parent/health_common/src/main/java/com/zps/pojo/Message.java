package com.zps.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zps on 2019/12/26 14:18
 */
public class Message implements Serializable {
    private Integer id;
    private String send;
    private String receive;
    private String message;
    private Date date;


    public Message() {
    }

    public Message(Integer id, String send, String receive, String message, Date date) {
        this.id = id;
        this.send = send;
        this.receive = receive;
        this.message = message;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", send='" + send + '\'' +
                ", receive='" + receive + '\'' +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }
}
