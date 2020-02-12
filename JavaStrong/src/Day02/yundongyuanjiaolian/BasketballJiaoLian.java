package Day02.yundongyuanjiaolian;

public class BasketballJiaoLian extends JiaoLian {
    public BasketballJiaoLian() {
    }

    public BasketballJiaoLian(String name, int age) {
        super(name, age);
    }

    @Override
    public void teach() {
        System.out.println("ΩÃ¿∫«Ú");
    }

    @Override
    public void eat() {
        System.out.println("¿∫«ÚΩÃ¡∑≥‘∑π");
    }
}
