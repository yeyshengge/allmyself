package com.zps.demo;

import java.util.Scanner;

public class login {
    public static void main(String[] args) {
        String uname="zps";
        int upwd = 16436130;
input(uname,upwd);

    }
public static void input(String name,int upwd){

            for(int i=0;i<3;i++){
                Scanner in= new Scanner(System.in);
                System.out.println("请输入用户名：");
                String s1 =in.nextLine();
                System.out.println("请输入密码：");
                int s2 =in.nextInt();
                if(name.equals(s1)==true&&upwd==s2){
                    System.out.println("登陆成功");
                    break;
                }else{
                    System.out.println("登陆失败,你还有"+(2-i)+"次机会");
                    if (i==2){
                        System.out.println("哦哦，请下次再试");
                    }
                }
            }

}

}
