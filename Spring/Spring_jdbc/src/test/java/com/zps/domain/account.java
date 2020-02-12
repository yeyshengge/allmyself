package com.zps.domain;

public class account {
    private String name;
    private double money;

    public account(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public account() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "domain{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
