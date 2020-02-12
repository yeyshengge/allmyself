package Day08.demo;

/*
求任何数的递归 5！=5*4*3*2*1;
 */

public class QiuDiGui {
    public static void main(String[] args) {
        System.out.println(f(4));
    }

    //递归的方法：参考f(n)=f(n-1)+f(n-2)...   1 1 2 3 5 8 11 19...
    public static int f(int n) {
        if (n == 1) {
            return 1;
        } else {
            return f(n - 1) * n;
        }

    }
}
