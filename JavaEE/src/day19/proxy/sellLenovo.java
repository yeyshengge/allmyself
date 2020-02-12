package day19.proxy;

public class sellLenovo implements lenovo {
    @Override
    public String sell(int money) {
        System.out.println("花了"+money+"钱买了一台电脑");
        return "联想电脑";
    }

    @Override
    public void show() {
        System.out.println("展示联想电脑");
    }
}
