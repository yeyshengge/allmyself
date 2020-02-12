package com.changgou.pay.controller;

import com.alibaba.fastjson.JSON;
import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.pay.config.RabbitMQConfig;
import com.changgou.pay.service.WXPayService;
import com.changgou.utils.ConvertUtils;
import com.github.wxpay.sdk.WXPayUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zps on 2020/2/9 10:40
 */
@RequestMapping("/wxpay")
@RestController
public class WXPayController {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private WXPayService wxPayService;

    /**
     * 微信支付生成二维码信息  （下单）
     *
     * @param orderId
     * @param money
     * @return
     */
    @GetMapping("/nativePay")
    public Result nativePay(@RequestParam("orderId") String orderId, @RequestParam("money") Integer money) {
        Map map = wxPayService.nativePay(orderId, money);
        return new Result(true, StatusCode.OK, "", map);
    }

    /**
     * 支付的回调方法
     * 注意：
     * 1、同样的通知可能会多次发送给商户系统。商户系统必须能够正确处理重复的通知。
     * 2、后台通知交互时，如果微信收到商户的应答不符合规范或超时，微信会判定本次通知失败，重新发送通知，直到成功为止
     * （在通知一直不成功的情况下，微信总共会发起多次通知，通知频率为15s/15s/30s/3m/10m/20m/30m/30m/30m/60m/3h/3h/3h/6h/6h - 总计 24h4m），但微信不保证通知最终一定能成功。
     */
    @RequestMapping("/notify")
    public void notifyLogic(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("支付成功回调。。。。");
        try {
            //获取回调信息
            String xml = ConvertUtils.convertToString(request.getInputStream());

            Map<String, String> map = WXPayUtil.xmlToMap(xml);

            if ("SUCCESS".equals(map.get("result_code"))) {
                //订单成功
                //获取查询订单信息
                Map resultMap = wxPayService.queryOrder(map.get("out_trade_no"));
                if ("SUCCESS".equals(resultMap.get("result_code"))) {

                    //把信息发送到rabbitmq

                    Map dataMap = new HashMap<>();
                    dataMap.put("orderId", resultMap.get("out_trade_no"));
                    dataMap.put("transactionId", resultMap.get("transaction_id"));

                    //没有定义交换机跟路由key,直接发送到ORDER_PAY队列
                    rabbitTemplate.convertAndSend("", RabbitMQConfig.ORDER_PAY, JSON.toJSONString(dataMap));
                    System.out.println("向ORDER_PAY队列发送了一条信息 ： " + JSON.toJSONString(dataMap));
                    //向跳转页面发送一条信息,把订单id发送上去
                    rabbitTemplate.convertAndSend("paynotify", "", map.get("out_trade_no"));
                    System.out.println("向支付成功跳转成功页面发送一条信息 ： " + map.get("out_trade_no"));
                } else {
                    //订单失败
                    System.out.println(map.get("err_code_des"));//错误信息描述
                }
            } else {
                //订单失败
                System.out.println(map.get("err_code_des"));//错误信息描述
            }

            //给微信确认信息
            response.setContentType("text/xml");
            String data = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
            response.getWriter().write(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 订单查询
     * @param orderId
     * @return
     */
    @GetMapping("/query/{orderId}")
    public Result queryOrder(@PathVariable("orderId") String orderId){
        Map map = wxPayService.queryOrder(orderId);
        return new Result(true,StatusCode.OK,"查询订单成功",map);
    }

    /**
     * 关闭订单
     * @param orderId
     * @return
     */
    @PutMapping("/close/{orderId}")
    public Result closeOrder(@PathVariable("orderId") String orderId){
        Map map = wxPayService.closeOrder(orderId);
        return new Result(true,StatusCode.OK,"关闭订单成功",map);
    }
}
