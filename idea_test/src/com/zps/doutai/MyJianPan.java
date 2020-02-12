package com.zps.doutai;

public class MyJianPan implements MyUsbInterface {
    @Override
    public void closeDevice() {
        System.out.println("关闭键盘");
    }

    @Override
    public void openDevice() {
        System.out.println("打开键盘");
    }


}
