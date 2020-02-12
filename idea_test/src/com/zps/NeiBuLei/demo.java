package com.zps.NeiBuLei;

public class demo {

    public class heart {

        public void beat() {
            System.out.println("心跳");
            System.out.println(name);
        }

    }

 private String name;

    public void mathod() {
        System.out.println("外部类方法");
        heart heart = new heart();
        heart.beat();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
