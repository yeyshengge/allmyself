package Day02;

public class MyCat extends MyAnimal{
    public MyCat() {
    }

    public MyCat(String name, int age) {
        super(name, age);
    }
    @Override
    public void eat(){
        System.out.println("Ã¨³ÔÓã");
    }
    public void Catch(){
        System.out.println("Ã¨×¥ÀÏÊó");
    }
}
