package Day02.Work;

public class test03 {
    public static void main(String[] args) {
        Breeder b = new Breeder();
        Animal d = new Dog();
        b.breed(d);
        Dog dd = (Dog) d;
        dd.swimming();

        System.out.println();

        d = new Frog();
        b.breed(d);
        Frog f = (Frog) d;
        f.swimming();

        System.out.println();

        d = new Sheep();
        b.breed(f);

    }
}
