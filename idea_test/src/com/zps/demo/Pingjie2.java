package com.zps.demo;

public class Pingjie2 {

    public static void main(String[] args) {
        int[] arr={1,2,3};
        StringBuilder s = new StringBuilder();
       s.append("[");
        for (int i= 0;i<arr.length;i++){
           // System.out.println(arr[i]);
            if (i<arr.length-1) {
                s.append(arr[i]).append(",");
            }else{
                 s.append(arr[i]);
             }
        }
        s.append("]");
        System.out.print(s);


    }


}
