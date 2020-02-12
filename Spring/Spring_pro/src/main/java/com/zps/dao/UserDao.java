package com.zps.dao;

import com.zps.domain.Role;
import com.zps.domain.User;

import java.util.List;

public interface UserDao {
    List<User> list();


    List<Role> findById(Long id);

    Long save(User user);

    void saveUidAndRid(Long index, Long[] roles);

    void remove(int id);

}
