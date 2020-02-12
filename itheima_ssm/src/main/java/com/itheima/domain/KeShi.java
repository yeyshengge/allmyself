package com.itheima.domain;

public class KeShi {
    private int id;
    private String name;

    public KeShi() {
    }

    public KeShi(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "KeShi{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
