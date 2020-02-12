package Day02.implementsdemo;

public class InterfaceDemo {
    public static void main(String[] args) {
        Inter i= new InterImpl();
       // i.num=50;//接口中没有变量，
        System.out.println(i.num);
        //i.num2= 50;
        System.out.println(i.num2);
        System.out.println(Inter.num);//定义的常量还是static类型




    }
}
