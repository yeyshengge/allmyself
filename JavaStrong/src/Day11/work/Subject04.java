package Day11.work;

import java.util.Arrays;
import java.util.Collections;

//4,题目：输入数组，最大的与第一个元素交换，最小的与最后一个元素交换，输出数组。 （数组内容自定义）
public class Subject04 {
    public static void main(String[] args) {
        int[] arr = {10, 15, 15, 4, 5, 6, 7, 21, 19};

        int[] arr1 = Arrays.copyOf(arr, arr.length);
        System.out.println("原数组"+Arrays.toString(arr1));
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
       // System.out.println("排序后"+Arrays.toString(arr));
        //最大的与第一个元素交换
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i]==arr[arr.length-1]){
                temp = arr1[0];
                arr1[0]=arr[arr.length-1];
                arr1[i]=temp;
                break;
            }
        }
        //System.out.println("排序后"+Arrays.toString(arr1));
        //最小的与最后一个元素交换
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i]==arr[0]){
                temp = arr1[i];
                arr1[i]=arr1[arr1.length-1];
                arr1[arr1.length-1]=temp;
                break;
            }
        }
        System.out.println("排序后"+Arrays.toString(arr1));
    }
}
