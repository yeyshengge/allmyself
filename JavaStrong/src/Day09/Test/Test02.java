package Day09.Test;

public class Test02 {
    public static void main(String[] args) {
        me(10);
    }
    public static void me(int a){
        for (int i = 0; i < a; i++) {
            System.out.println(i);
            return;
        }
        System.out.println(a);
    }
}
