package Day02.implementsdemo;

public class MyDog extends MyAnimal implements MyJumpping{
    public MyDog() {
    }

    public MyDog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("���Թ�ͷ");
    }

    @Override
    public void jump() {
        System.out.println("������");
    }
}
