package day01.AnnotationClass;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Anno {
    //定义要调取的类的名称
    String className();

    //定义要调取该类的方法
    String methodName();
}
