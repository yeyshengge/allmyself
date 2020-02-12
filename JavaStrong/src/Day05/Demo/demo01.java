package Day05.Demo;

import Day01.Work.A;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
	1.键盘录入10个整数存入数组中
	2.定义一个方法将奇数放在数组的左侧,偶数放在数组的右侧
	3.定义一个方法打印原数组和处理后的数组
	4.定义一个方法传入一个int类型数组，输出这个数组中只出现一次的数字及个数
 */
public class demo01 {
    public static void main(String[] args) {
        //int[] arr = new int[10];
        //input(arr);
        int arr1[] = {1,2,3,4,4,8};
        //replace(arr1);
        check(arr1);
        //aaa(arr1, arr);
        /*for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }*/

    }


   /* public static void aaa(int[] arr1, int[] arr2) {
        int a = 0;
        int b = 1;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] % 2 != 0) {
                arr2[a] = arr1[i];
                a++;
            } else {
                arr2[arr1.length - b] = arr1[i];
                b++;
            }
        }
    }*/


    public static void input(int[] arr) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个数：");
            arr[i] = input.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {

            System.out.println(arr[i]);
        }
    }

    //2.定义一个方法将奇数放在数组的左侧,偶数放在数组的右侧
    public static void replace(int[] arr) {
        //方法一：
        /*  ArrayList<Integer> qi = new ArrayList<>();
        ArrayList<Integer> ou = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                ou.add(arr[i]);
            } else {
                qi.add(arr[i]);
            }
        }
        for (int i = 0; i < ou.size(); i++) {
            qi.add(ou.get(i));
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = qi.get(i);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }*/
        //方法二：int arr1[] = {1, 2, 3, 4, 8, 8, 9, 5, 5, 5, 6, 6, 3};
        int arr3[] = new int[arr.length];
        int a = 0;
        int b = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                arr3[arr.length - 1 - b] = arr[i];
                b++;
            } else {
                arr3[a] = arr[i];
                a++;
            }
        }


        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
    }

    //4.定义一个方法传入一个int类型数组，输出这个数组中只出现一次的数字及个数
    public static void check(int[] arr) {
        //方法一：
        /* HashMap<Integer, Integer> map = new HashMap<>();//定义数组，用来存储
        for (int a : arr) {
            if (map.containsKey(a)) {
                Integer i = map.get(a);
                i++;
                map.put(a, i);
            } else {
                map.put(a, 1);
            }
        }
        for (Integer a : map.keySet()) {//遍历出来
            Integer i = map.get(a);
            if (i == 1) {
                System.out.println(a + "出现了" + i + "次");
            }
        }*/


        //方法二:定义一个方法传入一个int类型数组，输出这个数组中只出现一次的数字及个数
        //int arr1[] = {1,2,3,4,4,8};
        // int arr2[] = new arr2[];
        int a = 0;
        for (int i = 0; i < arr.length; i++) {
            int index = -1;
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    continue;
                }
                if (arr[i] == arr[j]) {
                    index++;
                }
            }
            if (index == -1) {
                a++;
                System.out.println(arr[i]);
            }

        }
        System.out.println("共" + a + "个");
    }
}

