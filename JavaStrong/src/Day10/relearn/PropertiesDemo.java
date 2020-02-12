package Day10.relearn;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/*
使用Properties集合来往文件里读写键值对
E:\ideaspacework\JavaStrong\src\Day10\relearn
 */
public class PropertiesDemo {
    public static void main(String[] args) throws IOException {

        mystore();
        myload();
    }

    private static void mystore() throws IOException {
        FileWriter fw = new FileWriter("E:\\ideaspacework\\JavaStrong\\src\\Day10\\relearn\\java.properties");

        Properties prop = new Properties();

        prop.setProperty("id001", "迪丽热巴");
        prop.setProperty("id002", "古力娜扎");
        prop.setProperty("id003", "马尔扎哈");

        prop.store(fw, null);
        fw.flush();
        fw.close();

    }

    private static void myload() throws IOException {
        FileReader fr = new FileReader("E:\\ideaspacework\\JavaStrong\\src\\Day10\\relearn\\java.properties");
        Properties prop = new Properties();

        prop.load(fr);
        fr.close();

        System.out.println(prop);

    }
}
