package com.zps.AWT;

import java.awt.*;

public class XiangQieDemo {
    public static void main(String[] args) {
        Panel p1, p2;
        TextArea ta;//文字域
        TextField tf;//文本框
        Label lb;//文本标签
        Button north,south,west;
        Frame myframe = new Frame("容器镶嵌");
        myframe.setSize(500, 500);
        p1= new Panel();
        p1.setBackground(Color.gray);
        p2 = new Panel();
        p2.setBackground(Color.red);
        lb = new Label("我在文本标签里");
        tf = new TextField("我在文本框里");
        ta = new TextArea("我在文本域里");
        //myframe.setLayout( new GridLayout());
        north= new Button("North");
        west = new Button("West");
        south = new Button("South");
        p1.add(north);
        p1.add(lb);
        p2.add(south);
        p2.add(tf);
        myframe.add(p1,"North");
        myframe.add(west,"West");
        myframe.add(p2,"South");
        myframe.add(ta);

        myframe.setVisible(true);





    }
}
