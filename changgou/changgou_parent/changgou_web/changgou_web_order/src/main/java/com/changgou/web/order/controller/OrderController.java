package com.changgou.web.order.controller;

import com.changgou.entity.Result;
import com.changgou.order.feign.CartFeign;
import com.changgou.order.feign.OrderFeign;
import com.changgou.order.pojo.Order;
import com.changgou.order.pojo.OrderItem;
import com.changgou.user.feign.AddressFeign;
import com.changgou.user.pojo.Address;
import org.bouncycastle.math.raw.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by zps on 2020/2/2 11:51
 */
@Controller
@RequestMapping("/worder")
public class OrderController {


    @Autowired
    private AddressFeign addressFeign;

    @Autowired
    private CartFeign cartFeign;


    @Autowired
    private OrderFeign orderFeign;

    /**
     * 跳转到order.html页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/ready/order")
    public String readyOrder(Model model) {
        List<Address> list = addressFeign.list().getData();
        model.addAttribute("address", list);
        //设置默认地址
        for (Address address : list) {
            if (address.getIsDefault().equals("1")) {
                model.addAttribute("deAddr", address);
                break;
            }
        }
        Map map = cartFeign.list();
        List<OrderItem> orderItemList = (List<OrderItem>) map.get("orderItemList");
        Integer totalMoney = (Integer) map.get("totalMoney");
        Integer totalNum = (Integer) map.get("totalNum");

        model.addAttribute("carts", orderItemList);
        model.addAttribute("totalMoney", totalMoney);
        model.addAttribute("totalNum", totalNum);

        return "order";
    }


    /**
     * 订单结算
     * @param order
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public Result add(@RequestBody Order order) {
        Result result = orderFeign.add(order);
        return result;
    }



    @GetMapping("/toPayPage")
    public String toPayPage(String orderId, Model model){
        Order order = orderFeign.findById(orderId).getData();
        model.addAttribute("orderId",order.getId());
        model.addAttribute("payMoney",order.getPayMoney());
        return "pay";
    }
}
