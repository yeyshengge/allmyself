package com.zps.AWT;

import java.awt.*;

public class GirdlayoutDemo {
    public static void main(String[] args) {
        Frame myframe = new Frame("举个例子");
        myframe.setSize(300, 300);
        myframe.setLayout(new GridLayout(2, 3));
        myframe.add(new Button("button1"));
        myframe.add(new Button("button2"));
        myframe.add(new Button("button3"));
        myframe.add(new Button("button4"));

        myframe.setVisible(true);
    }
}
