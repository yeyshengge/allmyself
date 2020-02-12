package com.zps.service;

import com.zps.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> list();

    void save(Role role);

}
