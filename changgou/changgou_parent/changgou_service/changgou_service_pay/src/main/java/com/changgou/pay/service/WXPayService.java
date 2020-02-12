package com.changgou.pay.service;

import java.util.Map;

/**
 * Created by zps on 2020/2/9 10:12
 */
public interface WXPayService {

    //下单，微信支付
    Map nativePay(String orderId,Integer money);

    //订单查询
    Map queryOrder(String orderId);

    //关闭订单
    Map closeOrder(String orderId);

}
