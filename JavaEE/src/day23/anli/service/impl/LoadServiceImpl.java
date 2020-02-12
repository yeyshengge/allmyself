package day23.anli.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import day23.JedisPoolUtils;
import day23.anli.dao.LoadDao;
import day23.anli.dao.impl.LoadDaoImpl;
import day23.anli.service.LoadService;
import redis.clients.jedis.Jedis;

import java.util.List;

public class LoadServiceImpl implements LoadService {
    @Override
    public List load() {
        LoadDao ld = new LoadDaoImpl();
        List list = ld.load();
        return list;

    }

    @Override
    public String jsonload() {
        Jedis jedis = JedisPoolUtils.getJedis();
        String province = jedis.get("province");
        if (province == null || province.length() == 0) {
            System.out.println("没有缓存");
            LoadDao ld = new LoadDaoImpl();
            List list = ld.load();
            ObjectMapper mapper = new ObjectMapper();
            try {
                    province = mapper.writeValueAsString(list);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedis.set("province", province);
            jedis.close();
        } else {
            System.out.println("有了");
        }
        return province;
    }
}
