package Day15.relearn;

/*
       Bootstrap                  类加载器。 它是虚拟机的内置类加载器，通常表示为null ，并且没有父null 。
       Platform class loader 。   平台类加载器可以看到所有平台类 ，可以将其用作ClassLoader实例的父ClassLoader 。
       System class loader 。     它也被称为应用程序类加载器，平台类加载器是所有平台类对其可见的系统类加载器的父级或祖先。
       static ClassLoader getSystemClassLoader​() 返回系统类加载器。
       ClassLoader getParent​()     返回父类加载器。
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        //用于获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);//jdk.internal.loader.ClassLoaders$AppClassLoader@78308db1
        //返回该类加载器的父类加载器
        ClassLoader c = systemClassLoader.getParent();
        System.out.println(c);//jdk.internal.loader.ClassLoaders$PlatformClassLoader@2d98a335
        //平台类的父类一般用null表示
        ClassLoader c1 = c.getParent();
        System.out.println(c1);//null

    }
}
