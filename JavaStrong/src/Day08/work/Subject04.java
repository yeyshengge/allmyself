package Day08.work;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
题目四. 在D盘下，有一c.txt 文件中内容为：HelloWorld
在c.txt文件原内容基础上，添加五句 I love java，而且要实现一句一行操作(注：原文不可覆盖)。
 */
public class Subject04 {
    public static void main(String[] args) throws IOException {
        //创建一个io流对象, 读还是写?
        FileOutputStream fos = new FileOutputStream("E:\\test\\c.txt",true);//是true就是在原来的上面修改
        for (int i = 0; i < 5; i++) {
            //把字符串转成字节数组
            byte[] bytes = "I love java".getBytes();
            fos.write("\r\n".getBytes());
            fos.write(bytes);
            //写一个换行符
        }

        //释放资源
        fos.close();
    }
}
