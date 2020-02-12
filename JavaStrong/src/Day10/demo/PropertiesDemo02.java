package Day10.demo;

import java.io.*;
import java.util.Properties;

/*
void store​(OutputStream out, String comments) 将此属性列表（键和元素对）写入此 Properties表中， 字节流
void store​(Writer writer, String comments) 将此属性列表（键和元素对）写入此 Properties表中，    字符流
void load​(InputStream inStream) 字节流读取属性列表（键和元素对）。    字节流
void load​(Reader reader) 字符流读取属性列表（关键字和元素对）。       字符流

 */
public class PropertiesDemo02 {
    public static void main(String[] args) throws IOException {

        //store();//字符流写
        //load();//字符流读

        //bytestore();
        byteload();
    }

    private static void byteload() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(new File("E:\\ideaspacework\\JavaStrong\\src\\Day10\\java.txt"));
        prop.load(fis);
        fis.close();
        System.out.println(prop);
    }

    private static void bytestore() throws IOException {
        Properties prop = new Properties();
        prop.setProperty("001", "张曼玉");
        prop.setProperty("002", "张学友");
        prop.setProperty("003", "张小姐");
        prop.setProperty("004", "张大姐");
        //void store​(OutputStream out, String comments) 将此属性列表（键和元素对）写入此 Properties表中， 字节流
        FileOutputStream fos = new FileOutputStream(new File("E:\\ideaspacework\\JavaStrong\\src\\Day10\\java.txt"));
        prop.store(fos,null);
        fos.close();

    }

    private static void load() throws IOException {
        Properties prop = new Properties();
        FileReader fr = new FileReader("E:\\ideaspacework\\JavaStrong\\src\\Day10\\java.txt");
        //void load​(Reader reader) 字符流读取属性列表（关键字和元素对）。       字符流
        prop.load(fr);
        fr.close();

        System.out.println(prop);
    }

    private static void store() throws IOException {
        Properties prop = new Properties();
        prop.setProperty("001", "张曼玉");
        prop.setProperty("002", "张学友");
        prop.setProperty("003", "张小姐");
        //void store​(Writer writer, String comments) 将此属性列表（键和元素对）写入此 Properties表中，    字符流
        FileWriter fw = new FileWriter("E:\\ideaspacework\\JavaStrong\\src\\Day10\\java.txt");

        prop.store(fw, null);

        fw.close();
    }
}
