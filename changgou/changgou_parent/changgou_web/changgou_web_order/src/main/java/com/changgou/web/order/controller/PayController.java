package com.changgou.web.order.controller;


import com.changgou.order.feign.OrderFeign;
import com.changgou.order.pojo.Order;
import com.changgou.pay.feign.PayFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Map;

/**
 * Created by zps on 2020/2/9 13:10
 */
@RequestMapping("/wxpay")
@Controller
public class PayController {


    @Autowired
    private OrderFeign orderFeign;

    @Autowired
    private PayFeign payFeign;

    @GetMapping
    public String pay(String orderId, Model model) {
        Order order = orderFeign.findById(orderId).getData();
        if (order == null) {
            return "fail";
        }
        //判断支付状态
        if (!"0".equals(order.getPayStatus())) {
            return "fail";
        }
        //获取支付后数据
        Map map = (Map) payFeign.nativePay(orderId, order.getPayMoney()).getData();

        if (map == null || map.size() <= 0) {
            return "fail";
        }
        map.put("payMoney", order.getPayMoney());
        map.put("orderId", orderId);

        model.addAllAttributes(map);
        return "wxpay";
    }

    @GetMapping("/toPaySuccess")
    public String toPaySuccess(Integer payMoney, Model model) {
        model.addAttribute("payMoney", payMoney);
        return "paysuccess";
    }
}
