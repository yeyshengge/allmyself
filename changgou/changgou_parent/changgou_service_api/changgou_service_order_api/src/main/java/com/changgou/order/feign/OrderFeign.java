package com.changgou.order.feign;

import com.changgou.entity.Result;
import com.changgou.order.pojo.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by zps on 2020/2/4 13:33
 */
@FeignClient(name = "order")
public interface OrderFeign {

    //添加订单
    @PostMapping("/order")
    public Result add(@RequestBody Order order);

    //根据订单id查询
    @GetMapping("/order/{id}")
    public Result<Order> findById(@PathVariable String id);
}
