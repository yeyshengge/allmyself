package serviceImpl;

import dao.UserDaoInter;
import daoImpl.UserDaoImpl;
import entity.User;
import service.UserListInter;

import java.util.List;

public class UserListImpl implements UserListInter {
    @Override
    public List<User> findAll() {
        UserDaoInter u = new UserDaoImpl();
        List<User> all = u.findAll();
        return all;
    }

    @Override
    public void delete(String id) {
        UserDaoInter u = new UserDaoImpl();
        u.delete(Integer.parseInt(id));
    }

    @Override
    public User huixie(int id) {
        UserDaoInter u = new UserDaoImpl();
        User user = u.huixie(id);
        return user;
    }

    @Override
    public void updata(String name, User user) {
        UserDaoInter u = new UserDaoImpl();
        u.updata(name, user);
    }

    @Override
    public int datacount(String search_name, String search_address) {
        UserDaoInter u = new UserDaoImpl();
        int datacount = u.datacount(search_name, search_address);
        return datacount;
    }

    @Override
    public List<User> limitcount(int start, int num, String search_name, String search_address) {
        UserDaoInter u = new UserDaoImpl();
        List<User> list = u.limitcount(start, num,search_name,search_address);
        return list;
    }
}
