package com.zps.doutai;

public class MyDemo {


    public static void main(String[] args) {
        MyComputer computer = new MyComputer();
        computer.PowerOn();
        MyUsbInterface usb = new MyMouse();
        computer.useDevice(usb);
        computer.PowerOff();
    }

   /* public static void UseDevice(MyComputer dd) {
        if (usb instanceof MyMouse) {
            MyMouse myMouse = (MyMouse) usb;
            myMouse.CloseHouse();
            myMouse.OpenHouse();
        }
        if (usb instanceof MyJianPan) {
            MyJianPan myJianPan = (MyJianPan) usb;
            myJianPan.CloseJianPan();
            myJianPan.OpenJianPan();
        }

    }
*/
}
