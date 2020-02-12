package com.zps.domain;

import java.io.Serializable;

/**
 * Created by zps on 2019/12/29 20:19
 */
public class User implements Serializable {
    private String id;
    private String username;
    private String email;
    private String phone;
    private String state;

    public User() {
    }

    public User(String id, String username, String email, String phone, String state) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
