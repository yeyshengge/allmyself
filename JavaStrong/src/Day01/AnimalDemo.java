package Day01;

public class AnimalDemo {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setName("��è");
        cat.setAge(18);
        cat.zhuang();
        System.out.println(cat.getName() + cat.getAge());

        Dog dog = new Dog("��ʿ��", 18);
        System.out.println(dog.getName() + dog.getAge());
    }
}