package Day03;

import java.util.Scanner;

public class SystemDemo {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis()*1.0/1000/60/60/24/365);
        int sum=0;
        for (int i = 0; i < 10; i++) {
            sum+=i;
        }
        System.out.println(sum);

    }
    }

