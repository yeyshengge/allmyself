package Day13.demo.yinyong;

public class MyInterDemo {
    public static void main(String[] args) {
        show((s)->{
            System.out.println(s);
        });

        show(s-> System.out.println(s));

        show(System.out::println);


    }
    private static void show(MyInter i ){
        i.method("啦啦啦");
    }
}
