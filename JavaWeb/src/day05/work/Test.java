package day05.work;

import day05.jdbcUtils.JDBCUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws Exception {
        Connection conn = JDBCUtils.getConnection();
        //method01();
        //method02();
        //method03();
        //method04();
        //method05();
        method06();
    }
    /*
    7.将以上打印的结果写入到项目根路径下的sell.txt文件中，写入格式：
		Id	name	sellnumbers	sellmoney		money
		1	郭凤芝	   3	        900000	     8000
		//……
     */
    private static void method06() throws SQLException, IOException {
        String sql = "select  * from sell";
        Connection conn = JDBCUtils.getConnection();
        Statement statm = conn.createStatement();
        ResultSet re = statm.executeQuery(sql);
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\ideaspacework\\JavaWeb\\src\\day05\\work\\test"));
        while (re.next()){
            String str = re.getInt(1)+"    "+re.getString(2)+"    "+re.getInt(3)+"    "+re.getInt(4)+"    "+re.getInt(5);
            bw.write(str);
            bw.newLine();
            bw.flush();
        }
        bw.close();
        JDBCUtils.close(conn, statm,re);

    }

    //6.利用JDBC查询sell表中的全部内容并打印到控制台上，打印格式如下:
    //		1	郭凤芝	3	900000	8000
    //		//……
    private static void method05() throws SQLException {
        String sql = "select  * from sell";
        Connection conn = JDBCUtils.getConnection();
        Statement statm = conn.createStatement();
        ResultSet re = statm.executeQuery(sql);

        while (re.next()){
            System.out.println(re.getInt(1)+"    "+re.getString(2)+"    "+re.getInt(3)+"    "+re.getInt(4)+"    "+re.getInt(5));
        }
        JDBCUtils.close(conn, statm,re);

    }

    //5.利用JDBC删除10月份0销售额的员工（利用JDBC）

    private static void method04() throws SQLException {
        String sql = "delete from sell where sellmoney = 0";
        Connection conn = JDBCUtils.getConnection();
        Statement statm = conn.createStatement();

        statm.executeUpdate(sql);

        JDBCUtils.close(conn, statm);
    }



    //4.利用JDBC按照销售额的降序进行排列将销售额前三名的工资分别上涨1000,800,500（利用JDBC），并打印上涨前后的内容
    private static void method03() throws SQLException {
        String sql = "SELECT * from sell GROUP BY sellmoney desc LIMIT 0,3";
        Connection conn = JDBCUtils.getConnection();
        Statement statm = conn.createStatement();

        ResultSet re = statm.executeQuery(sql);

        int i = 0;
        while (re.next()) {
            i++;
            int id = re.getInt("id");
            int money = re.getInt("money");
            if (i == 1) {
                m1(id, money);
            }
            if (i == 2) {
                m2(id, money);
            }
            if (i == 3) {
                m3(id, money);
            }
        }


        JDBCUtils.close(conn, statm, re);
    }

    private static void m3(int id, int money) throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        System.out.println(id + "--" + money);
        String sql2 = "update sell set money =?  where id=?";
        PreparedStatement ps = conn.prepareStatement(sql2);
        ps.setInt(1, money + 500);
        ps.setInt(2, id);
        ps.executeUpdate();
        conn.close();
        ps.close();
    }

    private static void m2(int id, int money) throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        System.out.println(id + "--" + money);
        String sql2 = "update sell set money =?  where id=?";
        PreparedStatement ps = conn.prepareStatement(sql2);
        ps.setInt(1, money + 800);
        ps.setInt(2, id);
        ps.executeUpdate();
        conn.close();
        ps.close();
    }

    private static void m1(int id, int money) throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        System.out.println(id + "--" + money);
        String sql2 = "update sell set money =?  where id=?";
        PreparedStatement ps = conn.prepareStatement(sql2);
        ps.setInt(1, money + 1000);
        ps.setInt(2, id);
        ps.executeUpdate();
        conn.close();
        ps.close();
    }

    //3.计算低于平均销售额的员工姓名输出到控制台上（利用JDBC）
    private static void method02() throws SQLException {
        String sql = "SELECT * from sell WHERE sellmoney <(SELECT avg(sellmoney)  from sell)";
        Connection conn = JDBCUtils.getConnection();
        Statement statm = conn.createStatement();
        ResultSet re = statm.executeQuery(sql);

        while (re.next()) {
            String name = re.getString("name");
            System.out.println(name);
        }
        JDBCUtils.close(conn, statm, re);
    }


    //2.统计10月份“我爱你家”一共销售了多少套房源以及总销售额（利用JDBC）
    private static void method01() throws SQLException {
        String sql = "select * from sell";
        Connection conn = JDBCUtils.getConnection();
        Statement statm = conn.createStatement();
        ResultSet re = statm.executeQuery(sql);
        int sellnumbers = 0;
        int sellmoneys = 0;
        while (re.next()) {
            sellnumbers += re.getInt("sellnumbers");
            sellmoneys += re.getInt("sellmoney");
        }
        System.out.println("共销售了" + sellnumbers + "套房源以及总销售额为" + sellmoneys);
        JDBCUtils.close(conn, statm, re);
    }
}
