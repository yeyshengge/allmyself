package com.zps.doutai;

/*
 * 如何知道父类引用的对象，本来是什么子类：Instanceof
 * */
public class DemoInstanceof {

    public static void main(String[] args) {
        Animal animal = new Dog();
        // animal.eat();


        GivePet(animal);

    }

    public static void GivePet(Animal animal) {
        if (animal instanceof Cat) {
            Cat cat = (Cat) animal;
            cat.run();
            cat.eat();
        }
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.eat();
            dog.show();
        }
    }

}


