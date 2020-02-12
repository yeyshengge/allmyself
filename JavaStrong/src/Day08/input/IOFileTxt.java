package Day08.input;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOFileTxt {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("E:\\test\\java.txt");
            fos = new FileOutputStream("E:\\test\\java0.txt");
           int a;
            while ((a=fis.read())!=-1){
               fos.write(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
