package com.zps.doutai;

public class Demo03Multi{

    public static void main(String[] args) {
        //向上转型
        Animal animal = new Cat();
        animal.eat();
        //想下转型
        Cat cat = (Cat)animal;
        cat.run();

    }
}
