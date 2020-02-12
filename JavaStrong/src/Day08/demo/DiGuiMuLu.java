package Day08.demo;

import java.io.File;

/*
递归遍历输入文件下的所有文件的绝对路径，如果是文件夹就继续递归目录
 */
public class DiGuiMuLu {
    public static void main(String[] args) {

        File f = new File("D:\\");

        getAbsMuLu(f);
    }

    public static void getAbsMuLu(File file) {
        File[] fl = file.listFiles();
        for (File f : fl) {
            if (f.isDirectory()) {
                getAbsMuLu(f);
            } else {
                System.out.println(f.getAbsolutePath());
            }
        }
    }
}
