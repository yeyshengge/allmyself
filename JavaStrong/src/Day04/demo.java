package Day04;

//װ�������
public class demo {
    public static void main(String[] args) {
        Integer i = Integer.valueOf(100);

        System.out.println(i);

        Integer ii = 100;//�Զ�װ�䣻Integer.valueOf(100)

        i += 100;//�൱��i=i+100; i.intValue()+100�Զ����䣬Ȼ��Ѽ����intֵ�Զ�װ��ΪInteger��

        Integer iii = null;//NullPointerException ����Ϊ�ղ��ܵ��÷�������Ȼ�Ϳ�ָ���쳣

        if (iii != null) {
            System.out.println(iii.intValue());

        }

        long a = Integer.MAX_VALUE;
        System.out.println(a);
    }
}
