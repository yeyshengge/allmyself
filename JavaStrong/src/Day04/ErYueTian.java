package Day04;

//���ָ���·ݵĶ����ж�����

import java.util.Calendar;
import java.util.Scanner;

public class ErYueTian {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();

        Calendar cal = Calendar.getInstance();//����һ��Calender�Ķ���

        cal.set(a, 2, 1);//����Ϊ���£��·ݴ��㿪ʼ��3��1��ǰ��һ�죬���Ƕ��µ����һ�죬Ȼ����������

        cal.add(Calendar.DATE, -1);

        System.out.println(cal.get(Calendar.DATE));

    }

}
