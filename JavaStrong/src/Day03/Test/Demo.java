package Day03.Test;

public class Demo {
    public static void main(String[] args) {
        CatOp co = new CatOp();
        Cat c = new Cat();
        co.show(c);

        Cat cat = co.show01();
        cat.eat();

    }
}
