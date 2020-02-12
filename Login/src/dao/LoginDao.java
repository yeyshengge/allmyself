package dao;

import entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import utils.JDBCUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LoginDao {
//    public static void main(String[] args) {
//        User u  = new User("张三","123456");
//        LoginDao l = new LoginDao();
//        User login = l.login(u);
//        System.out.println(login);
//    }


    public LoginDao() {
    }

    public User login(User user) {
        User u2 = new User();
        String name = user.getUname();
        String pswd = user.getUpswd();
        JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from user";
        System.out.println("aaaa");
        //	* 一般我们使用BeanPropertyRowMapper实现类。可以完成数据到JavaBean的自动封装
        List<User> list = jt.query(sql, new BeanPropertyRowMapper<User>(User.class));
        System.out.println("bbb");
        System.out.println(list);
        int index = 0;
        for (User u : list) {
            if (u.getUname().equals(name) && u.getUpswd().equals(pswd)) {
                u2 = u;
                return u;
            } else {
                index++;
            }
        }
        if (index == list.size() - 1) {
            return null;
        } else {
            return u2;
        }
    }
}



