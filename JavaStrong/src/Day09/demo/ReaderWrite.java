package Day09.demo;

import java.io.*;

/*
InputStreamReader是从字节流到字符流的桥梁：它读取字节，并使用指定的charset将其解码为字符。
       InputStreamReader​(InputStream in) 创建一个使用默认字符集的InputStreamReader。
       InputStreamReader​(InputStream in, String charsetName) 创建一个使用命名字符集的InputStreamReader。
OutputStreamWriter是从字符流到字节流的桥梁：使用指定的charset将写入的字符编码为字节。
       OutputStreamWriter​(OutputStream out) 创建一个使用默认字符编码的OutputStreamWriter。
       OutputStreamWriter​(OutputStream out, String charsetName) 创建一个使用命名字符集的OutputStreamWriter。

 */
public class ReaderWrite {
    public static void main(String[] args) throws IOException {
//        FileInputStream fis = new FileInputStream("E:\\test\\java.txt");
//        InputStreamReader fsr = new InputStreamReader(fis);
        // InputStreamReader fsr = new InputStreamReader(new FileInputStream("E:\\ideaspacework\\JavaStrong\\src\\Day09\\java.txt"));//默认平台语言
        InputStreamReader fsr = new InputStreamReader(new FileInputStream("E:\\ideaspacework\\JavaStrong\\src\\Day09\\java.txt"), "GBK");
        //OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:\ideaspacework\JavaStrong\src\Day09\java.txt"));//默认平台语言
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:\\ideaspacework\\JavaStrong\\src\\Day09\\java.txt"), "GBK");
        osw.write("我爱你");//�Ұ���会乱码
        osw.close();

        int a;
        while ((a = fsr.read()) != -1) {
            System.out.print((char) a);
        }
        fsr.close();

    }
}
