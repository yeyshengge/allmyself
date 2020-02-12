package Day09.demo;

import java.io.*;

/*
D:\java学习视频\java基础加强\day08\视频\138_字节流复制图片.avi
复制到----->  E:\test\mm.avi
1,用单个字节复制视频             共耗时:136146
2,用字节数组复制视频             共耗时:157
3,用单个字节缓存复制视频          共耗时:734
4,用数组字节缓存复制视频          共耗时:47
 */
public class Copyvideo {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        //method01();//共耗时:136146
        //method02();//共耗时:157
        //method03();//共耗时:734
        method04();//共耗时:47
        long end = System.currentTimeMillis();
        System.out.println("共耗时:" + (end - start));
    }

    public static void method04() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\java学习视频\\java基础加强\\day08\\视频\\138_字节流复制图片.avi"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\test\\mm.avi"));
        byte[] bys = new byte[1024];
            int a;
            while ((a = bis.read(bys)) != -1) {
                bos.write(bys, 0, a);
        }
        bis.close();
        bos.close();
    }


    public static void method03() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\java学习视频\\java基础加强\\day08\\视频\\138_字节流复制图片.avi"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\test\\mm.avi"));
        int a;
        while ((a = bis.read()) != -1) {
            bos.write(a);
        }
        bis.close();
        bos.close();
    }

    public static void method02() throws IOException {
        FileInputStream fis = new FileInputStream("D:\\java学习视频\\java基础加强\\day08\\视频\\138_字节流复制图片.avi");
        FileOutputStream fos = new FileOutputStream("E:\\test\\mm.avi");
        byte[] bys = new byte[1024];
        int a;
        while ((a = fis.read(bys)) != -1) {
            fos.write(bys, 0, a);
        }
        fis.close();
        fos.close();
    }

    public static void method01() throws IOException {
        FileInputStream fis = new FileInputStream("D:\\java学习视频\\java基础加强\\day08\\视频\\138_字节流复制图片.avi");
        FileOutputStream fos = new FileOutputStream("E:\\test\\mm.avi");
        int a;
        while ((a = fis.read()) != -1) {
            fos.write(a);
        }
        fis.close();
        fos.close();
    }
}
