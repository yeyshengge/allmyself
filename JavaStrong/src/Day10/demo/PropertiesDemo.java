/*
package Day10.demo;

import java.util.Properties;
import java.util.Set;

*/
/*
Properties类表示一组持久的属性。 Properties可以保存到流中或从流中加载。 属性列表中的每个键及其对应的值都是一个字符串。
是一个HashMap方法
 *//*

public class PropertiesDemo {
    public static void main(String[] args) {
        Properties prop = new Properties();

        prop.put("古天乐", 18);
        prop.put("刘德华", 28);
        prop.put("张学友", 38);

        Set<Object> o = prop.keySet();
        for (Object ss : o) {
            Object o1 = prop.get(ss);
            System.out.println(ss + "," + o1);
        }
    }
}
*/
