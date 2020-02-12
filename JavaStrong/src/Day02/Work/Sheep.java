package Day02.Work;

public class Sheep extends Animal{
    public Sheep() {
    }

    public Sheep(int age) {
        super(age);
    }

    @Override
    public void drink() {
        System.out.println("ÑòºÈË®");
    }

    @Override
    public void eat() {
        System.out.println("Ñò¿Ð²Ý");
    }
}
