package Day02;

public class MyDog extends MyAnimal{
    public MyDog() {
    }

    public MyDog(String name, int age) {
        super(name, age);
    }
    @Override
    public void eat(){
        System.out.println("���Թ�ͷ");
    }
    public void look(){
        System.out.println("������");
    }
}
