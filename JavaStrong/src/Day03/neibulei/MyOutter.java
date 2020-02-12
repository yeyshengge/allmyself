package Day03.neibulei;

public class MyOutter {
    private  int num =10;


    public void show(){

        class MyInner{
            int num2 =20;

            public void method(){
                System.out.println(num);
                System.out.println(num2);
            }
        }
        MyInner i = new MyInner();
        i.method();

    }


}
