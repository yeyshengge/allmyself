package com.changgou.order.dao;

import com.changgou.order.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import tk.mybatis.mapper.common.Mapper;

public interface OrderMapper extends Mapper<Order> {

    //测试
    @Insert("insert into tb_order (id,create_time,update_time) value (#{id,jdbcType=TIMESTAMP},#{createTime,jdbcType=TIMESTAMP},#{updateTime,jdbcType=TIMESTAMP})")
    void insertMyself(Order order);

}
