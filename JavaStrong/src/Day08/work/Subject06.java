package Day08.work;

import java.io.*;

/*
2、使用文件过滤器筛选将指定文件夹下的大于200K的小文件，并打印
200K=200*1024个字符
 */
public class Subject06 {
    public static void main(String[] args) throws IOException {
        File f = new File("E:\\ideaspacework\\JavaStrong\\src\\Day08\\output");
        File[] files = f.listFiles();
        for(File file :files){
            if (filterFile(file, (ff) ->ff.length() > 1024 * 200)) {
                System.out.println(file.getName());
            }
        }




       /* System.out.println(f);
        File[] ff = f.listFiles();
        int length = 0;
        for (File f1 : ff) {
            if (!f1.isDirectory()) {
                String str = f1.getAbsolutePath();
                // System.out.println(str);
                FileInputStream fis = new FileInputStream(str);
                byte[] b = new byte[1024];
                int len;
                while ((len = fis.read(b)) != -1) {
                    length += (new String(b, 0, len)).length();
                }
                if (length >= 1024 * 200) {
                    System.out.println(f1.getName());
                }
                length = 0;
            }
        }*/
    }
    public static boolean filterFile(File f,FileFilter ff){
       return  ff.accept(f);
    }

}
