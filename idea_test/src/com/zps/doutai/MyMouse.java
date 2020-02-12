package com.zps.doutai;

public class MyMouse implements MyUsbInterface {

    @Override
    public void openDevice() {
        System.out.println("打开鼠标");
    }

    @Override
    public void closeDevice() {
        System.out.println("关闭鼠标");
    }


}
