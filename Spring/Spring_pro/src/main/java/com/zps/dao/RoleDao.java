package com.zps.dao;

import com.zps.domain.Role;

import java.util.List;

public interface RoleDao {
    List<Role> list();

    void save(Role role);

}
