package Day09.demo;



import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class BmJm {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "中国";
        byte[] bys = str.getBytes();
        System.out.println(Arrays.toString(bys));  //[-28, -72, -83, -27, -101, -67]//编码

        //byte[] bys2 ={-28, -72, -83, -27, -101, -67};
        // System.out.println(Arrays.toString(bys2));

        String s = new String(bys, "UTF-8");//解码
        System.out.println(s);

        byte[] bys3 = str.getBytes("GBK");
        System.out.println(Arrays.toString(bys3));

        String s2 = new String(bys3, "GBK");
        System.out.println(s2);

        System.out.println("---------");
        String s4 = "我爱你";

        byte[] by = s4.getBytes();
        System.out.println(Arrays.toString(by));


        String s5 = new String(by, "UTF-8");
        System.out.println(s5);

    }
}
