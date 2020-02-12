package Day02.abstractdemo;

public class Cat extends Animal {

    public Cat() {
    }

    public Cat(int age, String name) {
        super(age, name);
    }

    @Override
    public void eat() {
        System.out.println("Ã¨³ÔÓã");
    }
    public void Catch(){
        System.out.println("×¥ÀÏÊó");
    }
}
