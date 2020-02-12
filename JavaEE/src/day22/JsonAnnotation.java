package day22;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;


import java.util.*;

public class JsonAnnotation {

    @Test
    public void test01() throws JsonProcessingException {
        User user = new User();
        user.setName("张三");
        user.setAge(23);
        user.setGender("男");
        user.setBrith(new Date());

        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(user);
        System.out.println(s);
    }

    //list -> json
    @Test
    public void test02() throws JsonProcessingException {
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setName("张三");
        user.setAge(23);
        user.setGender("男");
        user.setBrith(new Date());

        User user2 = new User();
        user2.setName("张三");
        user2.setAge(23);
        user2.setGender("男");
        user2.setBrith(new Date());

        User user3 = new User();
        user3.setName("张三");
        user3.setAge(23);
        user3.setGender("男");
        user3.setBrith(new Date());

        list.add(user);
        list.add(user2);
        list.add(user3);

        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(list);
        System.out.println(s);//[{"name":"张三","age":23,"gender":"男","brith":"2019-10-20"},{"name":"张三","age":23,"gender":"男","brith":"2019-10-20"},{"name":"张三","age":23,"gender":"男","brith":"2019-10-20"}]
    }

    //map -> json
    @Test
    public void test03() throws JsonProcessingException {
        Map<String, String> map = new HashMap<>();
        map.put("姓名", "张三");
        map.put("年龄", "17");
        map.put("性别", "男");
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(map);
        System.out.println(s);
    }


    //json  -->  java
    @Test
    public void test04() throws Exception {
        String s = "{\"name\":\"张三\",\"age\":23,\"gender\":\"男\",\"brith\":\"2019-10-20\"}";
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(s, User.class);
        System.out.println(user);
    }
}
