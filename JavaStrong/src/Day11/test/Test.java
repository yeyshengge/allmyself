package Day11.test;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
完成用户的登录和注册功能，登录成功以后需要实现商品的增加和查询操作。
实现功能：
A:用户要求包含：用户名(String类型)和密码(String类型)；商品要求包含： 商品名称(String类型)，商品价格(int类型)。请根据描述设计出用户类和商品类。
B:完成用户的注册功能。注：要求保证用户名名的唯一性
C:完成用户登录功能。注：用户信息使用集合存储
D:用户登录成功后，实现商品的新增功能 注：存储商品信息使用文件存储。存储到文件的每一个商品信息占一行。例如：”手机，1999”
E:实现商品的查询功能。为了帮助大家更好的实现此需求，我们提供主类中所有方法的声明，并提供部分界面代码。 下面是整个程序执行的截图，供大家参考主界面：
 */
public class Test {

    public static void main(String[] args) throws Exception {
        ArrayList<User> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("☆☆☆☆☆☆☆☆欢迎使用☆☆☆☆☆☆☆☆");
        while (true) {
            System.out.println("1:注册");
            System.out.println("2:登录");
            System.out.println("请输入你的选择：");
            int num = sc.nextInt();
            if (num == 1) {
                //注册方法
                register(list);
            } else if (num == 2) {
                //登录方法
                boolean flag = login(list);
                if (flag) {
                    loginpage();
                } else {
                    //登录失败
                    System.out.println("用户名或密码错误");
                }
            } else {
                System.out.println("你的输入有误");
            }
        }
    }

    private static void loginpage() throws Exception {
        Scanner sc = new Scanner(System.in);
        //登录成功
        System.out.println("☆☆☆☆☆☆☆☆欢迎你登录成功☆☆☆☆☆☆☆☆");
        while (true) {
            System.out.println("1,查看所有商品信息");
            System.out.println("2,新增商品信息");
            System.out.println("3,退出登录");
            System.out.println("请输入你的选择：");
            int i = sc.nextInt();
            if (i == 1) {
                //查看所有信息
                check();
            } else if (i == 2) {
                //新增信息
                add();
            } else if (i == 3) {
                System.out.println("欢迎下次使用");
                System.exit(1);
            } else {
                System.out.println("输入有误，请重新输入");
            }
        }
    }

    private static void check() throws Exception {
        BufferedReader  br = new BufferedReader(new FileReader("D:\\ideaspacework\\JavaStrong\\src\\Day11\\test\\shop.txt"));
        String str;
        while ((str=br.readLine())!=null){
            System.out.println("商品："+str.split(",")[0]+"            价格："+str.split(",")[1]);
        }
    }

    //存储到文件的每一个商品信息占一行。例如：”手机，1999”
    private static void add() throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\ideaspacework\\JavaStrong\\src\\Day11\\test\\shop.txt",true));
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入商品信息名：");
        String name = sc.next();
        System.out.println("请输入商品价格：");
        int price = sc.nextInt();
        bw.write(name + "," + price);
        bw.newLine();
        bw.flush();
        bw.close();
        System.out.println("存储成功");
    }

    //登录
    private static boolean login(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入登录用户名");
            String username = sc.next();
            System.out.println("请输入登录密码");
            String password = sc.next();
            int flag = 0;
            if (username != null && password != null) {
                for (User user : list) {
                    if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                        return true;
                    } else {
                        flag++;
                    }
                }
                if (flag == list.size()) {
                    return false;
                }
            }
        }
    }

    //注册
    private static void register(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入用户名：");
            String username = sc.next();
            System.out.println("请输入密码：");
            String password = sc.next();
            int index = 0;
            if (username != null && password != null) {
                for (User user : list) {
                    if (username.equals(user.getUsername())) {
                        System.out.println("用户名重复");
                        break;
                    } else {
                        index++;
                    }
                }
                if (index == list.size()) {
                    System.out.println("注册成功");
                    User u = new User(username, password);
                    list.add(u);
                    System.out.println(list);
                    return;
                }
            }
        }
    }
}
