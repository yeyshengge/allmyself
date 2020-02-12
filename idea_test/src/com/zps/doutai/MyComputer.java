package com.zps.doutai;

public class MyComputer {

    public void PowerOn() {
        System.out.println("开机");
    }

    public void PowerOff() {
        System.out.println("关机");
    }

    public void useDevice(MyUsbInterface usb) {
        usb.openDevice();
        usb.closeDevice();

    }


}


