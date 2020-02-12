package Day02;

public class MyDog extends MyAnimal{
    public MyDog() {
    }

    public MyDog(String name, int age) {
        super(name, age);
    }
    @Override
    public void eat(){
        System.out.println("π∑≥‘π«Õ∑");
    }
    public void look(){
        System.out.println("π∑ø¥√≈");
    }
}
