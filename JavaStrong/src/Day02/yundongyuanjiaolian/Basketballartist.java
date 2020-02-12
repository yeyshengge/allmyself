package Day02.yundongyuanjiaolian;

public class Basketballartist extends YunDongYuan{

    public Basketballartist() {
    }

    public Basketballartist(String name, int age) {
        super(name, age);
    }

    @Override
    public void study() {
        System.out.println("学篮球");
    }

    @Override
    public void eat() {
        System.out.println("篮球运动员吃饭");
    }
}
