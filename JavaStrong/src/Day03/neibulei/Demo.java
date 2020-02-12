package Day03.neibulei;
//内部类可以直接访问外部类的成员，包括私有
//外部类要是访问内部类的成员，必须创建对象
public class Demo {



    private int a = 15;
    public class Inner{
      public void show(){
          System.out.println(a+15);
      }
    }

    public void method(){
        Inner i = new Inner();
        i.show();
    }
}
