package dao;

import entity.User;

import java.util.List;

public interface UserDaoInter {
    public List<User> findAll();

    public void delete(int id);

    public User huixie(int id);

    public void updata(String name,User user);

    public int datacount(String search_name, String search_address);

    public List<User> limitcount(int start, int num, String search_name, String search_address);
}
