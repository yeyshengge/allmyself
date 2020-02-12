/*
package Day10.demo;

import java.io.*;

*/
/*
复制一个没有文件夹的其他文件
E:\test\测试\文件   这里面有很多文件
E:\test\新建文件夹  这是复制到这个文件
 *//*

public class CopyDanJiFile {
    public static void main(String[] args) throws IOException {
        File f1 = new File("E:\\test\\测试\\文件");
        if (f1.isDirectory()) {
            File[] files = f1.listFiles();
            String[] arr = new String[files.length];
            for (int i = 0; i < files.length; i++) {
                String name = files[i].getName();
                System.out.println(name);
                arr[i] = files[i].toString();
            }
            for (int i = 0; i < arr.length; i++) {
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\test\\新建文件夹\\" + files[i].getName()));//指定文件夹时要给具体的文件名。
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(arr[i]));
                byte[] by = new byte[1024];
                int a;
                while ((a = bis.read(by)) != -1) {
                    bos.write(by, 0, a);
                }
                bis.close();
                bos.close();
            }
        }
    }
}
*/
