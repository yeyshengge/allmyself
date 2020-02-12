/*
package Day10.demo;

import java.awt.image.BufferedImageFilter;
import java.io.*;


*/
/*
复制一个文件夹中的文件，可能包含文件夹（递归）
E:\test\测试  复制这个文件夹
到  E:\test\新建文件夹
*//*




public class CopyDouJiFile {
    public static void main(String[] args) throws IOException {
        File f1 = new File("E:\\test\\测试");
        File f2 = new File("E:\\test\\新建文件夹\\");
        isDirect(f1, f2);

    }

    //如果是路径
    public static void isDirect(File f1, File f2) throws IOException {
        //如果是路径
        if (f1.isDirectory()) {
            String srcFileName = f1.getName();
            File newFolder = new File(f2, srcFileName);
            if (!newFolder.exists()) {
                newFolder.mkdir();
            }
            File[] filearray = f1.listFiles();
            for (File f : filearray) {
                isDirect(f, newFolder);
            }
        } else {
            File newFile = new File(f2, f1.getName());
            copy(f1, newFile);
        }
    }

    //如果是文件
    public static void copy(File f1, File f2) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f2));
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f1));
        byte[] bus = new byte[1024];
        int len;
        while ((len = bis.read(bus)) != -1) {
            bos.write(bus, 0, len);
        }
        bos.close();
        bis.close();
    }
}

*/
