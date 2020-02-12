package Day10.demo;

import java.util.Properties;
import java.util.Set;

/*
          Enumeration<?> propertyNames​() 返回此属性列表中所有键的枚举，包括默认属性列表中的不同键，
          如果尚未从主属性列表中找到相同名称的键。
          Object setProperty​(String key, String value) 调用 Hashtable方法 put 。
          String getProperty​(String key, String defaultValue) 使用此属性列表中指定的键搜索属性。
 */
public class PropertiesDemo01 {
    public static void main(String[] args) {
        Properties prop = new Properties();
        //Object setProperty​(String key, String value) 调用 Hashtable方法 put 。
        prop.setProperty("张曼玉", "19");
        prop.setProperty("林青霞", "29");
        prop.setProperty("张敏", "18");
        System.out.println(prop);

        // Enumeration<?> propertyNames​() 返回此属性列表中所有键的枚举，包括默认属性列表中的不同键，
        Set<String> str = prop.stringPropertyNames();
        for (String s : str) {
            //    String getProperty​(String key, String defaultValue) 使用此属性列表中指定的键搜索属性。
            System.out.println(s + "," + prop.getProperty(s));//即根据key求值
        }
    }
}
