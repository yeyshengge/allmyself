package Day02.implementsdemo;

public class MyAnimalDemo {

    public static void main(String[] args) {

        MyJumpping mj = new MyCat();
        mj.jump();

        MyAnimal a = new MyCat("¼Ó·ÆÃ¨", 18);
        System.out.println(a.getName() + a.getAge());
        a.eat();
        MyCat mc = (MyCat) a;
        mc.jump();

        MyCat myCat = new MyCat();
        myCat.jump();
        myCat.eat();


    }
}
