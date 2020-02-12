package Day03.neibulei;

public class Outter {
    private int a = 5;

    private class Inner {

        public void show() {
            System.out.println(a);
        }

        }
    public void method(){
        Inner i  =new Inner();
        i.show();
    }
}
