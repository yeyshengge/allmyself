package Day03.neibulei;
//�ڲ������ֱ�ӷ����ⲿ��ĳ�Ա������˽��
//�ⲿ��Ҫ�Ƿ����ڲ���ĳ�Ա�����봴������
public class Demo {



    private int a = 15;
    public class Inner{
      public void show(){
          System.out.println(a+15);
      }
    }

    public void method(){
        Inner i = new Inner();
        i.show();
    }
}
