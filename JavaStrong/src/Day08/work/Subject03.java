package Day08.work;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/*
题目三:
	(1)键盘录入一个文件夹路径
	(2)定义一个方法统计该文件夹 中一共有多个文件（包括子目录中的文件）
 */
public class Subject03 {
    public static void main(String[] args) {
        ArrayList<String>  list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("输入路径：");
        String url = sc.nextLine();
        File f1 = new File(url);
        check(f1,list);
        System.out.println("一个有"+list.size()+"个文件");
    }

    public static void check(File f,ArrayList<String>  list) {
        File[] f2 = f.listFiles();
        for (File f3 : f2) {
            if (f3.isDirectory()) {
                check(f3,list);
            } else {
              list.add(f3.getName());
            }
        }
    }
}
