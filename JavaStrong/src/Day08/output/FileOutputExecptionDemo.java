package Day08.output;

import java.io.FileOutputStream;
import java.io.IOException;

/*
标准的就要try...catch，平时随意抛出异常。且close放进finally块中。
 */
public class FileOutputExecptionDemo {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("E:\\test\\java.txt");
            fos.write(55);
            fos.write("iloveyou".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
