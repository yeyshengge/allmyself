package Day15.relearn;

import javax.management.ObjectName;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Set;

/*
E:\ideaspacework\JavaStrong\src\Day15\relearn
 */
public class PropertiesDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        BufferedReader br = new BufferedReader(new FileReader("E:\\ideaspacework\\JavaStrong\\src\\Day15\\relearn\\class.properties"));
        Properties prop = new Properties();
        prop.load(br);
        br.close();

        Object className = prop.get("className");
        Object methodName = prop.get("methodName");

        Class<?> c = Class.forName((String) className);
        Constructor<?> cons = c.getDeclaredConstructor();
        Object o = cons.newInstance();

        Method m = c.getDeclaredMethod((String) methodName);
        m.setAccessible(true);
        m.invoke(o);


        /*Set<Object> set = prop.keySet();
        for (Object key :set){
            Object value = prop.get(key);
            System.out.println(key+"---"+value);
        }*/
    }
}
