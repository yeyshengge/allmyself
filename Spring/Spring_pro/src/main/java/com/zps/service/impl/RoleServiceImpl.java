package com.zps.service.impl;

import com.zps.dao.RoleDao;
import com.zps.domain.Role;
import com.zps.service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> list() {
        List<Role> list=roleDao.list();
        return list;
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }
}
