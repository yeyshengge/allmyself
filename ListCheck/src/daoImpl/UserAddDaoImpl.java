package daoImpl;

import dao.UserAddDaoInter;
import entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

public class UserAddDaoImpl implements UserAddDaoInter {
    @Override
    public void add(User u) {

        System.out.println(u);
        JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "insert into user (name,password,gender,age,address,qq,email) values(?,?,?,?,?,?,?)";
        jt.update(sql, u.getName(), u.getPassword(), u.getGender(), u.getAge(), u.getAddress(), u.getQq(), u.getEmail());


    }
}
