package Day08.output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
write()
write(byte[] b)
write(byte[] int off,int len)
 */
public class OutputMethod {
    public static void main(String[] args) throws IOException {

        FileOutputStream fos = new FileOutputStream("E:\\test\\java.txt");
        //一样的
        //File f = new File("E:\\test\\java.txt");
        //FileOutputStream fos = new FileOutputStream(f);

        //相当于
        // FileOutputStream fis2 = new FileOutputStream(new File("E:\\test\\java.txt"));

        //void write(int b):将指定字节写入此文件输出流
        //fos.write(98);
        //fos.write(99);
        //fos.write(100);
        //fos.write(101);

        //void writre(byte[] c)将指定字节数组写入此文件输出流
        byte[] c = {98, 99, 100, 101, 102, 103, 104};
        //fos.write(c);

        //String 中的方法getBytes()获取字符串的字节数组
        //void write(byte[] b,int off,int len)把字节数组中的第off索引开始存储长为len的数据。
        byte[] bys = "adadadafafdadafafad".getBytes();
        fos.write(bys,6,5);
        fos.close();
    }
}
