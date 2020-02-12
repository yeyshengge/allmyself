package Day03.neibulei;

public class Outter01 {

    public void show(){

        Inter i =new Inter(){

            @Override
            public void method() {
                System.out.println("成功调用");
            }
        };
        i.method();

    }

}
