package Day04.Work.subject1;
/*һ:����¼��һ�����,�жϸ����Ƿ�Ϊ����
	�����ַ�ʽ���:
	��һ�ֿ��Ը��ݶ��¹��ж��������ж�
	�ڶ��ֿ��Ը���һ���ܹ��ж��������ж�*/


import java.util.Calendar;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please int year:");
        int a = input.nextInt();

       /* //��һ�ַ���
        Calendar cal = Calendar.getInstance();
        cal.set(a, 2, 1);
        cal.add(Calendar.DATE, -1);
        int i = cal.get(Calendar.DATE);
        //System.out.println(i);
        if (i == 28) {
            System.out.println(a + "��Ķ�����" + i + "�죬��ƽ��");
        } else {
            System.out.println(a + "��Ķ�����" + i + "�죬������");
        }*/


        //�ڶ��ַ���
        Calendar cal = Calendar.getInstance();
        cal.set(a, 11, 31);
        int i = cal.get(Calendar.DAY_OF_YEAR);
        //System.out.println(i);
        if (i == 366) {
            System.out.println(a + "��������");
        } else {
            System.out.println(a + "��ƽ��");
        }


    }
}
