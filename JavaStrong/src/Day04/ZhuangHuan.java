package Day04;

public class ZhuangHuan {
    public static void main(String[] args) {
       //intתString�����ַ�ʽ
        int number = 100;
        //ֱ�Ӽӿո�
        String a =number+" ";
        System.out.println(a+100);

        String b =String.valueOf(number);
        System.out.println(b+100);

        String c =Integer.toString(number);
        System.out.println(c+100);

        //Stringתint�����ַ���
        //String---Integer----int

        Integer f = Integer.valueOf("77");
        int i = f;
        System.out.println(i+"--");


        int d=Integer.valueOf("100");
        System.out.println(d+100);

        int e =Integer.parseInt("100");
        System.out.println(e+200);
    }
}
