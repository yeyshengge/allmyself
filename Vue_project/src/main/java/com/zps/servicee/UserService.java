package com.zps.servicee;

import com.zps.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserService {
    /*
查询所有用户
 */
    public List<User> findAll();

    /*
    通过id查询
     */
    public User findById(Integer userId);

    /**
     * 修改数据库
     *
     * @param user
     */
    public void updateUser(User user);
}
