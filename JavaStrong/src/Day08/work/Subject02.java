package Day08.work;

/*
题目二:删除指定的目录（包含子目录）注意:切记别删除有用的数据,"概不负责哟"
(删除目录要多删几次)
 */

import java.io.File;
import java.util.ArrayList;

public class Subject02 {
    public static void main(String[] args) {
        File f1 = new File("E:\\wangye");
        ArrayList<String> list = new ArrayList<>();
        removes(f1, list);//用来删除该目录下的所有文件，剩下路径。
        // demulu(f1);
        System.out.println(list);
        for (int i = list.size() - 1; i >= 0; i--) {
            File f2 = new File(list.get(i));
            f2.delete();
        }

    }

    public static void removes(File file, ArrayList<String> list) {
        File[] f = file.listFiles();
        for (File ff : f) {
            if (ff.isDirectory()) {
                list.add(ff.getAbsolutePath());
                removes(ff, list);
                // System.out.println(ff.getAbsolutePath());
            } else {
                ff.delete();
            }
        }
    }
}
