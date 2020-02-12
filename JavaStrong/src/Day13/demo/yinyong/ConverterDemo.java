package Day13.demo.yinyong;

public class ConverterDemo {
    public static void main(String[] args) {
        useConverter(Integer::parseInt);

    }
    public static void useConverter(Converter c){
        int convert = c.convert("555");
        System.out.println(convert);
    }
}
