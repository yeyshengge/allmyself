package com.zps.domain;

public class Part {
    private int id;
    private String name;
    private int x_id;

    public Part() {
    }

    public Part(int id, String name, int x_id) {
        this.id = id;
        this.name = name;
        this.x_id = x_id;
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

    public int getX_id() {
        return x_id;
    }

    public void setX_id(int x_id) {
        this.x_id = x_id;
    }

    @Override
    public String toString() {
        return "Part{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", x_id=" + x_id +
                '}';
    }
}
