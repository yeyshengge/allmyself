package com.zps.demo;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        int a[][] = new int[5][5];
        int i,j,k = 1;
        for(i=0;i<5;i++)
           for(j=0;j<5;j++)
                if((i+j)<5){
                    a[i][j] = k;
                    //*********Found**********
                    System.out.print(a[i][j]+"￥");
                    if (k > 9) k = 1;
                }else
                    //*********Found**********
                    System.out.print("0"+"%");
        for(i=0;i<5;i++){
            for(j=0;j<5;j++)
                System.out.println(a[i][j]+ "*");
            //*********Found**********

        }
    }


}
