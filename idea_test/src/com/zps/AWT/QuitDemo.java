package com.zps.AWT;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuitDemo extends Frame {
    private Button quit = new Button("Quit");
    public QuitDemo() {
        super("Test Event");
        setLayout(new FlowLayout());
        add(quit);
        setVisible(true);
        setSize(500,455);
        quit.addActionListener(new ButtonHandle());
    }

    public static void main(String[] args) {
        QuitDemo a = new QuitDemo();
    }
    class ButtonHandle implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            System.out.println("要退出了"+e);
            System.exit(0);
        }
    }
}
