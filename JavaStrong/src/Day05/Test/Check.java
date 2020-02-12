package Day05.Test;

import java.util.ArrayList;
import java.util.Scanner;

/*
5.定义一个方法
		public static ? equals(int[] arr,int value)
		功能:找value里的值在数组中的索引,如果没有找到请返回 -1
 */
public class Check {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("输入你要查找的值：");
        int a = input.nextInt();
        int[] arr = {11, 55, 8, 9, 7778, 45, 45, 45, 4};
        equals(arr, a);
        //System.out.println(b);

    }

    public static void equals(int[] arr, int value) {
        int index = -123;
        ArrayList<Integer> list = new ArrayList<>();
      /*  for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                index = i;
                break;
            }
        }
        return index;
    }*/
       /* for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                //index=i;
               list.add(i);
            }
        }
       if(list.size()==0){
           System.out.println(index);
       }else{
           //System.out.println(list);
           for (int i = 0; i < list.size(); i++) {
               System.out.println(list.get(i));
           }
       }
*/
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                index = i;
                System.out.println(index);

            }
        }
        if (index == -123) {
            System.out.println(-1);
        }
    }

}

