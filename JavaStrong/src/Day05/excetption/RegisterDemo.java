package Day05.excetption;

import java.util.Scanner;

public class RegisterDemo {
    static String[] usernames = {"张三", "李四"};

    public static void main(String[] args) throws RegisterExcept {
        Scanner input = new Scanner(System.in);
        String sc = input.nextLine();
        checkUsername(sc);
    }

    public static void checkUsername(String username) throws RegisterExcept {
        for (String name : usernames) {
               if (name.equals(username)){
                   throw new RegisterExcept("该用户名已经");
               }
        }System.out.println("注册成功");

    }
}
