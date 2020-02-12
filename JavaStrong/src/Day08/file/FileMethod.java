package Day08.file;

import java.io.File;

public class FileMethod {
    public static void main(String[] args) {

        File f1 = new File("E:\\test");
        //判断该File实例是不是路径
        System.out.println(f1.isDirectory());
        //判断该File实例是不是文件
        System.out.println(f1.isFile());
        File f2 = new File("E:\\test\\helloworld.txt");
        System.out.println(f2.isFile());
        //判断该File实例存不存在
        System.out.println(f2.exists());
        File f3 = new File("E:\\test\\hello.txt");
        System.out.println(f3.exists());

        System.out.println("----------");
        File f4 = new File("E:\\test\\hello.txt");
        //返回此抽象路径名的绝对形式。
        System.out.println(f2.getAbsolutePath());
        System.out.println(f4.getAbsolutePath());
        System.out.println(f4.getPath());
        //返回由此抽象路径名表示的文件或目录的名称。
        System.out.println(f4.getName());
        System.out.println("----------");
        File f5 = new File("E:\\test");
        //返回该目录下的所有文件(文件加文件夹)
        String[] str = f5.list();
        for (String s : str) {
            System.out.println(s);
        }
        System.out.println("---------");
        //返回此File实例下的所有File对象
        File[] fl = f5.listFiles();
        for (File f : fl) {
            System.out.println(f.getName());
        }

    }
}
