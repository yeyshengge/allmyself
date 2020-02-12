package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.UserDaoInter;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class UserDaoImpl implements UserDaoInter {

    private JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());

    //判断用户名是否重名
    @Override
    public User findByUsername(String username) {
        User user = null;
        try {
            String sql = "select * from tab_user where username = ?";
            user = jt.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
            return user;
        } catch (Exception e) {
        }
        return user;
    }

    //存储注册信息
    @Override
    public void save(User user) {
       // System.out.println("----->" + user.getSex());
        String sql = "insert into tab_user (username,password,name,birthday,sex,telephone,email,status,code) values (?,?,?,?,?,?,?,?,?)";
        jt.update(sql, user.getUsername(), user.getPassword(), user.getName(), user.getBirthday(), user.getSex(), user.getTelephone(), user.getEmail(), user.getStatus(), user.getCode());
    }

    /**
     * 判断该code是否对应数据库的值
     *
     * @param code
     * @return
     */
    @Override
    public User findByCode(String code) {
        User user = null;
        try {
            String sql = "select * from tab_user where code = ?";
            user = jt.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), code);
        } catch (Exception e) {

        }
        return user;
    }

    /**
     * 更改status的值
     *
     * @param user
     */
    @Override
    public void updataStatus(User user) {
        String sql = "update tab_user set status = 'Y' where uid  =? ";
        jt.update(sql, user.getUid());
    }

    /**
     * 登录判断是否存在
     *
     * @param user
     * @return
     */
    @Override
    public User checkUsernameAndPassword(User user) {
        User user1 = null;
        try {
            String sql = "select * from tab_user where username = ? and password  =?";
            user1 = jt.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getUsername(), user.getPassword());
        } catch (Exception e) {
        }
        return user1;
    }
}
