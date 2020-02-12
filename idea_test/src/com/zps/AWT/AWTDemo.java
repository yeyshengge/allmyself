package com.zps.AWT;

import java.awt.*;

public class AWTDemo extends Frame {


    public static void main(String[] args) {
        Frame myframe = new Frame("举个例子");
        myframe.setSize(300, 300);
        myframe.setLayout(new BorderLayout());
        myframe.add("West",new Button("button1"));
        myframe.add("North",new Button("button2"));
        myframe.add("South",new Button("button1"));
        myframe.add("East",new Button("button2"));

        myframe.setVisible(true);


    }
}
