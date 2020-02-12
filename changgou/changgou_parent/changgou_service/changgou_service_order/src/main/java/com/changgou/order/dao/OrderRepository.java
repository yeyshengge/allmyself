
package com.changgou.order.dao;


import com.changgou.order.pojo.Order;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by zps on 2020/2/7 20:02
 */

public interface OrderRepository extends JpaRepository<Order,String> {
}

