package Day02;

public class MyTest {
    public static void main(String[] args) {
        MyAnimal ma = new MyCat();//����ת��
        ma.setName("�ӷ�è");

        ma.setAge(18);
        ma.eat();
        System.out.println(ma.getName() + ma.getAge());

        MyCat mc = (MyCat) ma;
        mc.Catch();//����ת��

        MyAnimal md = new MyDog();//����ת��
        md.setName("����");
        md.setAge(16);
        md.eat();
        System.out.println(md.getName() + md.getAge());

        MyDog m = (MyDog) md;
        m.look();
    }
}
