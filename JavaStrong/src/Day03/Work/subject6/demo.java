package Day03.Work.subject6;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*      1,����¼��һ��������Ϊ����ĳ���,Ȼ��ͨ�������Ϊ�����鸳ֵ
        2,Ȼ���������� ��������
        3,��������Ԫ�� ƴ�ӳ� [1,3,4...] ������ʽ*/
public class demo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("please int num:");
        int a = input.nextInt();
        int[] arr = new int[a];
        Random r = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100);

        }
        //Arrays.sort(arr);
        array(arr);

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                sb.append(arr[i]);
            } else {
                sb.append(arr[i] + ",");
            }
        }
        sb.append("]");
        String str = sb.toString();
        System.out.println(str);
    }

    public static void array(int[] arr) {
        int temp = 0;
        for (int k = 0; k < arr.length; k++) {
            for (int i = 0; i < arr.length - k - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                }
            }
        }

    }


}
