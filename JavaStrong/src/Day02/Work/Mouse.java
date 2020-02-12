package Day02.Work;

public class Mouse implements UsbInter {
    @Override
    public void open() {
        System.out.println("使用鼠标usb");
    }

    @Override
    public void close() {
        System.out.println("关闭鼠标usb");
    }
}
