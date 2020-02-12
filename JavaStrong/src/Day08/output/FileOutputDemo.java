package Day08.output;


import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputDemo {
    public static void main(String[] args) throws IOException {

        FileOutputStream fis = new FileOutputStream("E:\\test\\java01.txt");
        /*
        做了三件事情：
           1，调用系统功能创建文件
           2，创建字节输出流对象
           3，让字节输出流对象指向创建好的文件
         */
        fis.write(65);//A字符
        fis.write(55);//7字符
        fis.close();//释放资源
        /*
        1,关闭了输出流
        2，释放此流相关的系统资源
         */
    }
}

