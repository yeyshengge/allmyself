package Day02.Work;

public class Mouse implements UsbInter {
    @Override
    public void open() {
        System.out.println("ʹ�����usb");
    }

    @Override
    public void close() {
        System.out.println("�ر����usb");
    }
}
