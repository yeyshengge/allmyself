package Day10.work;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
/*
第六题: 我有一个文本文件score.txt，我知道数据是键值对形式的，但是不知道内容是什么。
请写一个程序判断是否有"lisi"这样的键存在，如果有就改变其实为"100"
score.txt文件内容如下：
zhangsan=90
lisi=80
wangwu=85
 */
public class Subject06 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("E:\\ideaspacework\\JavaStrong\\src\\Day10\\work\\score.txt");
        Properties prop = new Properties();
        prop.load(fr);
        System.out.println(prop);

        Set<String> set = prop.stringPropertyNames();
        for(String str :set){
            if("lisi".equals(str)){
                prop.setProperty(str,"100");
            }
        }
        System.out.println(prop);
        fr.close();
        FileWriter fw = new FileWriter("E:\\ideaspacework\\JavaStrong\\src\\Day10\\work\\score.txt");
        prop.store(fw,null);
        fw.close();
    }
}
