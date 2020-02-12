package Day10.AnLi;

import java.io.*;

/*
E:\test
 */
public class CopyAll {
    public static void main(String[] args) throws IOException {
        File src = new File("E:\\test");
        File dec = new File("E:\\aaa");
        show(src, dec);
    }

    private static void show(File src, File dec) throws IOException {
        String name = src.getName();
        if (src.isDirectory()) {
            File newDec = new File(dec, name);
            newDec.mkdir();
            File[] files = src.listFiles();
            for (File f :files){
                show(f,newDec);
            }
        } else {
            File f = new File(dec, name);
            copy(src, f);
        }
    }

    private static void copy(File src, File dec) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dec));
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        byte[] bys = new byte[1024];
        int len;
        while ((len = bis.read(bys)) != -1) {
            bos.write(bys, 0, bys.length);
        }

        bos.close();
        bis.close();
    }
}
