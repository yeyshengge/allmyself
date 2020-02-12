package Day06;

/*
可变参数，这里的变量其实是个数组
如果有多个参数，则把可变参数放最后面，这样就可以单独操作第一个数跟后面的可变参数了，比如后面相加再乘以第一个
 */
public class KeBianCanShu {

    public static void main(String[] args) {
        System.out.println(getSum(10, 20));
        System.out.println(getSum(10, 20, 30));
        System.out.println(getSum(10, 20, 30, 40));

    }
    // 可变参数其实是个数组
    public static int getSum(int b, int... i) {
        int sum = 0;
        for (int a : i) {
            sum += a;
        }
        return b * sum;
    }

    //如果有多个参数，则把可变参数放最后面，这样就可以单独操作第一个数跟后面的可变参数了，比如后面相加再乘以第一个
    public static int getSum1(int b, int... i) {
        int sum = 0;
        for (int a : i) {
            sum += a;
        }
        return b * sum;
    }

}
