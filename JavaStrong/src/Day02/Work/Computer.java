package Day02.Work;

public class Computer {


    public void use() {
        UsbInter u = new Mouse();
        u.open();
        u.close();
        UsbInter u2 = new KeyBoard();
        u2.open();
        u2.close();

    }


    public void turnOn() {
        System.out.println("�ʼǱ�����");
    }

    public void turnOff() {
        System.out.println("�ʼǱ��ػ�");
    }
}
