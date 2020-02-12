package day23;


import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisTest {

    /*
    快速入门
     */
    @Test
    public void test01() {
        //获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        //操作
        jedis.set("name", "zhangsan");
        //关闭流
        jedis.close();

    }

    /*
   操作String字符串
    */
    @Test
    public void test02() {
        //获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        //操作
        jedis.set("mail", "2235969355@qq.com");
        //关闭流
        jedis.close();

    }

    /*
   操作Hash
    */
    @Test
    public void test03() {
        //获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        //操作
        jedis.hset("student", "name", "zhangsan");
        jedis.hset("student", "age", "17");
        jedis.hset("student", "gender", "男");

        Map<String, String> student = jedis.hgetAll("student");
        Set<String> k = student.keySet();
        for (String key : k) {
            System.out.println(key + ":" + student.get(key));
        }
        //关闭流
        jedis.close();

    }


    /*
 操作List
  */
    @Test
    public void test04() {
        //获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        //操作
        jedis.lpush("list", "a", "b", "c");
        jedis.rpush("list", "a", "b", "c");

        List<String> list = jedis.lrange("list", 0, -1);
        System.out.println(list);//[c, b, a, a, b, c]

        //弹出左边元素
        jedis.lpop("list");
        //弹出右边元素
        jedis.rpop("list");

        List<String> list2 = jedis.lrange("list", 0, -1);
        System.out.println(list2);//[b, a, a, b]
        //关闭流
        jedis.close();

    }

    /*
  操作set
   */
    @Test
    public void test05() {
        //获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        //操作
        jedis.sadd("set", "java", "c++", "python");

        Set<String> set = jedis.smembers("set");
        System.out.println(set);
        //关闭流
        jedis.close();
    }

    /*
 操作sort
  */
    @Test
    public void test06() {
        //获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        //操作
        jedis.zadd("hero", 100, "大马西亚");
        jedis.zadd("hero", 93, "后羿");
        jedis.zadd("hero", 1, "亚瑟");

        //遍历
        Set<String> hero = jedis.zrange("hero", 0, -1);
        System.out.println(hero);
        // 关闭流
        jedis.close();

    }

    /*
操作连接池
 */
    @Test
    public void test07() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(50);
        jedisPoolConfig.setMaxIdle(10);
        //获取连接
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,"localhost",6379);
        Jedis jedis = jedisPool.getResource();
        jedis.set("hehe", "heihei");
        //操作
        String hehe = jedis.get("hehe");
        System.out.println(hehe);
        // 关闭流
        jedis.close();

    }



    /*
工具类
 */
    @Test
    public void test08() {
        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.set("heihei","hahaha");

        System.out.println(jedis.get("heihei"));
        // 关闭流
        jedis.close();

    }
}
