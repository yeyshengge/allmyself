package Day03.Work;

class Outer {
    //��һ�ַ���
    /*
    public static Inter method(){
        Inter i =new A();
        return i;
}
*/
    //�ڶ��ַ���
  /* public static A method(){
       return new A(){
           @Override
           public void show() {
               super.show();
           }
       };
   }*/

    //�����ַ���
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
