package com.changgou.pay.service.impl;

import com.changgou.pay.service.WXPayService;
import com.github.wxpay.sdk.WXPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zps on 2020/2/9 10:14
 */
@Service
public class WXPayServiceImpl implements WXPayService {

    @Autowired
    private WXPay wxPay;

    @Value("${wxpay.notify_url}")
    private String notify_url;

    //微信支付
    @Override
    public Map nativePay(String orderId, Integer money) {
        try {
            Map<String, String> map = new HashMap<>();
            map.put("body", "这个商品绝对值");   //商品详情
            map.put("out_trade_no", orderId);   //商品订单号

            BigDecimal payMoney = new BigDecimal("0.01");   //单位是元 0.01元
            BigDecimal fen = payMoney.multiply(new BigDecimal("100"));  //单位是分   1分  微信只接受单位分
            /*
            参数一：保留小数点后几位数
            参数二：向上取整
             */
            fen = fen.setScale(0, BigDecimal.ROUND_UP);

            map.put("total_fee", String.valueOf(fen));     //商品价格

            //获取本机ip地址
            InetAddress address = InetAddress.getLocalHost();
            String hostAddress = address.getHostAddress();
            map.put("spbill_create_ip", hostAddress);
            //配置文件配置回调地址
            map.put("notify_url", notify_url);
            map.put("trade_type", "NATIVE");
            //获取回执信息
            Map<String, String> resultMap = wxPay.unifiedOrder(map);
            System.out.println("返回微信支付下单回执结果 ： " + resultMap);
            return resultMap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //订单查询
    @Override
    public Map queryOrder(String orderId) {
        try {
            Map<String, String> map = new HashMap<>();
            //根据商户订单号查询订单信息
            map.put("out_trade_no", orderId);
            Map<String, String> resultMap = wxPay.orderQuery(map);
            System.out.println("查询微信支付订单返回结果 ： " + resultMap);
            return resultMap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //关闭订单
    @Override
    public Map closeOrder(String orderId) {
        try {
            Map map = new HashMap();
            map.put("out_trade_no", orderId);
            Map resultMap = wxPay.closeOrder(map);
            return resultMap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
