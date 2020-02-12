package Day02;

public class AnimalDemo {
    public static void main(String[] args) {
    Animal a = new Cat();//向上转型
    a.eat();

    /*Cat c = new Cat();
    c.Catch();*/

    Cat c = (Cat)a;
    c.Catch();



    a=new Pig();
    a.eat();
    Pig p = (Pig)a;
    p.sleep();

     Cat cc = (Cat)a;
     cc.Catch();

    }
}
