package Day01;

public class AnimalDemo {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setName("°×Ã¨");
        cat.setAge(18);
        cat.zhuang();
        System.out.println(cat.getName() + cat.getAge());

        Dog dog = new Dog("¹þÊ¿Ææ", 18);
        System.out.println(dog.getName() + dog.getAge());
    }
}