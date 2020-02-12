package com.zps.dao.daoImpl;

import com.zps.dao.DaoInter;
import com.zps.domain.Province;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoImpl implements DaoInter {
    public List<Province> findAll() {
        List<Province> list = new ArrayList<Province>();
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet re = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///listcheck?characterEncoding=utf-8", "root", "16436130");
            String sql = "select * from province ";
            pstmt = conn.prepareStatement(sql);
            re = pstmt.executeQuery();
            while (re.next()) {
                int id = re.getInt("id");
                String name = re.getString("name");
                list.add(new Province(id,name));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                re.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }
}
