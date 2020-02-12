package Day02;

public class MyTest {
    public static void main(String[] args) {
        MyAnimal ma = new MyCat();//向上转型
        ma.setName("加菲猫");

        ma.setAge(18);
        ma.eat();
        System.out.println(ma.getName() + ma.getAge());

        MyCat mc = (MyCat) ma;
        mc.Catch();//向下转型

        MyAnimal md = new MyDog();//向上转型
        md.setName("狗蛋");
        md.setAge(16);
        md.eat();
        System.out.println(md.getName() + md.getAge());

        MyDog m = (MyDog) md;
        m.look();
    }
}
