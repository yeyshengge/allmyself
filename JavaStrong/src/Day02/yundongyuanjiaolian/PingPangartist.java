package Day02.yundongyuanjiaolian;

public class PingPangartist extends YunDongYuan implements English{
    public PingPangartist() {
    }

    public PingPangartist(String name, int age) {
        super(name, age);
    }

    @Override
    public void study() {
        System.out.println("ѧƹ����");
    }

    @Override
    public void eat() {
        System.out.println("ƹ�����˶�Ա�Է�");
    }

    @Override
    public void speak() {
        System.out.println("˵Ӣ��");
    }
}
