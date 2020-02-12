package Day02.Work;

public class Frog extends Animal implements Swim{
    public Frog() {
    }

    public Frog(int age) {
        super(age);
    }

    @Override
    public void drink() {
        System.out.println("���ܺ�ˮ");
    }

    @Override
    public void eat() {
        System.out.println("�Գ���");
    }

    @Override
    public void swimming() {
        System.out.println("��Ӿ");
    }
}
