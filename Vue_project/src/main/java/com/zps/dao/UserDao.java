package com.zps.dao;

import com.zps.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {

    /*
    查询所有用户
     */
    @Select("select * from user")
    public List<User> findAll();

    /*
    通过id查询
     */
    @Select("select * from user where id = #{id}")
    public User findById(Integer userId);

    /**
     * 修改数据库
     *
     * @param user
     */
    @Select("update user set age=#{age},username=#{username},password=#{password},email=#{email},sex=#{sex} where id = #{id}")
    public void updateUser(User user);
}
