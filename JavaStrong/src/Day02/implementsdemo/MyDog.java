package Day02.implementsdemo;

public class MyDog extends MyAnimal implements MyJumpping{
    public MyDog() {
    }

    public MyDog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("¹·³Ô¹ÇÍ·");
    }

    @Override
    public void jump() {
        System.out.println("¹·Ìø¸ß");
    }
}
