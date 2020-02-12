package day23.anli.util;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * JedisPool工具类
 * 加载配置文件，配置连接池的参数
 * 提供获取连接的方法
 */

public class JedisPoolUtils {
    private static JedisPool jedisPool;

    static {
        InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String maxTotal = properties.getProperty("maxTotal");
        String maxIdle = properties.getProperty("maxIdle");
        String host = properties.getProperty("host");
        String port = properties.getProperty("port");
        JedisPoolConfig jc = new JedisPoolConfig();
        jc.setMaxIdle(Integer.parseInt(maxIdle));
        jc.setMaxTotal(Integer.parseInt(maxTotal));
        jedisPool = new JedisPool(jc, host, Integer.parseInt(port));

    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }


}

