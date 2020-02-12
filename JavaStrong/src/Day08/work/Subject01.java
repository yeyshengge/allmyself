package Day08.work;

import java.io.File;
import java.util.Scanner;
/*
查看任何文件的方法
 */
/*
题目一:键盘录入一个文件夹路径
		对键盘录入的文件夹路径进行判断
			如果不存在,提示重新录入
			如果是文件路径,提示再次录入文件夹录入
			如果是文件夹路径,搜索该文件下所有 以.txt结尾的文件（包含子目录中的文件）
 */

public class Subject01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入路径：");
        int index = 0;
        do {
            String str = sc.nextLine();
            File f1 = new File(str);
            if (f1.isDirectory()) {
                System.out.println("请再次输入路径：");
                String str2 = sc.nextLine();
                if (str.equals(str2)) {
                    gettxt(f1);
                    break;
                } else {
                    System.out.println("两次路径不相同");
                    break;
                }
            } else {
                System.out.println("重新录入:");
            }
        } while (index == 0);
    }

    public static void gettxt(File f) {
        File[] ff = f.listFiles();
        for (File fff : ff) {
            if (fff.isDirectory()) {
                gettxt(fff);
            } else {
                // System.out.println(fff.getName());
                try {
                    StringBuilder sb = new StringBuilder();
                    for (int i = fff.getName().length() - 3; i < fff.getName().length(); i++) {
                        sb.append(fff.getName().charAt(i));
                        if (sb.toString().equalsIgnoreCase("exe")) {
                            System.out.println(fff.getName());
                        }
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
