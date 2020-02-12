package Day04;

public class IntergeDemo {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println("---------");
        Integer i1 = new Integer(100);
        System.out.println(i1);

        Integer i2 = new Integer("123");
        System.out.println(i2);


        Integer i3 = Integer.valueOf(100);
        System.out.println(i3);
        Integer i4 = Integer.valueOf("123");
        System.out.println(i4);
        //Integer i5 = Integer.valueOf("adad");
        //System.out.println(i5);
    }
}
