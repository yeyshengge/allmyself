package Day02.abstractdemo;

public class AnimalDemo {
    public static void main(String[] args) {
        Animal a = new Cat();
        a.setName("¼Ó·ÆÃ¨");
        a.setAge(5);
        System.out.println(a.getName() + a.getAge());
        a.eat();
        Cat c =(Cat)a;
        c.Catch();

        a= new Dog(51,"¹·µ°");
        a.eat();
    }

}
