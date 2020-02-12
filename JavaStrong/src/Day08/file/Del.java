package Day08.file;

import java.io.File;

public class Del {
    public static void main(String[] args) {
        File f  =new File("E:\\test\\javaWeb");
        System.out.println(f.getName());
        File[] files = f.listFiles();
        for(File f1 :files){

        }
    }
}
