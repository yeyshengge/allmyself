package Day01;

public class MyStaticDemo {
    public static void main(String[] args) {
MyStatic.university="北京大学";
        MyStatic ms= new MyStatic();
        ms.name="迪丽热巴";
        ms.age=18;
        ms.university="北京大学";
        ms.show();

        MyStatic ms2= new MyStatic();
        ms2.name="古力娜扎";
        ms2.age=19;
        ms2.university="nan ";
        ms2.show();
    }
}
