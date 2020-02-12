package cn.itcast.travel.dao;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.User;

public interface UserDaoInter {

    public User findByUsername(String username);

    public void save(User user);

    User findByCode(String code);

    void updataStatus(User user);

    User checkUsernameAndPassword(User user);


}
