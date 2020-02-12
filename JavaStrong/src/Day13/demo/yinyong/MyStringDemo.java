package Day13.demo.yinyong;

public class MyStringDemo {
    public static void main(String[] args) {

      useMyString(String::substring);

    }
    private static void useMyString(MyString m){
        String helloworld = m.mySubString("Helloworld", 0, 3);
        System.out.println(helloworld);
    }
}
