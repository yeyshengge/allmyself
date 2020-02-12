package Day02.Work;

public abstract class Animal {
    private int age;


    public abstract void drink();
    public abstract void eat();

    public Animal() {
    }

    public Animal(int age) {
        this.age = age;
    }
}
