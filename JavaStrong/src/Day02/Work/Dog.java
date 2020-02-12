package Day02.Work;

public class Dog extends Animal implements Swim{

    public Dog() {
    }

    public Dog(int age) {
        super(age);
    }

    @Override
    public void drink() {
        System.out.println("π∑∫»ÀÆ");
    }

    @Override
    public void eat() {
        System.out.println("ø–π«Õ∑");
    }

    @Override
    public void swimming() {
        System.out.println("π∑≈ø”Œ”æ");
    }
}
