package Day02.implementsdemo;

public abstract class MyAnimal {
    private String name;
    private int age;

    public abstract void eat();

    public MyAnimal() {
    }

    public MyAnimal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
