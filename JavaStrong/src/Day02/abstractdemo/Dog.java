package Day02.abstractdemo;

public  class Dog extends Animal {
    public Dog() {
    }

    public Dog(int age, String name) {
        super(age, name);
    }

    @Override
    public void eat() {
        System.out.println("¹·³Ô¹ÇÍ·");
    }
}

