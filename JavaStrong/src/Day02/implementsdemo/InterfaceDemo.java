package Day02.implementsdemo;

public class InterfaceDemo {
    public static void main(String[] args) {
        Inter i= new InterImpl();
       // i.num=50;//�ӿ���û�б�����
        System.out.println(i.num);
        //i.num2= 50;
        System.out.println(i.num2);
        System.out.println(Inter.num);//����ĳ�������static����




    }
}
