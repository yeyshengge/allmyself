package Day02.Work;

public class Dog extends Animal implements Swim{

    public Dog() {
    }

    public Dog(int age) {
        super(age);
    }

    @Override
    public void drink() {
        System.out.println("����ˮ");
    }

    @Override
    public void eat() {
        System.out.println("�й�ͷ");
    }

    @Override
    public void swimming() {
        System.out.println("��ſ��Ӿ");
    }
}
