package day05.jdbc;

import day05.jdbcUtils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
事务实现转账功能
 */

public class TransactionDemo {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        ResultSet re = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql1 = "update account set balance = balance - ? where id =? ";
            String sql2 = "update account set balance = balance + ? where id =? ";

            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);

            pstmt1.setInt(1, 500);
            pstmt1.setInt(2, 1);

            pstmt2.setInt(1, 500);
            pstmt2.setInt(2, 2);

            pstmt1.executeUpdate();

            pstmt2.executeUpdate();


            conn.commit();
        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt1, re);
            JDBCUtils.close(null, pstmt2);
        }
    }
}

