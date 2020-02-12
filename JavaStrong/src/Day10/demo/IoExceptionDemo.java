/*
package Day10.demo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IoExceptionDemo {
    public static void main(String[] args) {

    }

    //jdk1.9
    public static void method4() throws IOException {
        FileReader fr = new FileReader(new File("dad"));
        FileWriter fw = new FileWriter(new File("sdada"));
        try(fr;fw) {
            int a;
            while ((a = fr.read()) != -1) {
                fw.write(a);
            }
        }
    }
    //jdk 1.7
    public static void method3() {
        try (FileReader fr = new FileReader(new File("dad"));
             FileWriter fw = new FileWriter(new File("sdada"));) {
            int a;
            while ((a = fr.read()) != -1) {
                fw.write(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //标准的try...catch...finally
    public static void method2() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader(new File("dad"));
            fw = new FileWriter(new File("sdada"));
            int a;
            while ((a = fr.read()) != -1) {
                fw.write(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        {
        }
    }


    //直接抛出IOE异常
    public static void method1() throws IOException {
        FileReader fr = new FileReader(new File("dad"));
        FileWriter fw = new FileWriter(new File("sdada"));
        int a;
        while ((a = fr.read()) != -1) {
            fw.write(a);
        }
        fr.close();
        fw.close();
    }
}
*/
