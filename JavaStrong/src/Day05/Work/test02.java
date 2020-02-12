package Day05.Work;

public class test02 {
    public static void main(String[] args) {
        int a=11;
        int b=12;
        int c=10;
        method1(a,b,c);
        method2(a,b,c);
    }


    public static void method1(int a,int b,int c){
        int temp=a>b?a:b;
        System.out.println("最大值为"+(temp>c?temp:c));

    }
    public static void method2(int a,int b,int c){
        int sum=a+b+c;
        System.out.println("和为"+sum);
    }
}
