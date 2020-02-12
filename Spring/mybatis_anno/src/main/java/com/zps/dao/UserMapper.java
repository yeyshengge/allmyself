package com.zps.dao;

import com.zps.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {


    @Select("select * from user where id=#{id}")
    public User findById(int id);

    @Select(" select * from user")
    public List<User> findAll();

    @Insert("insert into user values (#{id},#{username},#{password},#{birthday})")
    public void insert(User user);

    @Delete("delete from user where id = #{id}")
    public void delete(int id);

    @Update("update user set username=#{username},password=#{password} where id =#{id}")
    public void update(User user);

    @Select("select * from user")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(
                    column = "id",
                    property = "orderList",
                    javaType = List.class,
                    many = @Many(select = "com.zps.dao.OrderMapper.findByUidAll")
            )
    })
    public List<User> findUserAndOrder();


    @Select("select * from user")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(
                    column = "id",
                    javaType = List.class,
                    property = "roleList",
                    many = @Many(select = "com.zps.dao.RoleMapper.find")
            )
    })
    public List<User> findTables();

}
