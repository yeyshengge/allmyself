package com.zps.NeiBuLei;

public class DemoMain {
    public static void main(String[] args) {
        Hero hero = new Hero();
        hero.setName("张翩笙");
        hero.setAge(18);

        Weapon weapon = new Weapon("lao");
        hero.setWeapon(weapon);


        hero.attack();

    }
}
