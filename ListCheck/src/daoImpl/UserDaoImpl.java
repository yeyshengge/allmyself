package daoImpl;

import dao.UserDaoInter;
import entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;


import java.util.List;

public class UserDaoImpl implements UserDaoInter {
    private JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());


    //查找所有的用户信息
    @Override
    public List<User> findAll() {
        String sql = "select * from user limit 0,5";
        List<User> userlist = jt.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return userlist;
    }

    //通过id删除一条数据
    @Override
    public void delete(int id) {
        String sql = "delete from user where id = ?";
        jt.update(sql, id);
    }

    //回写数据
    @Override
    public User huixie(int id) {
        String sql = "select * from user where id = ? ";
        List<User> list = jt.query(sql, new BeanPropertyRowMapper<User>(User.class), id);
        return list.get(0);
    }

    //修改数据
    @Override
    public void updata(String name, User u) {
        String sql = "update user set password = ? ,gender =?,age=?,address=?,qq=?,email=? where name=?";
        jt.update(sql, u.getPassword(), u.getGender(), u.getAge(), u.getAddress(), u.getQq(), u.getEmail(), name);
    }

    //统计总条数
    @Override
    public int datacount(String search_name, String search_address) {
        String sql = "select * from user ";
        boolean a = (search_name != null && !"".equals(search_name));
        boolean b = (search_address != null && !"".equals(search_address));
        if ((a == true) && (b == true)) {
            sql = "select * from user where name = ? and address = ?";
            List<User> list = jt.query(sql, new BeanPropertyRowMapper<User>(User.class), search_name, search_address);
            return list.size();
        } else if ((a == true) && (b == false)) {
            sql = "select * from user where name = ?";
            List<User> list = jt.query(sql, new BeanPropertyRowMapper<User>(User.class), search_name);
            return list.size();
        } else if ((a == false) && (b == true)) {
            sql = "select * from user where address = ?";
            List<User> list = jt.query(sql, new BeanPropertyRowMapper<User>(User.class), search_address);
            return list.size();
        } else {
            List<User> list = jt.query(sql, new BeanPropertyRowMapper<User>(User.class));
            return list.size();
        }
    }

    //分页数据
    @Override
    public List<User> limitcount(int start, int num, String search_name, String search_address) {

        if (start <= 0) {
            start = 0;
        }

        String sql = "select * from user limit ?,?";
        List<User> list = null;
        boolean a = (search_name != null && !"".equals(search_name));
        boolean b = (search_address != null && !"".equals(search_address));
        if ((a == true) && (b == true)) {
            sql = "select * from user where name like ? and address like ? limit ?,?";
            String sb = "%" + search_name + "%";
            String sc = "%" + search_address + "%";
            list = jt.query(sql, new BeanPropertyRowMapper<User>(User.class), sb,sc, start, num);
            System.out.println("1" + list);
            return list;
        } else if ((a == true) && (b == false)) {
            sql = "select * from user where name like ? limit ?,?";
            list = jt.query(sql, new BeanPropertyRowMapper<User>(User.class), "%" + search_name + "%", start, num);
            System.out.println("2" + list);

            return list;
        } else if ((a == false) && (b == true)) {
            sql = "select * from user where address like ? limit ?,?";
            list = jt.query(sql, new BeanPropertyRowMapper<User>(User.class), "%" + search_address + "%", start, num);
            System.out.println("3" + list);

            return list;
        } else {
            list = jt.query(sql, new BeanPropertyRowMapper<User>(User.class), start, num);
            System.out.println("4" + list);

            return list;
        }
    }
}

