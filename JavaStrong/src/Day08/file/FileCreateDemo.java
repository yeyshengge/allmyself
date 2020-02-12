package Day08.file;

import java.io.File;
import java.io.IOException;
/*
createNewFile()创建一个文件。
mkdir()创建一个文件夹(在已有的目录下)。
mkdirs()创建一个多级文件夹()。
 */
public class FileCreateDemo {
    public static void main(String[] args) throws IOException {


        //createNewFile()用来创建文件
        File f1 = new File("E:\\test\\helloworld.txt");
        System.out.println(f1.createNewFile());
        File f2 = new File("E:\\test\\helloworld.java");
        System.out.println(f2.createNewFile());

        //mkdir是在已经存在的目录下创建一个文件夹
        File f3 = new File("E:\\test\\javase");
        System.out.println(f3.mkdir());

        //mkdirs是在已经存在的目录下创建一个多级文件夹
        File f4 = new File("E:\\test\\javaWeb\\img");
        System.out.println(f4.mkdirs());

    }
}
