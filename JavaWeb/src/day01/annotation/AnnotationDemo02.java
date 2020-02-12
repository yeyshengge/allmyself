package day01.annotation;

@SuppressWarnings("all")//压制所有警告
public class AnnotationDemo02 {
    /*
    @override          检测被该注解标注的方法是否继承父类（父接口）
    @Deprecated        该标注标记的方法，表示已过时
    @SuppressWarning   压制警告，一般传递参数"all"
     */

    @Override
    public String toString() {
        return super.toString();
    }

    private void show() {

    }

    @Deprecated
    private void show1() {

    }

    private void method() {
        show1();//调用时会有横线
        show();
    }

}
