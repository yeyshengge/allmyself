package Day14.demo;

import java.util.function.Consumer;

public class ConSumerDemo02 {
    public static void main(String[] args) {
        String[] arr = {"张曼玉,22","王祖贤,33","林青霞,55"};

        /*info(arr,(s)->{
            String str=s.split(",")[0];
            System.out.print("姓名："+str+",");
        },(s -> {
            String str2 = s.split(",")[1];
            System.out.println("年龄："+str2);
        }));*/

        info(arr,s->System.out.print("姓名："+s.split(",")[0]+","),s->System.out.println("年龄："+s.split(",")[1]));


    }
    private static void info(String[] arr, Consumer<String> c1,Consumer<String> c2) {
        for (String s : arr) {
            c1.andThen(c2).accept(s);
        }
    }
}
