package Day01.Work;

public class Work03Test {
    public static void main(String[] args) {
        Cat c = new Cat("�ӷ�è",18);
        System.out.println(c.getName()+c.getAge());
        c.eat();

        Dog d =new Dog();
        d.setName("��ʿ��");
        d.setAge(50);
        System.out.println(d.getName()+c.getAge());
        d.eat();
    }
}
