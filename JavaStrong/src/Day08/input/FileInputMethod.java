package Day08.input;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
一次读一个字节数组的数据
 */
public class FileInputMethod {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("E:\\test\\java.txt");

        byte[] bys  = new  byte[1024];
        int a;
        while ((a=fis.read(bys))!=-1){
            System.out.println(new String(bys,0,a));
        }

        fis.close();
    }



}
