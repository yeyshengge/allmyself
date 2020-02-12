package com.zps.test;
import java.util.Scanner;
public class Pingfeng {
    public static void main(String[] args) {
        int[] arr=new int[5];
        Scanner input = new Scanner(System.in);
        for(int i=0;i<arr.length;i++) {
            System.out.println("请输入第" + (i + 1) + "个评委的打分：");
            arr[i] = input.nextInt();
        }
bianli(arr);
int a=Getmax(arr);
int b=Getmin(arr);
int c=Getsum(arr);
        //System.out.println(a);
        //System.out.println(b);
        //System.out.println(c);
int number=(c-a-b)/(arr.length-2);
        System.out.println("平均分为："+number);
    }

    public static int Getsum(int[] arr){
        int sum=0;
        for (int i=0;i<arr.length;i++){
            sum+=arr[i];
        }return sum;
    }

    public static int Getmax(int[] arr) {
        int max=arr[0];
        for (int i=1;i<arr.length;i++){
            if (arr[i]>max){
                max=arr[i];
            }
        }
        return max;


    }

    public static int Getmin(int[] arr) {
        int min =arr[0];
        for (int i=1;i<arr.length;i++){
            if (arr[i]<min){
                min=arr[i];
            }
        }
        return  min;
    }
    public static void bianli(int[] arr){
        System.out.print("[");
        for (int i=0;i<arr.length;i++){
            if(i<arr.length-1){
                System.out.print(arr[i]+",");
            }else{
                System.out.print(arr[i]);
            }
        } System.out.println("]");

}


}
