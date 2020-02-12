package com.zps.domain;

public class User {
    private String username;
    private String address;

    public String getUsername() {
        return username;
    }

    public User(String username, String address) {
        this.username = username;
        this.address = address;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
