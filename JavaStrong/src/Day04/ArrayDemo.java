package Day04;
//把字符串数字转换为int数组并且排序

import java.util.ArrayList;

public class ArrayDemo {

    public static void main(String[] args) {
        String str = "77 99 44 66 22 7878 45 5 32 555";
        String[] s = str.split(" ");//字符串.split可以把字符串中特定的一段提取出来；
        int[] ss = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            ss[i] = Integer.parseInt(s[i]);//把string转为int
            //System.out.println(ss[i]);
            //System.out.println(Integer.parseInt(s[i]));//String--->int

        }
        array(ss);
        String s1 = stringPj(ss);
        System.out.println(s1);

    }

    public static void array(int[] ss) {
       /* for (int j = 0; j <ss.length; j++) {
            System.out.println(ss[j]);
        }*/
        for (int a = 0; a < ss.length; a++) {
            for (int k = 0; k < ss.length - 1 - a; k++) {
                if (ss[k] > ss[k + 1]) {
                    int temp = ss[k + 1];
                    ss[k + 1] = ss[k];
                    ss[k] = temp;
                }
            }
        }
       /* for (int j = 0; j < ss.length; j++) {
            System.out.println(ss[j]);
        }*/
        stringPj(ss);
    }

    public static String stringPj(int[] ss) {

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < ss.length; i++) {
            if (i == ss.length - 1) {
                sb.append(ss[i]);
            } else {
                sb.append(ss[i] + ",");
            }
        }
       // System.out.print(sb);
       sb.append("]");

        String s =sb.toString();

        return s;
    }
}
