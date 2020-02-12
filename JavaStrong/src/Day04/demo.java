package Day04;

//装箱跟拆箱
public class demo {
    public static void main(String[] args) {
        Integer i = Integer.valueOf(100);

        System.out.println(i);

        Integer ii = 100;//自动装箱；Integer.valueOf(100)

        i += 100;//相当于i=i+100; i.intValue()+100自动拆箱，然后把计算的int值自动装箱为Integer类

        Integer iii = null;//NullPointerException 对象为空不能调用方法，不然就空指针异常

        if (iii != null) {
            System.out.println(iii.intValue());

        }

        long a = Integer.MAX_VALUE;
        System.out.println(a);
    }
}
