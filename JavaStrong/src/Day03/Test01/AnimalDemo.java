package Day03.Test01;

public class AnimalDemo {
    public static void main(String[] args) {
        AnimalOpt ao = new AnimalOpt();
        Animal a = new Cat();
        ao.show(a);

        Animal b = ao.show01();//new Cat()
       // Animal animal = ao.show01();

        b.eat();
    }
}