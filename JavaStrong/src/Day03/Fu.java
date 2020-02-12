package Day03;

public class Fu {
     public static void show01() {
        System.out.println("public");
    }

    static void show02() {
        System.out.println("default");
    }

    private static void show03() {
        System.out.println("private");
    }

    protected static void show04() {
        System.out.println("protected");
    }

    public static void main(String[] args) {
        Fu f = new Fu();
        System.out.println(f);
        f.show01();
        f.show02();
        f.show03();
        f.show04();
    }

}
