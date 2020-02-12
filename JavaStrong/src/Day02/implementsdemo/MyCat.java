package Day02.implementsdemo;

public class MyCat extends MyAnimal implements MyJumpping{

    public MyCat() {
    }

    public MyCat(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("Ã¨³ÔÓã");
    }

    @Override
    public void jump() {
        System.out.println("Ã¨Ìø¸ß");
    }
}
