package day06.JDBCTemplate;

import day06.druidutils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;



import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
操作表emp
1,修改1号数据为salary为10000
2,添加一条记录
3,删除刚刚添加的记录
4,查询id为1的记录,将其封装为Map集合
5,查询所有记录,将其封装为list
6,查询所有记录,将其封装为EMP对象的List集合
7,查询总记录数
 */
/*
1. 导入jar包
		2. 创建JdbcTemplate对象。依赖于数据源DataSource
			* JdbcTemplate template = new JdbcTemplate(ds);
		3. 调用JdbcTemplate的方法来完成CRUD的操作
			* update():执行DML语句。增、删、改语句
			* queryForMap():查询结果将结果集封装为map集合，将列名作为key，将值作为value 将这条记录封装为一个map集合
				* 注意：这个方法查询的结果集长度只能是1
			* queryForList():查询结果将结果集封装为list集合  结果集有多条数据的时候使用
				* 注意：将每一条记录封装为一个Map集合，再将Map集合装载到List集合中
			* query():查询结果，将结果封装为JavaBean对象
				* query的参数：RowMapper
					* 一般我们使用BeanPropertyRowMapper实现类。可以完成数据到JavaBean的自动封装
					* new BeanPropertyRowMapper<类型>(类型.class)
			* queryForObject：查询结果，将结果封装为对象
				* 一般用于聚合函数的查询
 */
public class TemplateTest {
    public static void main(String[] args) throws Exception {
        //test01();
        //test02();
        //test03();
        //test04();
        //test05();
        test05_1();
        //test06();
    }

    //6,查询所有记录,将其封装为EMP对象的List集合

    public static void test06() throws SQLException {
        JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select count(id) from emp ";
        Long l = jt.queryForObject(sql, Long.class);
        System.out.println(l);
    }

    //5,查询所有记录,将其封装为list
    public static void test05() throws SQLException {
        JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from emp ";
        List<emp> list = jt.query(sql, new RowMapper<emp>() {
            @Override
            public emp mapRow(ResultSet re, int i) throws SQLException {

                int id = re.getInt("id");
                String ename = re.getString("ename");
                int job_id = re.getInt("job_id");
                int mgr = re.getInt("mgr");
                Date joindate = re.getDate("joindate");
                double salary = re.getDouble("salary");
                double bonus = re.getDouble("bonus");
                int dept_id = re.getInt("dept_id");
                emp e = new emp(id, ename, job_id, mgr, joindate, salary, bonus, dept_id);
                return e;
            }
        });
        System.out.println(list);

    }

    //5,查询所有记录,将其封装为list
    public static void test05_1() throws SQLException {
        JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from emp ";
        //	* 一般我们使用BeanPropertyRowMapper实现类。可以完成数据到JavaBean的自动封装
        List<emp> list = jt.query(sql, new BeanPropertyRowMapper<emp>(emp.class));
        for (emp emp : list) {
            System.out.println(emp);
        }
    }

    //4,查询id为1的记录,将其封装为Map集合
    public static void test04() throws SQLException {
        JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from emp where id = ? ";
        Map<String, Object> map = jt.queryForMap(sql, 1001);
        System.out.println(map);
        Set<String> set = map.keySet();
        for (String s : set) {
            System.out.println(s + "," + map.get(s));
        }
    }

    //3,删除刚刚添加的记录
    public static void test03() throws SQLException {
        JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "delete from emp where id = ? ";
        int count = jt.update(sql, 1015);
        System.out.println(count);
    }

    //2,添加一条记录
    public static void test02() throws SQLException {
        JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "insert into emp values (?,?,?,?,?,?,?,?)";
        int count = jt.update(sql, 1015, "迪丽热巴", 4, 1001, "2019-09-24", 20000, null, 10);
        System.out.println(count);
    }

    //1,修改1号数据为salary为10000
    public static void test01() throws SQLException {
        JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "update emp set salary = ? where id =? ";
        int count = jt.update(sql, 10000, 1001);
        System.out.println(count);
    }
}
