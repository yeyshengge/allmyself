package Day15.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/*
E:\ideaspacework\JavaStrong\src\Day15\class.txt
 */
public class demo08 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Properties prop = new Properties();

        FileReader fr = new FileReader("E:\\ideaspacework\\JavaStrong\\src\\Day15\\class.txt");

        prop.load(fr);

        fr.close();
        String className = prop.getProperty("className");
        String methodName = prop.getProperty("methodName");

        Class<?> c = Class.forName(className);
        Constructor<?> cons = c.getConstructor();
        Object obj = cons.newInstance();

        Method m = c.getMethod(methodName);
        m.invoke(obj);


    }
}
