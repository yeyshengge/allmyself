package Day03.Work.subject5;

import Day03.Work.Inter;

public class Test {
    public static void main(String[] args) {
        A a = new A();

       /* a.methodA(new InterA() {
            @Override
            public void showA() {

            }
        });*/

       InterA i =new InterA() {
           @Override
           public void showA() {

           }
       };
       a.methodA(i);



    }
}
