package Day04;

import java.util.Random;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
       /* 1.����¼��༶����
        2.����¼��İ༶������������
        3.�������������0-100�ĳɼ�(����100������0),�ҽ��ɼ���ֵ������
        4.Ҫ��:
        (1)��ӡ�ð༶�Ĳ���������
                (2)��ӡ�ð༶��ƽ����
                (3)��ӡ�ð༶���ܷ�
                (3)��ʾ��ʽ����:
        ������༶����:
        ����¼��:100
        ����̨���:
        ����������:19
        �༶ƽ����:87
        �༶�ܷ�:xxx*/

        Scanner input = new Scanner(System.in);
        System.out.println("please int number:");
        int a = input.nextInt();
        int arr[] = new int[a];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            int b = r.nextInt(100) + 1;
            arr[i] = b;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        //ƽ����
        int avg = 0;
        for (int i = 0; i < arr.length; i++) {
            avg += arr[i];
        }
        System.out.println("�ܷ�Ϊ" + avg);
        System.out.println("ƽ����Ϊ��" + (avg / a));
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<60){
                temp++;
            }

        }
        System.out.println("������������"+temp);
    }
}
