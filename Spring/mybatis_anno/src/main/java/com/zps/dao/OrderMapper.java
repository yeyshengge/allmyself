package com.zps.dao;

import com.zps.domain.Order;
import com.zps.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {

 /*   @Select("select *,o.id oid from orders o,user u where o.uid = u.id")
    @Results({
            @Result(column = "oid", property = "id"),
            @Result(column = "ordertime", property = "ordertime"),
            @Result(column = "total", property = "total"),
            @Result(column = "uid",property = "user.id"),
            @Result(column = "username",property = "user.username"),
            @Result(column = "password",property = "user.password"),
            @Result(column = "birthday",property = "user.birthday"),
    })
    public List<Order> findAll();*/


    @Select("select * from orders")
    @Results({
            @Result(column = "oid", property = "id"),
            @Result(column = "ordertime", property = "ordertime"),
            @Result(column = "total", property = "total"),
            @Result(
                    column = "uid",   // 外键，作为条件的键
                    property = "user",   //Order中要封装的属性名
                    javaType = User.class,  //封装属性的class
                    one = @One(select = "com.zps.dao.UserMapper.findById")
            )
    })
    public List<Order> findAll();


    @Select("select * from orders where uid=#{uid}")
    public List<Order> findByUidAll(int uid);
}
