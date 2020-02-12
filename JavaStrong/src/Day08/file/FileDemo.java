package Day08.file;

import java.io.File;
/*
File​(File parent, String child) 从父抽象路径名和子路径名字符串创建新的 File实例。
File​(String pathname) 通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例。
File​(String parent, String child) 从父路径名字符串和子路径名字符串创建新的 File实例。

 */

public class FileDemo {
    public static void main(String[] args) {
        File f1 =new File("E:\\作业\\h.txt");
        System.out.println(f1);

        File f2 = new File("E:\\作业","h.txt");
        System.out.println(f2);

        File f3 = new File("E:\\作业");
        File f4 = new File(f3,"\\h.txt");
        System.out.println(f4);

       /* Scanner sc = new Scanner(System.in);
        System.out.println("请输入整数");
        int a = sc.nextInt();
        System.out.println(a);
        System.out.println("请输入字符串");
        String str= sc.next();
        System.out.println(str);

        //如果nextInt后面跟了一个nextLine()(nextLine是以回车键来判断的，当你前面输入整数后回车，nextLine也一并提交)
        //如果就是next()，则next()是以空格为提交，当你输入“ab ab”时，就只录入了ab.

        */
    }
}
