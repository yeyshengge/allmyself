package day05.SuperMethod;

import java.sql.*;

public class Method {
    public static void main(String[] args) {
        new Method().checkAll("test01", "account");
    }

    //传入一个数据库，遍历所有数据
    private void checkAll(String dbname, String tbname) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet re = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); //"jdbc:mysql://localhost:3306/test01"
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbname, "root", "16436130");
            stmt = conn.createStatement();
            String sql = "select * from " + tbname;
            re = stmt.executeQuery(sql);
            ResultSetMetaData me = re.getMetaData();
            int column = me.getColumnCount();
            for (int i = 1; i <= column; i++) {
                System.out.print(me.getColumnName(i) + " | ");
            }
            System.out.println();
            while (re.next()) {
            for (int i = 1; i <= column; i++) {
                    Object obj = re.getObject(i);
                    System.out.print(obj+" | ");
                }
                System.out.println();
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (re != null) {
                try {
                    re.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
