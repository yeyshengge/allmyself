package Day02.yundongyuanjiaolian;

public class PingPangJiaoLian extends JiaoLian {
    public PingPangJiaoLian() {
    }

    public PingPangJiaoLian(String name, int age) {
        super(name, age);
    }

    @Override
    public void teach() {
        System.out.println("��ƹ����");
    }

    @Override
    public void eat() {
        System.out.println("ƹ��������Է�");
    }
}
