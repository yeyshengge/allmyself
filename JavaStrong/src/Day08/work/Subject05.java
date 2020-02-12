package Day08.work;

import Day01.Work.A;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
第五题:(附加题)
键盘录入一个文件夹路径,统计该文件夹(不包含子文件夹)中,每种类型的文件及个数,
	注意:用文件类型("java","txt"...)作为key,用个数作为value,
	放入到map集合中,并按照如下格式打印map集合中的内容
		docx类型的文件有  1 个
		java类型的文件有  24 个
		txt类型的文件有  10 个
 */
public class Subject05 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        File f1 = new File("E:\\test");
        File[] f2 = f1.listFiles();
        for (File f3 : f2) {
            if (f3.isFile()) {
                String[] sp = f3.getName().split("\\.");
                if (map.containsKey(sp[sp.length - 1])) {
                    Integer a = map.get(sp[sp.length - 1]);
                    a++;
                    map.put(sp[sp.length - 1], a);
                } else {
                    map.put(sp[sp.length - 1], 1);
                }
            }
        }
        Set<String> st = map.keySet();
        for (String s : st) {
            System.out.println(s + "类型的文件有 ：" + map.get(s) +" 个");
        }
    }
}