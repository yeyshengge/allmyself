package Day03.Work;

class Outer {
    //第一种方法
    /*
    public static Inter method(){
        Inter i =new A();
        return i;
}
*/
    //第二种方法
  /* public static A method(){
       return new A(){
           @Override
           public void show() {
               super.show();
           }
       };
   }*/

    //第三种方法
    public static A method() {
        A a = new A() {
            @Override
            public void show() {
                super.show();
            }
        };
        return a;
    }


}
