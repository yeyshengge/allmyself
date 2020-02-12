package Day02.Work;

public class KeyBoard implements UsbInter {
    @Override
    public void open() {
        System.out.println("´ò¿ª¼üÅÌ");
    }

    @Override
    public void close() {
        System.out.println("¹Ø±Õ¼üÅÌ");
    }
}
