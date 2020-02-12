package Day09.work;

import java.io.*;
import java.util.Scanner;

/*
题目二:分析以下需求，并用代码实现
	1.从键盘接收一个小视频路径      D:\java学习视频\java基础加强\day09\视频\153_IO流小结.avi
	2.将这个视频复制到D盘下avi文件中
	3.要求使用缓冲流来实现
 */
public class Subject02 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入路径：");
        String url = sc.nextLine();
        File f = new File(url);
        if (f.isFile()) {
           BufferedInputStream br = new  BufferedInputStream(new FileInputStream(url));
            BufferedOutputStream bw = new  BufferedOutputStream(new FileOutputStream("E:\\test\\javacopy.avi"));
           /* char[] a = new char[1024];
            int b;
            while ((b = br.read(a)) != -1) {
                bw.write(a, 0, b);
            }*/
           int c;
           while ((c=br.read())!=-1){
               bw.write(c);
           }


            br.close();
            bw.close();
        } else {
            //System.out.println("你输入的路径有误");
       }
    }
}
