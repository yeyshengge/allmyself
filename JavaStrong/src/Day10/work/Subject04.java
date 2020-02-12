package Day10.work;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

/*
第四题:
	当前模块下有一个文本文件test.txt(里面的内容由数字和字母组成)
	定义一个方法统计test.txt文件中所有字符出现的次数。
	输出结果如下:
	a出现10次
	......
	E:\ideaspacework\JavaStrong\src\Day10\work\prop.properties\subject04.txt
 */
public class Subject04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("E:\\ideaspacework\\JavaStrong\\src\\Day10\\work\\subject04.txt"));
        StringBuilder sb = new StringBuilder();
        int a;
        while ((a = br.read()) != -1) {
            sb.append((char) a);
        }
        System.out.println(sb.toString());
        check(sb.toString());
    }

    public static void check(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                Integer num = map.get(s.charAt(i));
                num++;
                map.put(s.charAt(i), num);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        Set<Character> c = map.keySet();
        for (Character c1 : c) {
            System.out.println(c1 + "出现了" + map.get(c1) + "次");
        }
    }
}
