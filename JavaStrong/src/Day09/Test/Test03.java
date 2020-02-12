package Day09.Test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("number：");
            try {
                int c = sc.nextInt();

                System.out.println("aaaa");

            } catch (InputMismatchException e) {
                System.out.print("1");
            }
        }
    }
}
