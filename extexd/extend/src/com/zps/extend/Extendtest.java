package com.zps.extend;

import java.util.zip.ZipEntry;

public class Extendtest {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.method();
        Assistant assistant = new Assistant();
        assistant.method();
        System.out.println(teacher.num);
        teacher.Zi();
    }


}
