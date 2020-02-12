package Day13.demo.privatedemo;

public interface MyInter {
    default void show01() {
        System.out.println("开始");
//        System.out.println("1");
//        System.out.println("2");
//        System.out.println("3");
        //ok();
        System.out.println("结束");
    }

    default void show02() {
        System.out.println("开始");
//        System.out.println("1");
//        System.out.println("2");
//        System.out.println("3");
        //ok();
        System.out.println("结束");
    }

    static void method01() {
        System.out.println("开始");
//        System.out.println("1");
//        System.out.println("2");
//        System.out.println("3");
        //ok();
        System.out.println("结束");
    }

    static void method02() {
        System.out.println("开始");
//        System.out.println("1");
//        System.out.println("2");
//        System.out.println("3");
       // ok();
        System.out.println("结束");
    }

   /* private static void ok() {
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
    }*/
}
