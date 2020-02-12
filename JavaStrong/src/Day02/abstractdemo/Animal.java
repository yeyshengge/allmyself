package Day02.abstractdemo;

public abstract class Animal {

    private  int age =20;
    private  String name = "±±¾©";
    public abstract void eat();


    Animal(){}

    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

