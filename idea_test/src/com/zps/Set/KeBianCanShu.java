package com.zps.Set;

public class KeBianCanShu {
    public static void main(String[] args) {

        KeBianCanShu a = new KeBianCanShu();
        int b = a.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(b);
    }

    private int sum(int... arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }
}
