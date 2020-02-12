package day19.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
动态代理
 */
public class ProxyTest {
    public static void main(String[] args) {
        sellLenovo sel = new sellLenovo();
        lenovo proxy = (lenovo) Proxy.newProxyInstance(sel.getClass().getClassLoader(), sel.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] obj) throws Throwable {
                //System.out.println("该方法执行了");
                Object invoke = method.invoke(sel, 10000);
                return invoke;
            }
        });
        String sell = proxy.sell(8000);
        System.out.println("最后的输出：" + sell);
    }
}
