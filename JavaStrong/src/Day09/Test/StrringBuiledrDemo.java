package Day09.Test;

/*
删除StringBuilder中的内容
 */
public class StrringBuiledrDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("adadad").append("dadad").append("大萨达");
        System.out.println(sb.toString());
        sb.delete(0, sb.length());
        System.out.println("删除后：" + sb.length());
    }
}
