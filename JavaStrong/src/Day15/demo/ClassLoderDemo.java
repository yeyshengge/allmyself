package Day15.demo;

/*
ClassLoader getParent​() 返回父类加载器进行委派。
static ClassLoader getPlatformClassLoader​() 返回用于委派的平台类加载器。
static ClassLoader getSystemClassLoader​() 返回用于委派的系统类加载器。
 */
public class ClassLoderDemo {
    public static void main(String[] args) {
        ClassLoader c1 = ClassLoader.getSystemClassLoader();
        System.out.println(c1);//AppClassLoader
        ClassLoader c2 = c1.getParent();
        System.out.println(c2);//PlatformClassLoader
        ClassLoader c3 = c2.getParent();
        System.out.println(c3);//null
    }
}
